package br.com.hotmart.challenge.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final HttpStatus httpStatus;
	private final String message;
	private final Object details;
	private final Throwable throwable;

	public BaseException(final HttpStatus httpStatus, final String message, final Throwable throwable,
			final Object... details) {
		this.httpStatus = httpStatus;
		this.message = message;
		this.throwable = throwable;
		this.details = details;
	}

	public BaseException(final HttpStatus httpStatus, final String message, final Object... details) {
		this.httpStatus = httpStatus;
		this.message = message;
		this.throwable = null;
		this.details = details;
	}

}
