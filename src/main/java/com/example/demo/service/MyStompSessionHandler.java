//package com.example.demo.service;
//
//import org.springframework.messaging.simp.stomp.StompHeaders;
//import org.springframework.messaging.simp.stomp.StompSession;
//import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
//
//import java.util.List;
//import java.util.Map;
//
//public class MyStompSessionHandler extends StompSessionHandlerAdapter {
//    private void showHeaders(StompHeaders headers) {
//        System.out.println(headers.getId());
//    }
//
//    @Override
//    public void afterConnected(StompSession session,
//                               StompHeaders connectedHeaders) {
//        System.err.println("Connected! Headers:");
//        showHeaders(connectedHeaders);
//    }
//}