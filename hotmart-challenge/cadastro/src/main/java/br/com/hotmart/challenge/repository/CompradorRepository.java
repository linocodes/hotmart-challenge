package br.com.hotmart.challenge.repository;

import org.springframework.stereotype.Repository;

import br.com.hotmart.challenge.model.entity.Comprador;
import br.com.hotmart.challenge.repository.generic.BaseRepository;

@Repository
public interface CompradorRepository extends BaseRepository<Comprador, Long> {

}