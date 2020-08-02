package br.com.hotmart.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.hotmart.challenge.model.entity.Produto;
import br.com.hotmart.challenge.repository.generic.BaseRepository;

@Repository
public interface ProdutoRepository extends BaseRepository<Produto, Long> {

	@Query("select p from Produto p inner join fetch p.categoria c ")
	public List<Produto> getAll();
}