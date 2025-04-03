package com.eventos.pop2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.eventos.pop2", "com.eventos.config"})
public class Pop2Application {
    public static void main(String[] args) {
        SpringApplication.run(Pop2Application.class, args);
        System.out.println("Consumidor Pop 2 iniciado!");
    }
}