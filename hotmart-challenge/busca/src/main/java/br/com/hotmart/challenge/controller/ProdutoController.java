package br.com.hotmart.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hotmart.challenge.model.dto.ProdutoDto;
import br.com.hotmart.challenge.model.entity.Produto;
import br.com.hotmart.challenge.model.response.ProdutoResponse;
import br.com.hotmart.challenge.service.BuscaProdutoServiceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/busca-produto/v1")
@Tag(name = "produto", description = "Busca o produto conforme  score")
public class ProdutoController {

	@Autowired
	private BuscaProdutoServiceService service;

	@Operation(summary = "Listar todos dos produtos e o respectivo score")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Produtos encontrados", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProdutoResponse.class))) }),
			@ApiResponse(responseCode = "404", description = "Não existe produtos no momento", content = @Content) })
	@GetMapping
	public ResponseEntity<ProdutoResponse<Produto>> buscaProduto(ProdutoDto request,  @PageableDefault(size = 20) Pageable pageable) {
		return new ResponseEntity<>(
				service.buscaProduto(request, PageRequest.of(pageable.getPageNumber(), pageable.getPageSize())),
				HttpStatus.OK);
	}

}