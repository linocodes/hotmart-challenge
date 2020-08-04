package br.com.hotmart.challenge.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import br.com.hotmart.challenge.exception.BaseException;
import br.com.hotmart.challenge.generic.AbstractService;
import br.com.hotmart.challenge.generic.BaseRepository;
import br.com.hotmart.challenge.model.entity.Venda;
import br.com.hotmart.challenge.model.request.AvaliaProdutoRequest;
import br.com.hotmart.challenge.model.response.RetornoResponse;
import br.com.hotmart.challenge.queue.AvaliacaoQueueSender;
import br.com.hotmart.challenge.queue.ComunicacaoQueue;
import br.com.hotmart.challenge.repository.VendaRepository;
import br.com.hotmart.challenge.utils.Utils;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AvaliacaoService extends AbstractService<Venda, Long> {

	private static final int MAX_VALUE = 5;
	private static final int MIN_VALUE = 1;

	@Autowired
	private VendaRepository repository;

	@Autowired
	private AvaliacaoQueueSender avaliacaoQueueSender;

	public AvaliacaoService(BaseRepository<Venda, Long> repository) {
		super(repository);
	}

	public RetornoResponse avalidarProduto(AvaliaProdutoRequest request) {

		if (request.getPedido() == null) {
			throw new BaseException(HttpStatus.BAD_REQUEST, "Informe o número do pedido");
		}

		if (request.getNota() == null) {
			throw new BaseException(HttpStatus.BAD_REQUEST, "Informe o nota para o produto");
		}

		if (!Utils.between(request.getNota(), MIN_VALUE, MAX_VALUE)) {
			throw new BaseException(HttpStatus.BAD_REQUEST, "Avaliação fora do limite. Informe a nota de 1 a 5.");
		}

		Venda venda = repository.findByPedido(request.getPedido());
		if (venda != null) {
			if (venda.getAvaliacao() != null) {
				throw new BaseException(HttpStatus.BAD_REQUEST, "Existe uma avaliação registrada para esse pedido. ");
			}

			venda.setDataAvaliacao(LocalDateTime.now());
			venda.setAvaliacao(request.getNota());
			repository.save(venda);

			enviaAvaliacao(request, venda);

		} else {
			throw new BaseException(HttpStatus.BAD_REQUEST, "O pedido não foi localizado. ");
		}

		RetornoResponse retorno = new RetornoResponse();
		retorno.setStatus("ok");
		retorno.setMensagem("Sua avaliação foi registrada com sucesso.");
		return retorno;

	}

	private void enviaAvaliacao(AvaliaProdutoRequest request, Venda venda) {
		ComunicacaoQueue avaliacaoQueue = new ComunicacaoQueue();
		try {
			avaliacaoQueue.setIdProduto(venda.getProduto().getId());
			avaliacaoQueue.setDataAvaliacao(Utils.converterLocalDateTimeToDate(venda.getDataAvaliacao()));
			avaliacaoQueue.setNota(request.getNota());
			avaliacaoQueueSender.send(avaliacaoQueue);
		} catch (Exception e) {
			log.info("Ocorreu um erro enviando a avaliacao para a fila. Dado (%s)",
					Utils.converterObjectTosTring(avaliacaoQueue));
		}
	}

	@Override
	public Venda carregaEntidade(Venda entity, Long id) {
		return null;
	}

}