package com.nf.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(RedisConfig.class);
        RedisHello redisHello = context.getBean(RedisHello.class);
        redisHello.textRedisHello();
    }
}
