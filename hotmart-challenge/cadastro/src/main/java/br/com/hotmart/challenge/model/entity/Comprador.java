package br.com.hotmart.challenge.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
@Entity
public class Comprador implements Serializable {

	private static final long serialVersionUID = -3622493298889889089L;

	@Id
	@Column(name = "id_comprador", nullable = false)
	@SequenceGenerator(name = "seq_comprador", sequenceName = "seq_comprador", allocationSize = 1)
	@GeneratedValue(generator = "seq_comprador", strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotNull
	@Length(min = 1, max = 100)
	@Column(nullable = false)
	private String nome;

	@Email
	@Length(max = 100)
	private String email;

}
