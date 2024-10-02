package com.example.crud_practice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CrudPractice2Application {

    public static void main(String[] args) {
        SpringApplication.run(CrudPractice2Application.class, args);
    }

}
