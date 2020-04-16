package com.nf;

import com.nf.util.LettuceUtils;
import io.lettuce.core.api.sync.RedisCommands;

public class Main {
    public static void main(String[] args) {
        //获取commends
        RedisCommands<String,String> commands = LettuceUtils.getCommands();
        commands.lpush("myList","zhangsan");
        commands.lpush("myList","lisi");
        System.out.println(commands.lindex("myList",1));
    }
}
