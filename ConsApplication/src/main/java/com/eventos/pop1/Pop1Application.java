package com.eventos.pop1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.eventos.pop1", "com.eventos.config"})
public class Pop1Application {
    public static void main(String[] args) {
        SpringApplication.run(Pop1Application.class, args);
        System.out.println("Consumidor Pop 1 iniciado!");
    }
}