package com.eventos.main;

import com.eventos.pop.PopApplication;
import com.eventos.rap.RapApplication;
import com.eventos.rock.RockApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ConsumerApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha um gênero musical:");
        System.out.println("1 - Pop");
        System.out.println("2 - Rap");
        System.out.println("3 - Rock");
        System.out.print("Digite sua opção: ");

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1 -> {
                System.out.println("Iniciando consumidor Pop...");
                PopApplication.popRun(args);
            }
            case 2 -> {
                System.out.println("Iniciando consumidor Rap...");
                RapApplication.rapRun(args);
            }
            case 3 -> {
                System.out.println("Iniciando consumidor Rock...");
                RockApplication.rockRun(args);
            }
            default -> System.out.println("Opção inválida.");
        }
    }
}