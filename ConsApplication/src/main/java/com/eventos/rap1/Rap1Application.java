package com.eventos.rap1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.eventos.rap1", "com.eventos.config"})
public class Rap1Application {
    public static void main(String[] args) {
        SpringApplication.run(Rap1Application.class, args);
        System.out.println("Consumidor Rap 1 iniciado!");
    }
}