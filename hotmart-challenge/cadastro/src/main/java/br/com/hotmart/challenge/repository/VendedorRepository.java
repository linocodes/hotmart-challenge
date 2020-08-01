package br.com.hotmart.challenge.repository;

import org.springframework.stereotype.Repository;

import br.com.hotmart.challenge.model.entity.Vendedor;
import br.com.hotmart.challenge.repository.generic.BaseRepository;

@Repository
public interface VendedorRepository extends BaseRepository<Vendedor, Long> {

}