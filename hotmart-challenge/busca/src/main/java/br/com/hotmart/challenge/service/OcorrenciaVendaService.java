package br.com.hotmart.challenge.service;

import org.springframework.stereotype.Service;

import br.com.hotmart.challenge.generic.AbstractService;
import br.com.hotmart.challenge.generic.BaseRepository;
import br.com.hotmart.challenge.model.entity.OcorrenciaVenda;

@Service
public class OcorrenciaVendaService extends AbstractService<OcorrenciaVenda, Long> {

	public OcorrenciaVendaService(BaseRepository<OcorrenciaVenda, Long> repository) {
		super(repository);
	}

	@Override
	public OcorrenciaVenda carregaEntidade(OcorrenciaVenda entity, Long id) {
		return null;
	}

}