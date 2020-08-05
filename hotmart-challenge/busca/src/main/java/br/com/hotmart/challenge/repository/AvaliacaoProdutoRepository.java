package br.com.hotmart.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.hotmart.challenge.generic.BaseRepository;
import br.com.hotmart.challenge.model.data.Notas;
import br.com.hotmart.challenge.model.entity.AvaliacaoProduto;

@Repository
public interface AvaliacaoProdutoRepository extends BaseRepository<AvaliacaoProduto, Long> {

	@Query("select new br.com.hotmart.challenge.model.data.Notas(a.idProduto, sum(a.nota)) from AvaliacaoProduto a group by a.idProduto ")
	public List<Notas> calculaNotaProduto();

}