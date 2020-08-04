package br.com.hotmart.challenge.model.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AvaliaProdutoRequest implements Serializable {

	private static final long serialVersionUID = -8892111812238159726L;

	@NotNull
	private String pedido;

	private Integer nota;

}
