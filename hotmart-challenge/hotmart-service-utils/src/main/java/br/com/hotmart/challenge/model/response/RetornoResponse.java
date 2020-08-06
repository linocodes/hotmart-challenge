package br.com.hotmart.challenge.model.response;

import java.io.Serializable;

import lombok.Data;

@Data
public class RetornoResponse implements Serializable {

	private static final long serialVersionUID = -2903012115674645368L;

	private String status;
	private String mensagem;

}
