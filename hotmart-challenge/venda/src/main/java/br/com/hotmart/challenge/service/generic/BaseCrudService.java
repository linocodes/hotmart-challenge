package br.com.hotmart.challenge.service.generic;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface BaseCrudService<T, PK extends Serializable> {

	List<T> list();

	T find(PK id);

	void delete(PK id);

	T update(T entity, PK id);

	T insert(T entity);

	Page<T> pagination(Pageable pageable);

	Page<T> pagination(Specification<T> spec, Pageable pageable);

}