package br.com.hotmart.challenge.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hotmart.challenge.model.request.VendaRequest;
import br.com.hotmart.challenge.model.response.RetornoResponse;
import br.com.hotmart.challenge.service.VendaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/produto/v1")
@Tag(name = "produto", description = "O Produto API com as anotações de documenentação")
public class ProdutoController {

	@Autowired
	private VendaService service;

	@Operation(summary = "Realiza a venda de um Produto")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Pedido recebido com sucesso.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = VendaRequest.class)) }),
			@ApiResponse(responseCode = "404", description = "Bad request", content = @Content) })
	@PostMapping
	public ResponseEntity<RetornoResponse> realizaVenda(
			@Parameter(description = "Dados para realizar a venda") @RequestBody @Valid VendaRequest request) {
		return new ResponseEntity<>(service.vendaProduto(request), HttpStatus.OK);
	}

}