package br.com.hotmart.challenge.model.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ProdutoDto implements Serializable {

	private static final long serialVersionUID = -4786069695634646242L;

	private Long id;

	@NotNull
	private String nome;

	private String descricao;


}
