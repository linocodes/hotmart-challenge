package br.com.hotmart.challenge.repository;

import org.springframework.stereotype.Repository;

import br.com.hotmart.challenge.generic.BaseRepository;
import br.com.hotmart.challenge.model.entity.Vendedor;

@Repository
public interface VendedorRepository extends BaseRepository<Vendedor, Long> {

}