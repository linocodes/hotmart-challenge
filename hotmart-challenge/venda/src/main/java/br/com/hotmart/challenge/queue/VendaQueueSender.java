package br.com.hotmart.challenge.queue;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.hotmart.challenge.model.queue.VendaQueue;

@Component
public class VendaQueueSender {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private Queue queue;

	public void send(VendaQueue venda) {
		rabbitTemplate.convertAndSend(this.queue.getName(), venda);
	}

}