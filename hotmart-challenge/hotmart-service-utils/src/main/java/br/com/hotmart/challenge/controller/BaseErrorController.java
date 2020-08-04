package br.com.hotmart.challenge.controller;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import br.com.hotmart.challenge.exception.BaseException;
import br.com.hotmart.challenge.model.ErrorDetails;

@Controller
public class BaseErrorController extends AbstractErrorController {

	public BaseErrorController(final ErrorAttributes errorAttributes) {
		super(errorAttributes);
	}

	@RequestMapping("/error")
	public ResponseEntity<ErrorDetails> handleError(HttpServletRequest request) {
		Exception exception = (Exception) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);

		if (exception instanceof BaseException) {
			BaseException baseException = (BaseException) exception;
			return new ResponseEntity<>(new ErrorDetails(baseException.getMessage(), null),
					baseException.getHttpStatus());
		}

		Map<String, Object> body = this.getErrorAttributes(request, false);
		HttpStatus httpStatus = this.getStatus(request);
		String error = (String) body.get("error");
		String message = (String) body.get("message");
		String path = (String) body.get("path");
		return new ResponseEntity<>(new ErrorDetails(error, message, path), httpStatus);
	}

	@Override
	public Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
		WebRequest webRequest = new ServletWebRequest(request);
		final String details = webRequest.getDescription(true);
		@SuppressWarnings("deprecation")
		Map<String, Object> map = super.getErrorAttributes(request, includeStackTrace);
		map.put("details", details);
		return map;
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}

}