package com.example.demo.core.redis;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class CtmRedisTemplate extends RedisTemplate {

    public List<Object> getAllByKey(Object key) {
        long size = this.opsForList().size(key);
        List<Long> range = LongStream.rangeClosed(0, size - 1)
                .boxed()
                .collect(Collectors.toList());
        return range.stream().map(m -> this.opsForList().index(key, m)).collect(Collectors.toList());
    }

}
