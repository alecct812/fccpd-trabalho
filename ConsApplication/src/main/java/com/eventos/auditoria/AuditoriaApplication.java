package com.eventos.auditoria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.eventos.auditoria", "com.eventos.config"})
public class AuditoriaApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuditoriaApplication.class, args);
        System.out.println("Consumidor de Auditoria iniciado!");
    }
}