package com.example.demo.core.redis;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

public class RedisFactory {
    public JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConFactory = new JedisConnectionFactory();
        jedisConFactory.setHostName("localhost");
        jedisConFactory.setPort(6379);
        return jedisConFactory;
    }
}
