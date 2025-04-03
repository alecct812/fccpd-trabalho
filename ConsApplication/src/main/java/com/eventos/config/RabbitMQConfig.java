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

    // Filas para Rock 1
    @Bean
    public Queue rock1NovidadeQueue() {
        return new Queue("novidade-rock1",false, false, true);
    }

    @Bean
    public Queue rock1AlertaQueue() {
        return new Queue("fila-alerta-rock1",false, false, true);
    }

    @Bean
    public Queue rock1MudancaQueue() {
        return new Queue("fila-mudanca-rock1",false, false, true);
    }

    // Filas para Rock 2
    @Bean
    public Queue rock2NovidadeQueue() {
        return new Queue("novidade-rock2",false, false, true);
    }

    @Bean
    public Queue rock2AlertaQueue() {
        return new Queue("fila-alerta-rock2",false, false, true);
    }

    @Bean
    public Queue rock2MudancaQueue() {
        return new Queue("fila-mudanca-rock2",false, false, true);
    }

    // Filas para Pop 1
    @Bean
    public Queue pop1NovidadeQueue() {
        return new Queue("novidade-pop1",false, false, true);
    }

    @Bean
    public Queue pop1AlertaQueue() {
        return new Queue("fila-alerta-pop1",false, false, true);
    }

    @Bean
    public Queue pop1MudancaQueue() {
        return new Queue("fila-mudanca-pop1",false, false, true);
    }

    // Filas para Pop 2
    @Bean
    public Queue pop2NovidadeQueue() {
        return new Queue("novidade-pop2",false, false, true);
    }

    @Bean
    public Queue pop2AlertaQueue() {
        return new Queue("fila-alerta-pop2",false, false, true);
    }

    @Bean
    public Queue pop2MudancaQueue() {
        return new Queue("fila-mudanca-pop2",false, false, true);
    }

    // Filas para Rap 1
    @Bean
    public Queue rap1NovidadeQueue() {
        return new Queue("novidade-rap1",false, false, true);
    }

    @Bean
    public Queue rap1AlertaQueue() {
        return new Queue("fila-alerta-rap1",false, false, true);
    }

    @Bean
    public Queue rap1MudancaQueue() {
        return new Queue("fila-mudanca-rap1",false, false, true);
    }

    // Filas para Rap 2
    @Bean
    public Queue rap2NovidadeQueue() {
        return new Queue("novidade-rap2",false, false, true);
    }

    @Bean
    public Queue rap2AlertaQueue() {
        return new Queue("fila-alerta-rap2",false, false, true);
    }

    @Bean
    public Queue rap2MudancaQueue() {
        return new Queue("fila-mudanca-rap2",false, false, true);
    }

    // Fila para Auditoria
    @Bean
    public Queue auditoriaQueue() {
        return new Queue("auditoria-queue",false, false, true);
    }

    // Bindings para Rock 1
    @Bean
    public Binding rock1NovidadeBinding(TopicExchange topicExchange, Queue rock1NovidadeQueue) {
        return BindingBuilder.bind(rock1NovidadeQueue).to(topicExchange).with("novidade");
    }

    @Bean
    public Binding rock1AlertaBinding(TopicExchange topicExchange, Queue rock1AlertaQueue) {
        return BindingBuilder.bind(rock1AlertaQueue).to(topicExchange).with("alerta.rock");
    }

    @Bean
    public Binding rock1MudancaBinding(TopicExchange topicExchange, Queue rock1MudancaQueue) {
        return BindingBuilder.bind(rock1MudancaQueue).to(topicExchange).with("mudanca.rock");
    }

    // Bindings para Rock 2
    @Bean
    public Binding rock2NovidadeBinding(TopicExchange topicExchange, Queue rock2NovidadeQueue) {
        return BindingBuilder.bind(rock2NovidadeQueue).to(topicExchange).with("novidade");
    }

    @Bean
    public Binding rock2AlertaBinding(TopicExchange topicExchange, Queue rock2AlertaQueue) {
        return BindingBuilder.bind(rock2AlertaQueue).to(topicExchange).with("alerta.rock");
    }

    @Bean
    public Binding rock2MudancaBinding(TopicExchange topicExchange, Queue rock2MudancaQueue) {
        return BindingBuilder.bind(rock2MudancaQueue).to(topicExchange).with("mudanca.rock");
    }

    // Bindings para Pop 1
    @Bean
    public Binding pop1NovidadeBinding(TopicExchange topicExchange, Queue pop1NovidadeQueue) {
        return BindingBuilder.bind(pop1NovidadeQueue).to(topicExchange).with("novidade");
    }

    @Bean
    public Binding pop1AlertaBinding(TopicExchange topicExchange, Queue pop1AlertaQueue) {
        return BindingBuilder.bind(pop1AlertaQueue).to(topicExchange).with("alerta.pop");
    }

    @Bean
    public Binding pop1MudancaBinding(TopicExchange topicExchange, Queue pop1MudancaQueue) {
        return BindingBuilder.bind(pop1MudancaQueue).to(topicExchange).with("mudanca.pop");
    }

    // Bindings para Pop 2
    @Bean
    public Binding pop2NovidadeBinding(TopicExchange topicExchange, Queue pop2NovidadeQueue) {
        return BindingBuilder.bind(pop2NovidadeQueue).to(topicExchange).with("novidade");
    }

    @Bean
    public Binding pop2AlertaBinding(TopicExchange topicExchange, Queue pop2AlertaQueue) {
        return BindingBuilder.bind(pop2AlertaQueue).to(topicExchange).with("alerta.pop");
    }

    @Bean
    public Binding pop2MudancaBinding(TopicExchange topicExchange, Queue pop2MudancaQueue) {
        return BindingBuilder.bind(pop2MudancaQueue).to(topicExchange).with("mudanca.pop");
    }

    // Bindings para Rap 1
    @Bean
    public Binding rap1NovidadeBinding(TopicExchange topicExchange, Queue rap1NovidadeQueue) {
        return BindingBuilder.bind(rap1NovidadeQueue).to(topicExchange).with("novidade");
    }

    @Bean
    public Binding rap1AlertaBinding(TopicExchange topicExchange, Queue rap1AlertaQueue) {
        return BindingBuilder.bind(rap1AlertaQueue).to(topicExchange).with("alerta.rap");
    }

    @Bean
    public Binding rap1MudancaBinding(TopicExchange topicExchange, Queue rap1MudancaQueue) {
        return BindingBuilder.bind(rap1MudancaQueue).to(topicExchange).with("mudanca.rap");
    }

    // Bindings para Rap 2
    @Bean
    public Binding rap2NovidadeBinding(TopicExchange topicExchange, Queue rap2NovidadeQueue) {
        return BindingBuilder.bind(rap2NovidadeQueue).to(topicExchange).with("novidade");
    }

    @Bean
    public Binding rap2AlertaBinding(TopicExchange topicExchange, Queue rap2AlertaQueue) {
        return BindingBuilder.bind(rap2AlertaQueue).to(topicExchange).with("alerta.rap");
    }

    @Bean
    public Binding rap2MudancaBinding(TopicExchange topicExchange, Queue rap2MudancaQueue) {
        return BindingBuilder.bind(rap2MudancaQueue).to(topicExchange).with("mudanca.rap");
    }

    // Binding para Auditoria
    @Bean
    public Binding auditoriaBinding(TopicExchange topicExchange, Queue auditoriaQueue) {
        return BindingBuilder.bind(auditoriaQueue).to(topicExchange).with("#");
    }
} 