package com.springboot.dubbo.server;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author wh
 * @version 1.0
 * @date 2019-9-2 9:15
 */
@SpringBootApplication(scanBasePackages = "com.springboot.dubbo")
@MapperScan("com.springboot.dubbo.model")
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
