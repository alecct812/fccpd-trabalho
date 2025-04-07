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
    public Queue rockAlertaQueue() {
        return new Queue("rock-informacao",false, false, true);
    }

    @Bean
    public Queue rockMudancaQueue() {
        return new Queue("rock-informacao",false, false, true);
    }

    
    // Filas para Pop
    @Bean
    public Queue popNovidadeQueue() {
        return new Queue("pop-novidade",false, false, true);
    }

    @Bean
    public Queue popAlertaQueue() {
        return new Queue("pop-informacao",false, false, true);
    }

    @Bean
    public Queue popMudancaQueue() {
        return new Queue("pop-informacao",false, false, true);
    }

    // Filas para Rap
    @Bean
    public Queue rapNovidadeQueue() {
        return new Queue("rap-novidade",false, false, true);
    }

    @Bean
    public Queue rapAlertaQueue() {
        return new Queue("rap-informacao",false, false, true);
    }

    @Bean
    public Queue rapMudancaQueue() {
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
    public Binding rockAlertaBinding(TopicExchange topicExchange, Queue rockAlertaQueue) {
        return BindingBuilder.bind(rockAlertaQueue).to(topicExchange).with("alerta.rock");
    }

    @Bean
    public Binding rockMudancaBinding(TopicExchange topicExchange, Queue rockMudancaQueue) {
        return BindingBuilder.bind(rockMudancaQueue).to(topicExchange).with("mudanca.rock");
    }

  
    // Bindings para Pop
    @Bean
    public Binding popNovidadeBinding(TopicExchange topicExchange, Queue popNovidadeQueue) {
        return BindingBuilder.bind(popNovidadeQueue).to(topicExchange).with("novidade");
    }

    @Bean
    public Binding popAlertaBinding(TopicExchange topicExchange, Queue popAlertaQueue) {
        return BindingBuilder.bind(popAlertaQueue).to(topicExchange).with("alerta.pop");
    }

    @Bean
    public Binding popMudancaBinding(TopicExchange topicExchange, Queue popMudancaQueue) {
        return BindingBuilder.bind(popMudancaQueue).to(topicExchange).with("mudanca.pop");
    }

    // Bindings para Rap
    @Bean
    public Binding rapNovidadeBinding(TopicExchange topicExchange, Queue rapNovidadeQueue) {
        return BindingBuilder.bind(rapNovidadeQueue).to(topicExchange).with("novidade");
    }

    @Bean
    public Binding rapAlertaBinding(TopicExchange topicExchange, Queue rapAlertaQueue) {
        return BindingBuilder.bind(rapAlertaQueue).to(topicExchange).with("alerta.rap");
    }

    @Bean
    public Binding rapMudancaBinding(TopicExchange topicExchange, Queue rapMudancaQueue) {
        return BindingBuilder.bind(rapMudancaQueue).to(topicExchange).with("mudanca.rap");
    }

    // Binding para Auditoria
    @Bean
    public Binding auditoriaBinding(TopicExchange topicExchange, Queue auditoriaQueue) {
        return BindingBuilder.bind(auditoriaQueue).to(topicExchange).with("#");
    }
} 