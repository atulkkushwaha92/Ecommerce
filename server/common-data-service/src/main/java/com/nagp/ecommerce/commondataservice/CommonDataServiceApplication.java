package com.nagp.ecommerce.commondataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

import com.nagp.ecommerce.commondataservice.controller.CommonDataController;

@SpringBootApplication
@EnableCaching
public class CommonDataServiceApplication {

    public static void main(final String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CommonDataServiceApplication.class, args);
    }
}
