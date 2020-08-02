package br.com.hotmart.challenge.service;

import org.springframework.stereotype.Service;

import br.com.hotmart.challenge.model.entity.Venda;
import br.com.hotmart.challenge.repository.generic.BaseRepository;
import br.com.hotmart.challenge.service.generic.AbstractService;

@Service
public class VendaService extends AbstractService<Venda, Long>  {

	public VendaService(BaseRepository<Venda, Long> repository) {
		super(repository);
	}


}