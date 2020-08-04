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
public class Categoria implements Serializable {

	private static final long serialVersionUID = 624034362040674901L;

	@Id
	@Column(name = "id_categoria", nullable = false)
	@SequenceGenerator(name = "seq_categoria", sequenceName = "seq_categoria", allocationSize = 1)
	@GeneratedValue(generator = "seq_categoria", strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotNull
	@Length(min = 1, max = 100)
	@Column(nullable = false)
	private String nome;

}
