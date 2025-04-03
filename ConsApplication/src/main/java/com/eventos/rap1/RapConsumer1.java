package com.eventos.rap1;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.nio.charset.StandardCharsets;

@Component
public class RapConsumer1 {

    @RabbitListener(queues = "novidade-rap1")
    public void receiveNovidade(byte[] message) {
        System.out.println("Rap 1 recebeu novidade: " + new String(message, StandardCharsets.UTF_8));
    }

    @RabbitListener(queues = "fila-alerta-rap1")
    public void receiveAlerta(byte[] message) {
        System.out.println("Rap 1 recebeu alerta: " + new String(message, StandardCharsets.UTF_8));
    }

    @RabbitListener(queues = "fila-mudanca-rap1")
    public void receiveMudanca(byte[] message) {
        System.out.println("Rap 1 recebeu mudança: " + new String(message, StandardCharsets.UTF_8));
    }
}