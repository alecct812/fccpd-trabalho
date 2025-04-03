package com.eventos.rock1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.eventos.rock1", "com.eventos.config"})
public class Rock1Application {
    public static void main(String[] args) {
        SpringApplication.run(Rock1Application.class, args);
        System.out.println("Consumidor Rock 1 iniciado!");
    }
}