package br.com.hotmart.challenge.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hotmart.challenge.model.dto.VendaDto;
import br.com.hotmart.challenge.model.entity.Produto;
import br.com.hotmart.challenge.model.entity.Venda;
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
			@ApiResponse(responseCode = "201", description = "Produto criado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Produto.class)) }),
			@ApiResponse(responseCode = "404", description = "Bad request", content = @Content) })
	@PostMapping
	public ResponseEntity<Venda> realizaVenda(
			@Parameter(description = "Produto que sera criado") @RequestBody @Valid Venda venda) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(linkTo(ProdutoController.class).slash(venda.getId()).toUri());
		return new ResponseEntity<>(service.insert(venda), httpHeaders, HttpStatus.CREATED);
	}

}