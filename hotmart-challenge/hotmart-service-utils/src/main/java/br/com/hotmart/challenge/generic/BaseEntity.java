package br.com.hotmart.challenge.generic;

import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseEntity {

	private LocalDateTime dataCriacao;

	@PrePersist
	void prePersist() {
		this.dataCriacao = LocalDateTime.now();
	}

}