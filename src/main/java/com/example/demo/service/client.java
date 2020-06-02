//package com.example.demo.service;
//
//import org.springframework.messaging.converter.MappingJackson2MessageConverter;
//import org.springframework.messaging.simp.stomp.StompSession;
//import org.springframework.messaging.simp.stomp.StompSessionHandler;
//import org.springframework.web.socket.client.WebSocketClient;
//import org.springframework.web.socket.client.standard.StandardWebSocketClient;
//import org.springframework.web.socket.messaging.WebSocketStompClient;
//import org.springframework.web.socket.sockjs.client.SockJsClient;
//import org.springframework.web.socket.sockjs.client.Transport;
//import org.springframework.web.socket.sockjs.client.WebSocketTransport;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class client {
//    public StompSession webSocketStompClient() throws Exception {
//        try {
//            WebSocketClient simpleWebSocketClient = new StandardWebSocketClient();
//            List<Transport> transports = new ArrayList<>(1);
//            transports.add(new WebSocketTransport(simpleWebSocketClient));
//
//            SockJsClient sockJsClient = new SockJsClient(transports);
//            WebSocketStompClient stompClient = new WebSocketStompClient(sockJsClient);
//            stompClient.setMessageConverter(new MappingJackson2MessageConverter());
//
//            StompSessionHandler sessionHandler = new MyStompSessionHandler();
//            return stompClient.connect("ws://localhost:9002/myHandler", sessionHandler).get();
//        } catch (Exception ex) {
////            logger.info("Web socket connection failed.");
//            return null;
//        }
//    }
//}
