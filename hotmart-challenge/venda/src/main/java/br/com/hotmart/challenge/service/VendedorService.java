package br.com.hotmart.challenge.service;

import org.springframework.stereotype.Service;

import br.com.hotmart.challenge.generic.AbstractService;
import br.com.hotmart.challenge.generic.BaseRepository;
import br.com.hotmart.challenge.model.entity.Vendedor;

@Service
public class VendedorService extends AbstractService<Vendedor, Long> {

	public VendedorService(BaseRepository<Vendedor, Long> repository) {
		super(repository);
	}

	@Override
	public Vendedor carregaEntidade(Vendedor entity, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}