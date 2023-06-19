package com.vet.vetWorker.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@EnableRabbit
@Component
    public class RabbitMQConfig {

        private final String rabbitMQHost = "45.141.79.132";

        private final int rabbitMQPort = 5672;

        private final String rabbitMQUsername = "guest";

        private final String rabbitMQPassword = "guest";

        @Bean
        public ConnectionFactory connectionFactory() {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(rabbitMQHost);
            factory.setPort(rabbitMQPort);
            factory.setUsername(rabbitMQUsername);
            factory.setPassword(rabbitMQPassword);
            return factory;
        }

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        return new Jackson2JsonMessageConverter(objectMapper);
    }

    /*@Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, Jackson2JsonMessageConverter jsonMessageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter);

        return rabbitTemplate;
    }*/
}

