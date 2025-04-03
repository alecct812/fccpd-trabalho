package com.eventos.rap2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.eventos.rap2", "com.eventos.config"})
public class Rap2Application {
    public static void main(String[] args) {
        SpringApplication.run(Rap2Application.class, args);
        System.out.println("Consumidor Rap 2 iniciado!");
    }
}