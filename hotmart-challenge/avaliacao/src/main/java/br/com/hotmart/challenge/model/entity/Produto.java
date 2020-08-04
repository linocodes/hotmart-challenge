package br.com.hotmart.challenge.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
@Entity
public class Produto implements Serializable {

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

}
