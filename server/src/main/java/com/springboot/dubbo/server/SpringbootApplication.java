package com.springboot.dubbo.server;


import com.sohu.idcenter.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author wh
 * @version 1.0
 * @date 2019-9-2 9:15
 */
@SpringBootApplication(scanBasePackages = "com.springboot.dubbo")
@MapperScan("com.springboot.dubbo.model")
public class SpringbootApplication extends WebMvcConfigurationSupport {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedOrigins("*")
                .allowedMethods("*");
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(0,0,0);
    }
}
