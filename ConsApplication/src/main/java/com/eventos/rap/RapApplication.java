package com.eventos.rap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan(basePackages = {"com.eventos.rap", "com.eventos.config"})
public class RapApplication {
    public static void rapRun(String[] args) {
        SpringApplication.run(RapApplication.class, args);
        System.out.println("Consumidor Rap iniciado!");
    }
}