//package com.example.demo.core.rabbitMq;
//
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//
//public class RabbitMQFactory {
////    @Value(value = "${spring.rabbitmq.host:}")
////    private String rabbitMQHost;
////    @Value(value = "${spring.rabbitmq.username:}")
////    private String rabbitMQUsername;
////    @Value(value = "${spring.rabbitmq.password:}")
////    private String rabbitMQPassword;
//
//    public ConnectionFactory connectionFactory() {
//        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("172.16.9.3");
//        connectionFactory.setUsername("qlds");
//        connectionFactory.setPassword("ghdc@123");
//        return connectionFactory;
//    }
//}
