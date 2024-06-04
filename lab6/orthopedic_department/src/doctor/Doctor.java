package doctor;

import com.rabbitmq.client.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import common.Common;

public class Doctor {
    private final String name;

    public Doctor(String name) {
        this.name = name;
    }

    public void run() throws Exception {
        System.out.println("Doctor " + name + " started");

        // connection & channel
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // exchanges
        channel.exchangeDeclare(Common.REQUEST_EXCHANGE_NAME, "direct");
        channel.exchangeDeclare(Common.RESPONSE_EXCHANGE_NAME, "direct");
        channel.exchangeDeclare(Common.MESSAGE_EXCHANGE_NAME, "topic");

        // queues
        channel.queueDeclare(name + Common.QUEUE_SUFFIX, true, false, false, null);
        channel.queueBind(name + Common.QUEUE_SUFFIX, Common.RESPONSE_EXCHANGE_NAME, name);
        channel.queueBind(name + Common.QUEUE_SUFFIX, Common.MESSAGE_EXCHANGE_NAME, "all.*");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String message;
        String input;
        String examination;

        Consumer messageConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, StandardCharsets.UTF_8);
                System.out.println("Received message: " + message);
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };

        channel.basicConsume(name + Common.QUEUE_SUFFIX, false, messageConsumer);
        System.out.println("Enter messages to send to technicians");

        while (true) {
            input = br.readLine();
            if (input.equals("exit")) {
                break;
            }
            message = name + ":" + input;
            examination = input.split(":")[0];
            channel.basicPublish(Common.REQUEST_EXCHANGE_NAME, examination, null, message.getBytes());
            channel.basicPublish(Common.MESSAGE_EXCHANGE_NAME, "admin", null, message.getBytes());
        }

        // close
        channel.close();
        connection.close();
    }
}
