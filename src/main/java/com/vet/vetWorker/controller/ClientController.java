package com.vet.vetWorker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.GetResponse;
import com.vet.vetWorker.dto.ClientDTO;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@EnableRabbit
@RestController
@RequestMapping("/clients")
public class ClientController {
    private final String queueName = "clientsQueue";

    private final ObjectMapper objectMapper;

    private ConnectionFactory connectionFactory;

    @Autowired
    public ClientController(ObjectMapper objectMapper, ConnectionFactory connectionFactory) {
        this.objectMapper = objectMapper;
        this.connectionFactory = connectionFactory;
    }

    @GetMapping("/consume_message")
    public ResponseEntity<ClientDTO> consumeMessage() throws IOException, TimeoutException {
        try (Connection connection = connectionFactory.newConnection();
             Channel channel = connection.createChannel()) {

            channel.queueDeclare(queueName, true, false, false, null);

            GetResponse delivery = channel.basicGet(queueName, true);
            if (delivery != null) {
                ClientDTO clientDTO = objectMapper.readValue(delivery.getBody(), ClientDTO.class);
                return ResponseEntity.ok(clientDTO);
            } else
                return ResponseEntity.badRequest().body(null);
        }
    }
}
