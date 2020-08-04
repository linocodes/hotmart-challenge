package br.com.hotmart.challenge.model.response;

import java.io.Serializable;

import lombok.Data;

@Data
public class RetornoResponse implements Serializable {

	private static final long serialVersionUID = 8537743102844088918L;

	private String pedido;
}
