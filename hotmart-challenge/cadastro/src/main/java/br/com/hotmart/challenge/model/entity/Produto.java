package br.com.hotmart.challenge.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.hotmart.challenge.model.generic.Auditable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Produto extends Auditable implements Serializable {

	private static final long serialVersionUID = -6271560923378223432L;

	@Id
	@Column(name = "id_produto", nullable = false)
	@SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto", allocationSize = 1)
	@GeneratedValue(generator = "seq_produto", strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotNull
	@Length(min = 1, max = 100)
	@Column(nullable = false)
	private String nome;

	@Length(min = 0, max = 2000)
	@Column(nullable = false)
	private String descricao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] foto;

	private BigDecimal valor;
}
