package br.com.hotmart.challenge.model.response;

import lombok.Data;

@Data
public class RetornoResponse {

	private String status;
	private Object objeto;
	private String mensagem;

}
