package com.nf.service;

import com.nf.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class StudentServiceImpl {
    @Autowired(required = false)
    private RedisTemplate redisTemplate;

    //这里是模拟数据库中的数据
    private static HashMap<Integer, Student> studentHashMap;

    static{
        studentHashMap = new HashMap<>();
        studentHashMap.put(1,new Student(1,"zhangsan"));
        studentHashMap.put(2,new Student(2,"lisi"));
    }

    @Cacheable(value="cache1",key="#id")  //这个方法使用第一套缓存的配置,@Cacheable用于查询操作
    public Student getStudentById(Integer id){
        System.out.println("get student from database");
        return studentHashMap.get(id);
    }
}
