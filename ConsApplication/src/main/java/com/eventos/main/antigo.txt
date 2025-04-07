package com.eventos.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Collections;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan(basePackages = {"com.eventos.main", "com.eventos.config"})
public class ConsumerApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha um gênero musical:");
        System.out.println("1 - Pop");
        System.out.println("2 - Rap");
        System.out.println("3 - Rock");
        System.out.print("Digite sua opção: ");

        int opcao = scanner.nextInt();
        String genero = switch (opcao) {
            case 1 -> "pop";
            case 2 -> "rap";
            case 3 -> "rock";
            default -> {
                System.out.println("Opção inválida.");
                yield null;
            }
        };

        if (genero != null) {
            SpringApplication app = new SpringApplication(ConsumerApplication.class);
            app.setDefaultProperties(Collections.singletonMap("genero.ativo", genero));
            ConfigurableApplicationContext context = app.run(args);
        }
        
        System.out.println("Consumidor " + genero.substring(0, 1).toUpperCase() + genero.substring(1) + " iniciado!");
    }
}