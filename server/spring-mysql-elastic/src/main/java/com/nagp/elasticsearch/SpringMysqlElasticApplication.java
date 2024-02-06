package com.nagp.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableElasticsearchRepositories("com.nagp.elasticsearch.repo.elastic")
@EnableScheduling
public class SpringMysqlElasticApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringMysqlElasticApplication.class, args);
    }

}
