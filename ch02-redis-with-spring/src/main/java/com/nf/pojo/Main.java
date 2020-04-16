package com.nf.pojo;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(RedisConfigWithJackson.class);
        RedisPojoHello redisHello = context.getBean(RedisPojoHello.class);
        redisHello.testRedisWithJackson();
    }
}
