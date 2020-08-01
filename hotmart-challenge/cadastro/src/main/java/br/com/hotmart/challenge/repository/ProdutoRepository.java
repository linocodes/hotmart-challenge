package br.com.hotmart.challenge.repository;

import org.springframework.stereotype.Repository;

import br.com.hotmart.challenge.model.entity.Produto;
import br.com.hotmart.challenge.repository.generic.BaseRepository;

@Repository
public interface ProdutoRepository extends BaseRepository<Produto, Long>  {

}