package com.poli.fda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class FdaApplication {

    public static void main(String[] args) {
        SpringApplication.run(FdaApplication.class, args);
    }

}
