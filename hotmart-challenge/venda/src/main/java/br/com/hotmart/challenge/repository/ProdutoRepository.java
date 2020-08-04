package br.com.hotmart.challenge.repository;

import org.springframework.stereotype.Repository;

import br.com.hotmart.challenge.generic.BaseRepository;
import br.com.hotmart.challenge.model.entity.Produto;

@Repository
public interface ProdutoRepository extends BaseRepository<Produto, Long> {

}