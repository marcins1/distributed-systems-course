package admin;

import com.rabbitmq.client.*;
import common.Common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Admin {
    private void run() throws Exception {
        System.out.println("Admin started");

        // connection & channel
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // exchange
        channel.exchangeDeclare(Common.MESSAGE_EXCHANGE_NAME, "topic");

        // queues
        channel.queueDeclare("admin" + Common.QUEUE_SUFFIX, true, false, false, null);
        channel.queueBind("admin" + Common.QUEUE_SUFFIX, Common.MESSAGE_EXCHANGE_NAME, "admin");

        Consumer messageConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, StandardCharsets.UTF_8);
                System.out.println("Received message: " + message);
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };

        channel.basicConsume("admin" + Common.QUEUE_SUFFIX, false, messageConsumer);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String message;
        System.out.println("Enter messages to send to all employees");

        while (true) {
            message = br.readLine();
            if (message.equals("exit")) {
                break;
            }
            channel.basicPublish(Common.MESSAGE_EXCHANGE_NAME, "all.server_message", null, message.getBytes());
            System.out.println("Sent to all: " + message);
        }

        // close
        channel.close();
        connection.close();
    }

    public static void main(String[] argv) throws Exception {
        Admin admin = new Admin();
        admin.run();
    }
}
