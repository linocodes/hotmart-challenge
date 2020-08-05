package br.com.hotmart.challenge.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Cacheable
@Data
@Builder
@Entity
public class AvaliacaoProduto implements Serializable {

	private static final long serialVersionUID = -6271560923378223432L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long idProduto;

	private Date dataAvaliacao;

	private Integer nota;

}
