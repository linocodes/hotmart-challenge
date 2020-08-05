package br.com.hotmart.challenge.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

/**
 * A tabela categoria esta preenchida com todas as categorias existentes
 * atualmente no <strong>NEW_API</strong> Desta forma seria a primeira solução
 * para reduzir as requisições na api. Caso api crie outra categoria basta
 * inserir na base de dados. não acho interessante ler a api
 * https://newsapi.org/v2/sources" todas as vezes pois isso é algo que nao muda
 * com frequencia.
 *
 * @author Marcelo Lino
 *
 */

@Cacheable
@Data
@Entity
public class Categoria implements Serializable {

	private static final long serialVersionUID = -6271560923378223432L;

	@Id
	private String categoria;

	private Date dataProcessamento;

	private Integer quantidade;

}
