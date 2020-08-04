package br.com.hotmart.challenge.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.messaging.handler.annotation.support.MessageHandlerMethodFactory;

import lombok.Getter;

@Getter
@Configuration
@EnableRabbit
public class ConsumerConfig implements RabbitListenerConfigurer {

	@Value("${rabbitmq.fila.filaVenda}")
	private String vendaQueue;

	@Value("${rabbitmq.fila.avaliacaoProduto}")
	private String avaliacaoProdutoQueue;

	@Bean
	public Queue vendaQueue() {
		return new Queue(getVendaQueue(), true);
	}

	@Bean
	public Queue avaliacaoProdutoQueue() {
		return new Queue(getAvaliacaoProdutoQueue(), true);
	}

	@Override
	public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
		registrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
	}

	@Bean
	MessageHandlerMethodFactory messageHandlerMethodFactory() {
		DefaultMessageHandlerMethodFactory messageHandlerMethodFactory = new DefaultMessageHandlerMethodFactory();
		messageHandlerMethodFactory.setMessageConverter(consumerJackson2MessageConverter());
		return messageHandlerMethodFactory;
	}

	@Bean
	public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
		return new MappingJackson2MessageConverter();
	}

}
