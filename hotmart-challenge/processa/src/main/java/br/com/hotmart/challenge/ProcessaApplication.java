package br.com.hotmart.challenge;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class ProcessaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcessaApplication.class, args);
	}

	/*
	@RabbitListener(queues = "${hotmart.challlenge.filaVenda}")
	public void receive(Message message) {
		// simpMessagingTemplate.convertAndSend("FilaVenda",
		// new String(message.getBody()));
		String json = new String(message.getBody());
		log.info("Venda: " + json);
		// processamento(json);
	}
	*/

}
