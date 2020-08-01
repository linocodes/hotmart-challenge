package br.com.hotmart.challenge.model.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CategoriaDto implements Serializable {

	private static final long serialVersionUID = 827887514934376495L;

	private Long id;

	@NotNull
	private String nome;

}
