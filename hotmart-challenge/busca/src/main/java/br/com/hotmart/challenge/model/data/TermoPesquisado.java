package br.com.hotmart.challenge.model.data;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TermoPesquisado {

	private Map<String, String> campos;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateAtual;

}
