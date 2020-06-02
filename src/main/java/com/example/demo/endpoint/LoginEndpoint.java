package com.example.demo.endpoint;

import com.example.demo.configuration.ThreadLocalStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginEndpoint {
    @Autowired
    public SimpMessagingTemplate messagingTemplate;

    @PostMapping("/login")
    @PreAuthorize()
    public Object login() {
        Map<String, Object> map = new HashMap<>();
        String username = ThreadLocalStorage.getProfile().get("username");
        map.put("token", ThreadLocalStorage.getToken().get("token"));
        map.put("username", username);
        this.messagingTemplate.convertAndSendToUser(username, "/queue/" + username, username);
        return map;
    }
}
