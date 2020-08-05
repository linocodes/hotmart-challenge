package br.com.hotmart.challenge.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class Vendedor implements Serializable {

	private static final long serialVersionUID = 904740018441605422L;

	@Id
	@Column(name = "id_vendedor", nullable = false)
	@SequenceGenerator(name = "seq_vendedor", sequenceName = "seq_vendedor", allocationSize = 1)
	@GeneratedValue(generator = "seq_vendedor", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(nullable = false)
	private String nome;

}
