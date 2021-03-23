package com.example.crm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.example.crm"})
@MapperScan(basePackages = {"com.example.crm.mapper"})
public class CrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrmApplication.class, args);
    }

//    @Bean
//    public PasswordEncoder creatPasswordEncoder(){
//        return new BCryptPasswordEncoder();//进行密码进行多次MD5加盐
//    }
}
