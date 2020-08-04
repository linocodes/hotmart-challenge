package br.com.hotmart.challenge.queue;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hotmart.challenge.service.AvaliacaoProdutoService;
import br.com.hotmart.challenge.service.ProdutoService;

@Service
public class ConsumerQueue {

	@Autowired
	private AvaliacaoProdutoService avaliacaoService;

	@Autowired
	private ProdutoService produtoService;

	@RabbitListener(queues = "${rabbitmq.fila.filaVenda}")
	public void receiveVenda(Message message) {
		String json = new String(message.getBody());
		produtoService.processamento(json);
	}

	@RabbitListener(queues = "${rabbitmq.fila.avaliacaoProduto}")
	public void receiveAvaliacao(Message message) {
		String json = new String(message.getBody());
		avaliacaoService.processamento(json);
	}

}