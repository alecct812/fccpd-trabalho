package com.eventos.rock2;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.nio.charset.StandardCharsets;

@Component
public class RockConsumer2 {

    @RabbitListener(queues = "novidade-rock2")
    public void receiveNovidade(byte[] message) {
        System.out.println("Rock 2 recebeu novidade: " + new String(message, StandardCharsets.UTF_8));
    }

    @RabbitListener(queues = "fila-alerta-rock2")
    public void receiveAlerta(byte[] message) {
        System.out.println("Rock 2 recebeu alerta: " + new String(message, StandardCharsets.UTF_8));
    }

    @RabbitListener(queues = "fila-mudanca-rock2")
    public void receiveMudanca(byte[] message) {
        System.out.println("Rock 2 recebeu mudança: " + new String(message, StandardCharsets.UTF_8));
    }
}