package technician;

import com.rabbitmq.client.*;
import common.Common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Technician {
    private final String name;
    private final String type1;
    private final String type2;

    public Technician(String name, String type1, String type2) {
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
    }

    private String getQueueName(String type) {
        return switch (type) {
            case "Hip" -> Common.HIP_QUEUE_NAME;
            case "Knee" -> Common.KNEE_QUEUE_NAME;
            default -> Common.ELBOW_QUEUE_NAME;
        };
    }

    public void run() throws Exception {
        System.out.println("Technician " + name + " started");

        // connection & channel
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.basicQos(1);

        // exchanges
        channel.exchangeDeclare(Common.REQUEST_EXCHANGE_NAME, "direct");
        channel.exchangeDeclare(Common.RESPONSE_EXCHANGE_NAME, "direct");
        channel.exchangeDeclare(Common.MESSAGE_EXCHANGE_NAME, "topic");

        // queues
        channel.queueDeclare(getQueueName(type1), true, false, false, null);
        channel.queueBind(getQueueName(type1), Common.REQUEST_EXCHANGE_NAME, type1);
        channel.queueDeclare(getQueueName(type2), true, false, false, null);
        channel.queueBind(getQueueName(type2), Common.REQUEST_EXCHANGE_NAME, type2);
        channel.queueDeclare(name + Common.QUEUE_SUFFIX, true, false, false, null);
        channel.queueBind(name + Common.QUEUE_SUFFIX, Common.MESSAGE_EXCHANGE_NAME, "all.*");

        Consumer doctorMessageConsumer = new DefaultConsumer(channel) {
            String doctorName;
            String examination;
            String patient;

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, StandardCharsets.UTF_8);
                System.out.println("Message received: " + message);
                doctorName = message.split(":")[0];
                examination = message.split(":")[1];
                patient = message.split(":")[2];
                channel.basicAck(envelope.getDeliveryTag(), false);
                System.out.println("Finished examination, sending response to " + doctorName);
                String response = name + " " + patient + " " + examination + " done";
                channel.basicPublish(Common.MESSAGE_EXCHANGE_NAME, "admin", null, response.getBytes());
                channel.basicPublish(Common.RESPONSE_EXCHANGE_NAME, doctorName, null, response.getBytes());
            }
        };

        Consumer serverMessageConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, StandardCharsets.UTF_8);
                System.out.println("Message received from server: " + message);
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };

        channel.basicConsume(getQueueName(type1), false, doctorMessageConsumer);
        channel.basicConsume(getQueueName(type2), false, doctorMessageConsumer);
        channel.basicConsume(name + Common.QUEUE_SUFFIX, false, serverMessageConsumer);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        System.out.println("Enter exit to close technician");

        do {
            input = br.readLine();
        } while (!input.equals("exit"));

        // close
        channel.close();
        connection.close();
    }
}
