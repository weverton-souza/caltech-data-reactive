package org.caltech.data.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class CaltechDataReactiveApplication {
    public static void main(String[] args) {
        SpringApplication.run(CaltechDataReactiveApplication.class, args);
    }
}
