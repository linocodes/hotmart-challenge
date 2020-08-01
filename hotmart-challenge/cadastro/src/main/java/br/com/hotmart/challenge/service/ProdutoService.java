package br.com.hotmart.challenge.service;

import org.springframework.stereotype.Service;

import br.com.hotmart.challenge.model.entity.Produto;
import br.com.hotmart.challenge.repository.generic.BaseRepository;
import br.com.hotmart.challenge.service.generic.AbstractService;

@Service
public class ProdutoService extends AbstractService<Produto, Long> {

	public ProdutoService(BaseRepository<Produto, Long> repository) {
		super(repository);
	}

}