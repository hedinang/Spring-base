//package com.example.demo.endpoint;
//
//import com.example.demo.configuration.ThreadLocalStorage;
//import org.springframework.expression.Expression;
//import org.springframework.expression.ExpressionParser;
//import org.springframework.expression.spel.standard.SpelExpressionParser;
//import org.springframework.messaging.handler.annotation.SendTo;
//
////@Controller
//public class MessageEndpoint {
//    String username = ThreadLocalStorage.getProfile().get("username");
//    ExpressionParser parser = new SpelExpressionParser();
//    Expression exp = parser.parseExpression("new ");
//
////    @MessageMapping("/chat")
//    @SendTo("/ds/ds/{id}")
//    public Object send() throws Exception {
//        ThreadLocalStorage.getProfile().get("username")
//        String time = new SimpleDateFormat("HH:mm").format(new Date());
//        return new OutputMessage(message.getFrom(), message.getText(), time);
//    }
//}
