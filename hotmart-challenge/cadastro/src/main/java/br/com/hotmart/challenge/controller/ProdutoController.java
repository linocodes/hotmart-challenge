package br.com.hotmart.challenge.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hotmart.challenge.model.entity.Produto;
import br.com.hotmart.challenge.service.generic.AbstractService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
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
	private AbstractService<Produto, Long> service;

	@Operation(summary = "Listar todos dos produtos")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Produtos encontrados", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Produto.class))) }),
			@ApiResponse(responseCode = "404", description = "Não existe produtos no momento", content = @Content) })
	@GetMapping
	public ResponseEntity<List<Produto>> getAllProdutos() {
		return new ResponseEntity<>(service.list(), HttpStatus.OK);
	}

	@Operation(summary = "Pesquisar o Produto por id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Produto encontrado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Produto.class)) }),
			@ApiResponse(responseCode = "400", description = "Id inválido", content = @Content),
			@ApiResponse(responseCode = "404", description = "Produto não encontrado", content = @Content) })
	@GetMapping(value = "{id}")
	public ResponseEntity<Produto> getProdutoById(
			@Parameter(description = "id do produto para pesquisa") @PathVariable("id") Long id) {
		return new ResponseEntity<>(service.find(id), HttpStatus.OK);
	}

	@Operation(summary = "Deletar o Produto")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Produto deletado"),
			@ApiResponse(responseCode = "404", description = "Bad request", content = @Content) })
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduto(
			@Parameter(description = "id do produto para deleção") @PathVariable("id") Long id) {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@Operation(summary = "Atualizar o Produto")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Produto.class)) }),
			@ApiResponse(responseCode = "404", description = "Nenhum Produto existe com o id fornecido", content = @Content) })
	@PutMapping("/{id}")
	public ResponseEntity<Produto> updateProduto(
			@Parameter(description = "id do produto para update") @PathVariable("id") Long id,
			@RequestBody Produto produto) {
		return new ResponseEntity<>(service.update(produto, id), HttpStatus.OK);
	}

	@Operation(summary = "Criar o Produto")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Produto criado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Produto.class)) }),
			@ApiResponse(responseCode = "404", description = "Bad request", content = @Content) })
	@PostMapping
	public ResponseEntity<Produto> addProduto(
			@Parameter(description = "Produto que sera criado") @RequestBody @Valid Produto produto) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(linkTo(ProdutoController.class).slash(produto.getId()).toUri());
		return new ResponseEntity<>(service.insert(produto), httpHeaders, HttpStatus.CREATED);
	}

}