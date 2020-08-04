package br.com.hotmart.challenge.service;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.hotmart.challenge.generic.AbstractService;
import br.com.hotmart.challenge.generic.BaseRepository;
import br.com.hotmart.challenge.model.entity.AvaliacaoProduto;
import br.com.hotmart.challenge.queue.ComunicacaoQueue;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AvaliacaoProdutoService extends AbstractService<AvaliacaoProduto, Long> {

	public AvaliacaoProdutoService(BaseRepository<AvaliacaoProduto, Long> repository) {
		super(repository);
	}

	@Override
	public AvaliacaoProduto carregaEntidade(AvaliacaoProduto entity, Long id) {
		return null;
	}


	public void processamento(String json) {
		ObjectMapper objectMapper = new ObjectMapper();
		ComunicacaoQueue dadosRecebidos;
		try {
			dadosRecebidos = objectMapper.readValue(json, ComunicacaoQueue.class);
			avaliacaoProduto(dadosRecebidos);
		} catch (Exception e) {
			log.info("Ocorreu um erro durante o parse do json. Valor rebebido da fila avaliação. (%s)",json);
		}
	}

	private void avaliacaoProduto(ComunicacaoQueue dadosRecebidos) {
		insert(AvaliacaoProduto.builder()
				.idProduto(dadosRecebidos.getIdProduto())
				.dataAvaliacao(dadosRecebidos.getDataAvaliacao())
				.nota(dadosRecebidos.getNota())
				.build());
	}

}