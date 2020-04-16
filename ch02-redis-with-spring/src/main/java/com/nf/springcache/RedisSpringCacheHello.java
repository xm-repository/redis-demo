package com.nf.springcache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RedisSpringCacheHello {
    @Autowired
    private StudentServiceImpl service;

    public void testRedisSpringCache(){
        Student student1 = service.getStudentById(1);
        System.out.println(student1);
        Student student2 = service.getStudentById(1);
        System.out.println(student2);
    }

}
