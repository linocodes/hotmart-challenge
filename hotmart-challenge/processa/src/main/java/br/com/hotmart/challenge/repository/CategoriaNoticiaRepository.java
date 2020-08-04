package br.com.hotmart.challenge.repository;

import org.springframework.stereotype.Repository;

import br.com.hotmart.challenge.generic.BaseRepository;
import br.com.hotmart.challenge.model.entity.CategoriaNoticia;

@Repository
public interface CategoriaNoticiaRepository extends BaseRepository<CategoriaNoticia, Long> {

}