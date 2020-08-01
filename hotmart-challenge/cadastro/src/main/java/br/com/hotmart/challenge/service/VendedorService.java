package br.com.hotmart.challenge.service;

import org.springframework.stereotype.Service;

import br.com.hotmart.challenge.model.entity.Vendedor;
import br.com.hotmart.challenge.repository.generic.BaseRepository;
import br.com.hotmart.challenge.service.generic.AbstractService;

@Service
public class VendedorService extends AbstractService<Vendedor, Long> {

	public VendedorService(BaseRepository<Vendedor, Long> repository) {
		super(repository);
	}

}