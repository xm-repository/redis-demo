package com.nf.util;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.api.sync.RedisCommands;

public class LettuceUtils {
    //连接只需要一个
    private static StatefulRedisConnection<String,String> redisConnection;

    static {
        RedisURI redisURI = RedisURI.Builder.redis("localhost",6379).withPassword("root").build();
        RedisClient redisClient = RedisClient.create(redisURI);
        redisConnection = redisClient.connect();
    }

    //获取同步命令
    public static RedisCommands<String,String> getCommands(){
        return redisConnection.sync();
    }

    //获取异步命令
    public static RedisAsyncCommands<String,String> getAsyncCommands(){
        return redisConnection.async();
    }
}
