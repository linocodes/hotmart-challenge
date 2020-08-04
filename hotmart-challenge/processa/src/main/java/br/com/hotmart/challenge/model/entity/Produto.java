package br.com.hotmart.challenge.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class Produto implements Serializable {

	private static final long serialVersionUID = -6271560923378223432L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long idProduto;

	private String nome;

	private String descricao;

	private String categoria;

	private Date dataCriacao;

}
