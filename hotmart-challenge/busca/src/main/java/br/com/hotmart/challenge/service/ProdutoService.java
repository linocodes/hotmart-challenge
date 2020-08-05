package br.com.hotmart.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.hotmart.challenge.generic.AbstractService;
import br.com.hotmart.challenge.generic.BaseRepository;
import br.com.hotmart.challenge.model.entity.OcorrenciaVenda;
import br.com.hotmart.challenge.model.entity.Produto;
import br.com.hotmart.challenge.queue.ComunicacaoQueue;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProdutoService extends AbstractService<Produto, Long> {

	@Autowired
	private OcorrenciaVendaService service;

	public ProdutoService(BaseRepository<Produto, Long> repository) {
		super(repository);
	}

	@Override
	public Produto carregaEntidade(Produto entity, Long id) {
		return null;
	}

	public void processamento(String json) {
		ObjectMapper objectMapper = new ObjectMapper();
		ComunicacaoQueue dadosRecebidos;
		try {
			dadosRecebidos = objectMapper.readValue(json, ComunicacaoQueue.class);
			inclusaoProduto(dadosRecebidos);
			ocorrenciaVenda(dadosRecebidos);
		} catch (Exception e) {
			log.info("Ocorreu um erro durante o parse do json. Valor rebebido da fila venda. (%s)",json);
		}
	}

	private void inclusaoProduto(ComunicacaoQueue dadosRecebidos) {

		if (!existsById(dadosRecebidos.getIdProduto())) {
			insert(Produto.builder()
					.categoria(dadosRecebidos.getCategoria())
					.dataCriacao(dadosRecebidos.getDataCriacao())
					.descricao(dadosRecebidos.getDescricao())
					.nome(dadosRecebidos.getNome())
					.idProduto(dadosRecebidos.getIdProduto())
					.build());
		}

	}

	private void ocorrenciaVenda(ComunicacaoQueue dadosRecebidos) {

		service.insert(OcorrenciaVenda.builder()
				.idProduto(dadosRecebidos.getIdProduto())
				.dataVenda(dadosRecebidos.getDataVenda())
				.quantidade(dadosRecebidos.getQuantidade())
				.build());

	}

}