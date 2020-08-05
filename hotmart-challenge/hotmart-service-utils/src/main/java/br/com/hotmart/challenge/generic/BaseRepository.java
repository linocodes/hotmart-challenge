package br.com.hotmart.challenge.generic;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface BaseRepository<T, PK extends Serializable> extends PagingAndSortingRepository<T, PK>, JpaSpecificationExecutor<T> {

}