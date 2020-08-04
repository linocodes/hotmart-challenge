package br.com.hotmart.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.hotmart.challenge.exception.BaseException;
import br.com.hotmart.challenge.generic.AbstractService;
import br.com.hotmart.challenge.generic.BaseRepository;
import br.com.hotmart.challenge.model.entity.Venda;
import br.com.hotmart.challenge.model.request.AvaliaProdutoRequest;
import br.com.hotmart.challenge.model.response.RetornoResponse;
import br.com.hotmart.challenge.repository.VendaRepository;

@Service
public class VendaService extends AbstractService<Venda, Long> {

	@Autowired
	private VendaRepository repository;

	public VendaService(BaseRepository<Venda, Long> repository) {
		super(repository);
	}

	public RetornoResponse avalidarProduto(AvaliaProdutoRequest request) {

		if (request.getPedido() == null) {
			throw new BaseException(HttpStatus.BAD_REQUEST, "Informe o número do pedido");
		}

		if (request.getNota() == null) {
			throw new BaseException(HttpStatus.BAD_REQUEST, "Informe o nota para o produto");
		}

		if (request.getNota() < 1 || request.getNota() > 5) {
			throw new BaseException(HttpStatus.BAD_REQUEST, "Avaliação fora do limite. Informe a nota de 1 a 5.");
		}

		Venda venda = repository.findByPedido(request.getPedido());
		if (venda != null) {
			venda.setAvaliacao(request.getNota());
			repository.save(venda);
		} else {
			throw new BaseException(HttpStatus.BAD_REQUEST, "O pedido não foi localizado. ");
		}

		RetornoResponse retorno = new RetornoResponse();
		retorno.setStatus("ok");
		retorno.setMensagem("Sua avaliação foi registrada com sucesso.");
		return retorno;

	}

	@Override
	public Venda carregaEntidade(Venda entity, Long id) {
		return null;
	}

}