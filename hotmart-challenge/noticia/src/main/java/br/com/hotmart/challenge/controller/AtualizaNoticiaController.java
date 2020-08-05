package br.com.hotmart.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hotmart.challenge.service.CargaCategoriaNoticiaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/carga-noticia/v1")
@Tag(name = "noticia", description = "Serviço de carga de noticias.")
public class AtualizaNoticiaController {

	@Autowired
	private CargaCategoriaNoticiaService service;

	@Operation(summary = "Realiza a carga das noticias sem aguardar o tempo exigido.")
	@PostMapping
	public ResponseEntity<Void> executaSchedule() {
		service.offScheduleNews();
		return new ResponseEntity<>(HttpStatus.OK);
	}

}