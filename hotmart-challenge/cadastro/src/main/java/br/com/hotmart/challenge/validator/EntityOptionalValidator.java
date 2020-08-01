package br.com.hotmart.challenge.validator;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import br.com.hotmart.challenge.exception.BaseException;

@Component
public class EntityOptionalValidator<T> {

	private final static String NOT_FOUND = "Não foram encontrados registros.";

	public void validadatorOptional(T entidade) {
		Optional.ofNullable(entidade).orElseThrow(() -> new BaseException(HttpStatus.NOT_FOUND, NOT_FOUND));
	}

	public void validadatorOptional(List<T> entidades) {
		Optional.ofNullable(entidades).orElseThrow(() -> new BaseException(HttpStatus.NOT_FOUND, NOT_FOUND));
	}

	public void validadatorOptional(Page<T> entidades) {
		Optional.ofNullable(entidades).orElseThrow(() -> new BaseException(HttpStatus.NOT_FOUND, NOT_FOUND));
	}

}