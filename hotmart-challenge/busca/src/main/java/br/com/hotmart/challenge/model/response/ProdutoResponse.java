package br.com.hotmart.challenge.model.response;

import org.springframework.data.domain.Page;

import lombok.Data;

@Data
public class ProdutoResponse<T> {

	private Object termoPequisado;
	private Page<T> produto;

}
