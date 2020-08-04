package br.com.hotmart.challenge.service;

import org.springframework.stereotype.Service;

import br.com.hotmart.challenge.generic.AbstractService;
import br.com.hotmart.challenge.generic.BaseRepository;
import br.com.hotmart.challenge.model.entity.Produto;

@Service
public  class ProdutoService extends AbstractService<Produto, Long> {

	public ProdutoService(BaseRepository<Produto, Long> repository) {
		super(repository);
	}

	@Override
	public Produto carregaEntidade(Produto entity, Long id) {
		// TODO Auto-generated method stub
		return null;
	}


}