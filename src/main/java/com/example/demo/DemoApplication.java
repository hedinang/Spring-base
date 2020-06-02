package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ImportResource;

import javax.annotation.Resource;
import javax.annotation.Resources;

@SpringBootApplication
@ImportResource()
//@EnableTransactionManagement
//@EnableJpaRepositories
public class DemoApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DemoApplication.class, args);
    }

}
