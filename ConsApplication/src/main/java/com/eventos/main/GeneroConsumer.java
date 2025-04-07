package com.eventos.main;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class GeneroConsumer {

    @Value("${genero.ativo}")
    private String generoAtivo;

    // NOVIDADES
    @RabbitListener(queues = "pop-novidade")
    public void consumirPop(byte[] message) {
        System.out.println("Pop recebeu: " + new String(message, StandardCharsets.UTF_8));
    }

    @RabbitListener(queues = "rap-novidade")
    public void consumirRap(byte[] message) {
        System.out.println("Rap recebeu: " + new String(message, StandardCharsets.UTF_8));
    }

    @RabbitListener(queues = "rock-novidade")
    public void consumirRock(byte[] message) {
        System.out.println("Rock recebeu: " + new String(message, StandardCharsets.UTF_8));
    }

    // ALERTAS E MUDANÇAS
    @RabbitListener(queues = "pop-informacao")
    public void receiveAlertaPop(byte[] message) {
        if (generoAtivo.equals("pop")) {
            System.out.println("Pop recebeu alerta: " + new String(message, StandardCharsets.UTF_8));
        }
    }

    @RabbitListener(queues = "pop-informacao")
    public void receiveMudancaPop(byte[] message) {
        if (generoAtivo.equals("pop")) {
            System.out.println("Pop recebeu mudança: " + new String(message, StandardCharsets.UTF_8));
        }
    }

    @RabbitListener(queues = "rap-informacao")
    public void receiveAlertaRap(byte[] message) {
        if (generoAtivo.equals("rap")) {
            System.out.println("Rap recebeu alerta: " + new String(message, StandardCharsets.UTF_8));
        }
    }

    @RabbitListener(queues = "rap-informacao")
    public void receiveMudancaRap(byte[] message) {
        if (generoAtivo.equals("rap")) {
            System.out.println("Rap recebeu mudança: " + new String(message, StandardCharsets.UTF_8));
        }
    }

    @RabbitListener(queues = "rock-informacao")
    public void receiveAlertaRock(byte[] message) {
        if (generoAtivo.equals("rock")) {
            System.out.println("Rock recebeu alerta: " + new String(message, StandardCharsets.UTF_8));
        }
    }

    @RabbitListener(queues = "rock-informacao")
    public void receiveMudancaRock(byte[] message) {
        if (generoAtivo.equals("rock")) {
            System.out.println("Rock recebeu mudança: " + new String(message, StandardCharsets.UTF_8));
        }
    }
}
