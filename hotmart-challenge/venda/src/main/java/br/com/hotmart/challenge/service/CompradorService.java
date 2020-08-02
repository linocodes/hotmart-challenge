package br.com.hotmart.challenge.service;

import org.springframework.stereotype.Service;

import br.com.hotmart.challenge.model.entity.Comprador;
import br.com.hotmart.challenge.repository.generic.BaseRepository;
import br.com.hotmart.challenge.service.generic.AbstractService;

@Service
public class CompradorService extends AbstractService<Comprador, Long> {

	public CompradorService(BaseRepository<Comprador, Long> repository) {
		super(repository);
	}

}