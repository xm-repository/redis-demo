package com.nf.springcache;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(RedisSpringCacheConfig.class);
        RedisSpringCacheHello hello = context.getBean(RedisSpringCacheHello.class);
        hello.testRedisSpringCache();
    }
}
