package com.eventos.rock2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.eventos.rock2", "com.eventos.config"})
public class Rock2Application {
    public static void main(String[] args) {
        SpringApplication.run(Rock2Application.class, args);
        System.out.println("Consumidor Rock 2 iniciado!");
    }
} 