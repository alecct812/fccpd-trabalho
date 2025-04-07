package com.eventos.rap;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.nio.charset.StandardCharsets;

@Component
public class RapConsumer {

    @RabbitListener(queues = "rap-novidade")
    public void receiveNovidade(byte[] message) {
        System.out.println("Rap recebeu novidade: " + new String(message, StandardCharsets.UTF_8));
    }

    @RabbitListener(queues = "rap-informacao")
    public void receiveAlerta(byte[] message) {
        System.out.println("Rap recebeu alerta: " + new String(message, StandardCharsets.UTF_8));
    }

    @RabbitListener(queues = "rap-informacao")
    public void receiveMudanca(byte[] message) {
        System.out.println("Rap recebeu mudança: " + new String(message, StandardCharsets.UTF_8));
    }
}