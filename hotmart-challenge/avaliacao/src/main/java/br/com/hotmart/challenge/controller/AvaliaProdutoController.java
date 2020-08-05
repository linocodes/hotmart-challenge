package br.com.hotmart.challenge.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hotmart.challenge.model.request.AvaliaProdutoRequest;
import br.com.hotmart.challenge.model.response.RetornoResponse;
import br.com.hotmart.challenge.service.AvaliacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/nota-produto/v1")
@Tag(name = "avaliacao", description = "Avaliação do produto adquirido.")
public class AvaliaProdutoController {

	@Autowired
	private AvaliacaoService service;

	@Operation(summary = "Avaliar o produto adquirido")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Produto avaliado com sucesso", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = AvaliaProdutoRequest.class)) }),
			@ApiResponse(responseCode = "404", description = "Bad request", content = @Content) })
	@PostMapping
	public ResponseEntity<RetornoResponse> realizaVenda(
			@Parameter(description = "Número do pedido que será avaliado") @RequestBody @Valid AvaliaProdutoRequest request) {
		return new ResponseEntity<>(service.avalidarProduto(request), HttpStatus.OK);
	}

}