package br.com.hotmart.challenge.model.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ProdutoDto implements Serializable {

	private static final long serialVersionUID = -4786069695634646242L;

	private Long id;

	private String nome;

	private String categoria;

}
