package com.edu.cqie;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.edu.cqie.mapper")
public class PersonBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonBlogApplication.class, args);
    }

}
