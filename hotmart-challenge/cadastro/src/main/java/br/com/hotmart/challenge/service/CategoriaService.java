package br.com.hotmart.challenge.service;

import org.springframework.stereotype.Service;

import br.com.hotmart.challenge.model.entity.Categoria;
import br.com.hotmart.challenge.repository.generic.BaseRepository;
import br.com.hotmart.challenge.service.generic.AbstractService;

@Service
public class CategoriaService extends AbstractService<Categoria, Long> {



	public CategoriaService(BaseRepository<Categoria, Long> repository) {
		super(repository);
	}

}