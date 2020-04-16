package com.nf;

import com.nf.service.StudentServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootApp {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringbootApp.class);

        StudentServiceImpl service = context.getBean(StudentServiceImpl.class);
        service.getStudentById(1);
        service.getStudentById(1);
    }
}
