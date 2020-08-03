package br.com.hotmart.challenge.service;

import org.springframework.stereotype.Service;

import br.com.hotmart.challenge.generic.AbstractService;
import br.com.hotmart.challenge.generic.BaseRepository;
import br.com.hotmart.challenge.model.entity.Categoria;

@Service
public class CategoriaService extends AbstractService<Categoria, Long> {

	public CategoriaService(BaseRepository<Categoria, Long> repository) {
		super(repository);
	}

	@Override
	public Categoria carregaEntidade(Categoria entity, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}