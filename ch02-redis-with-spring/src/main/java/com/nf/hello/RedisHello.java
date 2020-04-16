package com.nf.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisHello {
    @Autowired
    private RedisTemplate redisTemplate;

    public void textRedisHello(){
        ValueOperations  valueOperations = redisTemplate.opsForValue();
        valueOperations.set("username","lisi");
    }
}
