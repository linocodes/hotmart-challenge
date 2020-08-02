package br.com.hotmart.challenge.repository;

import org.springframework.stereotype.Repository;

import br.com.hotmart.challenge.model.entity.Venda;
import br.com.hotmart.challenge.repository.generic.BaseRepository;

@Repository
public interface VendaRepository extends BaseRepository<Venda, Long> {

}