package br.com.hotmart.challenge.model.generic;

import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable {

	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	protected Date dataCriacao;

}