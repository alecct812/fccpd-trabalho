package com.eventos.pop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.eventos.pop", "com.eventos.config"})
public class PopApplication {
    public static void main(String[] args) {
        SpringApplication.run(PopApplication.class, args);
        System.out.println("Consumidor Pop iniciado!");
        
        
    }
}