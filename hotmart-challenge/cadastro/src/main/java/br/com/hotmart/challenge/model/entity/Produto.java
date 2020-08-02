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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.hotmart.challenge.model.entity.generic.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Produto extends BaseEntity implements Serializable {

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

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] foto;

	private BigDecimal valor;
}
