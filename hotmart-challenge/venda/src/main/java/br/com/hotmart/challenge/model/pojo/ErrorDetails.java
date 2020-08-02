
package br.com.hotmart.challenge.model.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorDetails {

	@JsonIgnore
	private final SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private String date;
	private String message;
	private String originalMessage;
	private Object details;

	public ErrorDetails() {
		this.date = fmt.format(new Date());
	}

	public ErrorDetails(final String message, final Object details) {
		this.date = fmt.format(new Date());
		this.message = message;
		this.details = details;
	}

	public ErrorDetails(final String message, final String originalMessage, final Object details) {
		this.date = fmt.format(new Date());
		this.message = message;
		this.originalMessage = originalMessage;
		this.details = details;
	}

}
