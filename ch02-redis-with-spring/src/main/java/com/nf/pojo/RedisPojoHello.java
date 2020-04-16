package com.nf.pojo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisPojoHello {
    @Autowired
    private RedisTemplate redisTemplate;

    public  void testRedisWithJackson(){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        User user = new User(1000,"xiaomin");
        valueOperations.set("user",user);
    }
}
