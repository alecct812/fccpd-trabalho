package com.eventos.pop;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.nio.charset.StandardCharsets;

@Component
public class PopConsumer {

    @RabbitListener(queues = "pop-novidade")
    public void receiveNovidade(byte[] message) {
        System.out.println("Pop recebeu novidade: " + new String(message, StandardCharsets.UTF_8));
    }

    @RabbitListener(queues = "pop-informacao")
    public void receiveAlerta(byte[] message) {
        System.out.println("Pop recebeu alerta: " + new String(message, StandardCharsets.UTF_8));
    }

    @RabbitListener(queues = "pop-informacao")
    public void receiveMudanca(byte[] message) {
        System.out.println("Pop recebeu mudança: " + new String(message, StandardCharsets.UTF_8));
    }
}