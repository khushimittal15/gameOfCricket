package com.example.springcricket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication
public class SpringCricketApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCricketApplication.class, args);
    }

}
