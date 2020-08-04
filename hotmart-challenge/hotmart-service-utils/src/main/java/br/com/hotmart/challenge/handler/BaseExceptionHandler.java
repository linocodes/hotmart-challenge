package br.com.hotmart.challenge.handler;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.StringUtils;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.hotmart.challenge.exception.BaseException;
import br.com.hotmart.challenge.model.ErrorDetails;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class BaseExceptionHandler {

	private final ObjectMapper mapper = new ObjectMapper();

	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public final ResponseEntity<ErrorDetails> handle(final HttpMediaTypeNotSupportedException ex,
			final WebRequest request) {
		return new ResponseEntity<>(errorDetails(ex, request), HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public final ResponseEntity<ErrorDetails> handle(final HttpMessageNotReadableException ex,
			final WebRequest request) {
		return new ResponseEntity<>(errorDetails(ex, request), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public final ResponseEntity<ErrorDetails> handle(final HttpRequestMethodNotSupportedException ex,
			final WebRequest request) {
		return new ResponseEntity<>(errorDetails(ex, request), HttpStatus.METHOD_NOT_ALLOWED);
	}

	@ExceptionHandler(HttpStatusCodeException.class)
	public final ResponseEntity<ErrorDetails> handle(final HttpStatusCodeException ex, final WebRequest request) {
		String body = ex.getResponseBodyAsString();
		if (StringUtils.isEmpty(body)) {
			body = ex.getStatusText();
		}
		log.error(body);
		return new ResponseEntity<>(errorDetails(body, ex, request), ex.getStatusCode());
	}

	@ExceptionHandler(BaseException.class)
	public final ResponseEntity<ErrorDetails> handle(final BaseException ex, final WebRequest request) {
		ErrorDetails errorDetails = errorDetails(ex, request);
		if (ex.getThrowable() instanceof HttpClientErrorException
				&& !((HttpClientErrorException) ex.getThrowable()).getResponseBodyAsString().isEmpty()) {
			final HttpClientErrorException error = (HttpClientErrorException) ex.getThrowable();
			log.error(error.getResponseBodyAsString());
			try {
				errorDetails = mapper.readValue(error.getResponseBodyAsString(), ErrorDetails.class);
			} catch (final IOException e) {
				log.error(e.getMessage(), e);
			}
			return new ResponseEntity<>(errorDetails, ex.getHttpStatus());
		}
		return new ResponseEntity<>(errorDetails, ex.getHttpStatus());
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public final ResponseEntity<ErrorDetails> handle(final IllegalArgumentException ex, final WebRequest request) {
		return new ResponseEntity<>(errorDetails(ex, request), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(JsonMappingException.class)
	public final ResponseEntity<ErrorDetails> handle(final JsonMappingException ex, final WebRequest request) {
		return new ResponseEntity<>(errorDetails(ex, request), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public void constraintViolationException(HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.BAD_REQUEST.value());
	}

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", new Date());
		body.put("status", status.value());

		// Get all errors
		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());

		body.put("errors", errors);
		return new ResponseEntity<>(body, headers, status);

	}

	private ErrorDetails errorDetails(final Exception ex, final WebRequest request) {
		return new ErrorDetails(ex.getMessage(), getDetails(ex, request));
	}

	private ErrorDetails errorDetails(final String message, final Exception ex, final WebRequest request) {
		return new ErrorDetails(message, ex.getMessage(), getDetails(ex, request));
	}

	private Object getDetails(final Exception exception, final WebRequest request) {
		log.error(exception.getMessage());
		Object details = null;
		if (exception instanceof BaseException) {
			details = ((BaseException) exception).getDetails();
		} else {
			details = request.getDescription(false);
		}
		return details;
	}

}