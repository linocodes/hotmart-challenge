package br.com.hotmart.challenge.model.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class VendaRequest implements Serializable {

	private static final long serialVersionUID = -6271560923378223432L;

	private Long idProduto;
	private Long idVendedor;
	private Long idComprador;
	private Integer quantidade;

}
