package br.com.hotmart.challenge.service.generic;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;

import br.com.hotmart.challenge.exception.BaseException;
import br.com.hotmart.challenge.repository.generic.BaseRepository;
import br.com.hotmart.challenge.validator.EntityOptionalValidator;

public abstract class AbstractService<T, PK extends Serializable> implements BaseCrudService<T, PK> {

	private BaseRepository<T, PK> repository;

	@Autowired
	private EntityOptionalValidator<T> validarEntidade;

	public AbstractService(BaseRepository<T, PK> repository) {
		this.repository = repository;
	}

	@Override
	public List<T> list() {
		List<T> list = repository.findAll();
		validarEntidade.validadatorOptional(list);
		return list;
	}

	@Override
	public T find(PK id) {
		Optional<T> entity = repository.findById(id);
		validarEntidade.validadatorOptional(entity.get());
		return entity.get();
	}

	@Override
	public void delete(PK id) {
		boolean exists = repository.existsById(id);
		if (!exists) {
			throw new BaseException(HttpStatus.NOT_FOUND,
					String.format("O registro informado para exclusão não existe. Id (%s)", id));
		}

		try {
			repository.deleteById(id);
		} catch (Exception e) {
			throw new BaseException(HttpStatus.BAD_REQUEST,
					String.format("Ocorreu um problema durante a exclusão do registro (%s)", id));
		}

	}

	@Override
	public T update(T entity, PK id) {
		try {
			repository.saveAndFlush(entity);
			return entity;
		} catch (Exception e) {
			throw new BaseException(HttpStatus.BAD_REQUEST,
					String.format("Ocorreu um problema durante a atualização do registro (%s)", id));
		}

	}

	@Override
	public T insert(T entity) {

		try {
			repository.saveAndFlush(entity);
			return entity;
		} catch (Exception e) {
			throw new BaseException(HttpStatus.BAD_REQUEST, "Ocorreu um problema durante a inclusão do registro");
		}
	}

	@Override
	public Page<T> pagination(Pageable pageable) {
		Page<T> list = repository.findAll(pageable);
		validarEntidade.validadatorOptional(list);
		return list;
	}

	@Override
	public Page<T> pagination(Specification<T> specification, Pageable pageable) {
		Page<T> list = repository.findAll(specification, pageable);
		validarEntidade.validadatorOptional(list);
		return list;
	}

}