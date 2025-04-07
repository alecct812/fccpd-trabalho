package com.eventos.rock;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.nio.charset.StandardCharsets;

@Component
public class RockConsumer {

    @RabbitListener(queues = "rock-novidade")
    public void receiveNovidade(byte[] message) {
        System.out.println("Rock recebeu novidade: " + new String(message, StandardCharsets.UTF_8));
    }

    @RabbitListener(queues = "rock-informacao")
    public void receiveAlerta(byte[] message) {
        System.out.println("Rock recebeu alerta: " + new String(message, StandardCharsets.UTF_8));
    }

    @RabbitListener(queues = "rock-informacao")
    public void receiveMudanca(byte[] message) {
        System.out.println("Rock recebeu mudança: " + new String(message, StandardCharsets.UTF_8));
    }
} 