package com.nf.pojo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@ComponentScan("com.nf.pojo")
public class RedisConfigWithJackson {
    //得到连接工厂
    @Bean
    public LettuceConnectionFactory getConnectionFactory(){
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration("localhost",6379);
        configuration.setPassword("root");
        return new LettuceConnectionFactory(configuration);
    }

    @Bean
    public RedisTemplate redisTemplate(){
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(getConnectionFactory());

        //设置键的序列化器
        //使用StringRedisSerializer作为key的序列化器
        StringRedisSerializer keySerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(keySerializer);
        //设置hash键或字段的序列化器//可选的设置？？hash的键和字段都用这个序列化器
//        redisTemplate.setHashKeySerializer(keySerializer);

        //设置值的序列化器
        //使用Jackson2JsonRedisSerializer作为value的序列化器
        GenericJackson2JsonRedisSerializer valueSerializer = new GenericJackson2JsonRedisSerializer();
        redisTemplate.setValueSerializer(valueSerializer);
        //可选的设置??
        redisTemplate.setHashValueSerializer(valueSerializer);
        return redisTemplate;
    }
}
