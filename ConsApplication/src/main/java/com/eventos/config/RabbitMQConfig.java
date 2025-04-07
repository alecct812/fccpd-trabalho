package com.eventos.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topic-exchange");
    }

    // Filas para Rock
    @Bean
    public Queue rockNovidadeQueue() {
        return new Queue("rock-novidade",false, false, true);
    }

    @Bean
    public Queue rockInformacaoQueue() {
        return new Queue("rock-informacao",false, false, true);
    }
    
    // Filas para Pop
    @Bean
    public Queue popNovidadeQueue() {
        return new Queue("pop-novidade",false, false, true);
    }

    @Bean
    public Queue popInformacaoQueue() {
        return new Queue("pop-informacao",false, false, true);
    }

    // Filas para Rap
    @Bean
    public Queue rapNovidadeQueue() {
        return new Queue("rap-novidade",false, false, true);
    }

    @Bean
    public Queue rapInformacaoQueue() {
        return new Queue("rap-informacao",false, false, true);
    }

    // Fila para Auditoria
    @Bean
    public Queue auditoriaQueue() {
        return new Queue("auditoria-queue",false, false, true);
    }

    // Bindings para Rock
    @Bean
    public Binding rockNovidadeBinding(TopicExchange topicExchange, Queue rockNovidadeQueue) {
        return BindingBuilder.bind(rockNovidadeQueue).to(topicExchange).with("novidade");
    }

    @Bean
    public Binding rockAlertaBinding(TopicExchange topicExchange, Queue rockInformacaoQueue) {
        return BindingBuilder.bind(rockInformacaoQueue).to(topicExchange).with("alerta.rock");
    }

    @Bean
    public Binding rockMudancaBinding(TopicExchange topicExchange, Queue rockInformacaoQueue) {
        return BindingBuilder.bind(rockInformacaoQueue).to(topicExchange).with("mudanca.rock");
    }

  
    // Bindings para Pop
    @Bean
    public Binding popNovidadeBinding(TopicExchange topicExchange, Queue popNovidadeQueue) {
        return BindingBuilder.bind(popNovidadeQueue).to(topicExchange).with("novidade");
    }

    @Bean
    public Binding popAlertaBinding(TopicExchange topicExchange, Queue popInformacaoQueue) {
        return BindingBuilder.bind(popInformacaoQueue).to(topicExchange).with("alerta.pop");
    }

    @Bean
    public Binding popMudancaBinding(TopicExchange topicExchange, Queue popInformacaoQueue) {
        return BindingBuilder.bind(popInformacaoQueue).to(topicExchange).with("mudanca.pop");
    }

    // Bindings para Rap
    @Bean
    public Binding rapNovidadeBinding(TopicExchange topicExchange, Queue rapNovidadeQueue) {
        return BindingBuilder.bind(rapNovidadeQueue).to(topicExchange).with("novidade");
    }

    @Bean
    public Binding rapAlertaBinding(TopicExchange topicExchange, Queue rapInformacaoQueue) {
        return BindingBuilder.bind(rapInformacaoQueue).to(topicExchange).with("alerta.rap");
    }

    @Bean
    public Binding rapMudancaBinding(TopicExchange topicExchange, Queue rapInformacaoQueue) {
        return BindingBuilder.bind(rapInformacaoQueue).to(topicExchange).with("mudanca.rap");
    }

    // Binding para Auditoria
    @Bean
    public Binding auditoriaBinding(TopicExchange topicExchange, Queue auditoriaQueue) {
        return BindingBuilder.bind(auditoriaQueue).to(topicExchange).with("#");
    }
} 