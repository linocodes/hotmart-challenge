package br.com.hotmart.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.hotmart.challenge.generic.BaseRepository;
import br.com.hotmart.challenge.model.data.QuantidadeVendida;
import br.com.hotmart.challenge.model.entity.OcorrenciaVenda;

@Repository
public interface OcorrenciaVendaRepository extends BaseRepository<OcorrenciaVenda, Long> {

	@Query("select new br.com.hotmart.challenge.model.data.QuantidadeVendida(a.idProduto, sum(a.quantidade)) from OcorrenciaVenda a group by a.idProduto ")
	public List<QuantidadeVendida> calculaVendasProduto();

}