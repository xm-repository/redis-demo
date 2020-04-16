package com.nf.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableCaching
public class SpringCacheConfig {

    //连接工厂信息在yml中配置


    //缓存管理器
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory){

        //但一般默认配置都不符合要求，一般都会手动重新配置
        //可以有多套缓存配置,用一个map集合
        Map<String, RedisCacheConfiguration> map = new HashMap<>();
        //这里调用方法生成一个配置类
        map.put("cache1",initRedisCacheConfiguration(30l));//第一套配置
        map.put("cache2",initRedisCacheConfiguration(60l));//第二套配置

        return RedisCacheManager
                .builder((redisConnectionFactory))
                .withInitialCacheConfigurations(map).build();
    }

    //Redis缓存配置对象(这个方法是可以自己任意设计的,目的就是返回一个缓存配置对象)
    public RedisCacheConfiguration initRedisCacheConfiguration(Long ttl){
        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();

        return cacheConfiguration
                //设置键的序列化器
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))//括号里这里可以更精简一点 fromSerializer(RedisSerializer.string())
                //使用jackson作为值的序列化器
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()))//括号里这里可以更精简一点 fromSerializer(RedisSerializer.json())
                //缓存过期时间
                .entryTtl(Duration.ofSeconds(ttl))
                //设置键名字的前缀
                .computePrefixWith(cacheName ->"projectname".concat(":").concat(cacheName).concat(":"));
    }
}
