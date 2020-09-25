package com.cubewealth.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cubewealth.dto.EventDto;

@Service
public class RabbitMQSender {
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("${cubewealth.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${cubewealth.rabbitmq.routingkey}")
	private String routingkey;	
	
	public void send(EventDto event) {
		rabbitTemplate.convertAndSend(exchange, routingkey, event);
	}
}
