package dev.kulick.startproject.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class RabbitConfig {

    @Value("${app.exchange}")
    private String exchange;

    @Value("${app.routing.toB}")
    private String routingKeyB;

    @Value("${app.queue.b}")
    private String queueB;

    @Bean
    public Queue queueB() {
        return new Queue(queueB, false);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    public Binding bindingB(Queue queueB,
            DirectExchange exchange) {
        return BindingBuilder.bind(queueB).to(exchange).with(routingKeyB);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory cf) {
        RabbitTemplate template = new RabbitTemplate(cf);
        template.setMessageConverter(messageConverter());
        return template;
    }
}