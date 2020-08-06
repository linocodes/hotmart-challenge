package br.com.hotmart.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hotmart.challenge.model.response.RetornoResponse;
import br.com.hotmart.challenge.service.CargaCategoriaNoticiaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/carga-noticia/v1")
@Tag(name = "noticia", description = "Serviço de carga de noticias.")
public class AtualizaNoticiaController {

	@Autowired
	private CargaCategoriaNoticiaService service;


	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Procedimento realizado com sucesso", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = RetornoResponse.class)) }),
			@ApiResponse(responseCode = "404", description = "Ocorreu um erro ao executar o processamento", content = @Content) })
	@Operation(summary = "Realiza a carga das noticias sem aguardar o tempo exigido.")
	@PostMapping
	public ResponseEntity<RetornoResponse> executaSchedule() {
		return new ResponseEntity<>(service.offScheduleNews(), HttpStatus.OK);
	}

}