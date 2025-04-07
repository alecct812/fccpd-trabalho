package com.eventos.rock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.eventos.rock", "com.eventos.config"})
public class RockApplication {
    public static void main(String[] args) {
        SpringApplication.run(RockApplication.class, args);
        System.out.println("Consumidor Rock iniciado!");
    }
}