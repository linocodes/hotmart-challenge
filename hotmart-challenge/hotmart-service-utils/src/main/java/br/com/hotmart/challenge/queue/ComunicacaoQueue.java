package br.com.hotmart.challenge.queue;

import java.util.Date;

import lombok.Data;

@Data
public class ComunicacaoQueue {

	private Long idProduto;
	private String nome;
	private String descricao;
	private String categoria;
	private Date dataCriacao;
	private Date dataAvaliacao;
	private Date dataVenda;
	private Integer quantidade;
	private Integer nota;

}
