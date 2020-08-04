package br.com.hotmart.challenge.service;

import org.springframework.stereotype.Service;

import br.com.hotmart.challenge.generic.AbstractService;
import br.com.hotmart.challenge.generic.BaseRepository;
import br.com.hotmart.challenge.model.entity.Comprador;

@Service
public  class CompradorService extends AbstractService<Comprador, Long> {

	public CompradorService(BaseRepository<Comprador, Long> repository) {
		super(repository);
	}

	@Override
	public Comprador carregaEntidade(Comprador entity, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}