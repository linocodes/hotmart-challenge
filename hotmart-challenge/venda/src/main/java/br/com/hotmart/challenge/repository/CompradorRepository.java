package br.com.hotmart.challenge.repository;

import org.springframework.stereotype.Repository;

import br.com.hotmart.challenge.generic.BaseRepository;
import br.com.hotmart.challenge.model.entity.Comprador;

@Repository
public interface CompradorRepository extends BaseRepository<Comprador, Long> {

}