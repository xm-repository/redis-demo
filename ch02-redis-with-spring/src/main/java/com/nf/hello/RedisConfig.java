package com.nf.hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
@ComponentScan("com.nf.hello")
public class RedisConfig {
    //得到连接工厂
    @Bean
    public LettuceConnectionFactory lettuceConnectionFactory(){
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration("localhost",6379);
        configuration.setPassword("root");
        return new LettuceConnectionFactory(configuration);
    }
    @Bean
    public StringRedisTemplate redisTemplate(){
        return new StringRedisTemplate(lettuceConnectionFactory());
    }
}
