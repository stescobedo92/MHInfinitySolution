package com.mhinfinitysolution.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.mhinfinitysolution.todo.repository")
@SpringBootApplication
public class TodoApplication {

    public static void main(String[] args) {
        System.out.println("MHInfinity Solution Todo started");
        SpringApplication.run(TodoApplication.class, args);
    }

}
