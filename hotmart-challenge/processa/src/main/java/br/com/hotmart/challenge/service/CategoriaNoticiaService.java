package br.com.hotmart.challenge.service;

import org.springframework.stereotype.Service;

import br.com.hotmart.challenge.generic.AbstractService;
import br.com.hotmart.challenge.generic.BaseRepository;
import br.com.hotmart.challenge.model.entity.CategoriaNoticia;

@Service
public class CategoriaNoticiaService extends AbstractService<CategoriaNoticia, Long> {

	public CategoriaNoticiaService(BaseRepository<CategoriaNoticia, Long> repository) {
		super(repository);
	}

	@Override
	public CategoriaNoticia carregaEntidade(CategoriaNoticia entity, Long id) {
		return null;
	}

}