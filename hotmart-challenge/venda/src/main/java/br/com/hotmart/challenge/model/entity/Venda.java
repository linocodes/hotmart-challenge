package br.com.hotmart.challenge.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;

import br.com.hotmart.challenge.model.entity.generic.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Venda extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 2458199174637546109L;

	@Id
	@Column(name = "id_venda", nullable = false)
	@SequenceGenerator(name = "seq_venda", sequenceName = "seq_venda", allocationSize = 1)
	@GeneratedValue(generator = "seq_venda", strategy = GenerationType.SEQUENCE)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_vendedor")
	private Vendedor vendedor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_comprador")
	private Comprador comprador;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_produto")
	private Produto produto;

	@NotNull
	private String pedido;

	private Integer quantidade;

}
