package com.eventos.pop2;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.nio.charset.StandardCharsets;

@Component
public class PopConsumer2 {

    @RabbitListener(queues = "novidade-pop2")
    public void receiveNovidade(byte[] message) {
        System.out.println("Pop 2 recebeu novidade: " + new String(message, StandardCharsets.UTF_8));
    }

    @RabbitListener(queues = "fila-alerta-pop2")
    public void receiveAlerta(byte[] message) {
        System.out.println("Pop 2 recebeu alerta: " + new String(message, StandardCharsets.UTF_8));
    }

    @RabbitListener(queues = "fila-mudanca-pop2")
    public void receiveMudanca(byte[] message) {
        System.out.println("Pop 2 recebeu mudança: " + new String(message, StandardCharsets.UTF_8));
    }
}