package br.com.hotmart.challenge.repository;

import org.springframework.stereotype.Repository;

import br.com.hotmart.challenge.model.entity.Categoria;
import br.com.hotmart.challenge.repository.generic.BaseRepository;

@Repository
public interface CategoriaRepository extends BaseRepository<Categoria, Long> {

}