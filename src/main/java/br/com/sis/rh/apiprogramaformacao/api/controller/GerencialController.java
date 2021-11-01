package br.com.sis.rh.apiprogramaformacao.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ParticipanteBuscaNomeDto;
import br.com.sis.rh.apiprogramaformacao.core.service.GerencialService;

@RestController
@RequestMapping("/api/gerencial")
public class GerencialController {

	@Autowired
	private GerencialService gerencialService;

	@GetMapping("/{cpf}")
	public ResponseEntity<ParticipanteBuscaNomeDto> mostraNome(@PathVariable String cpf){
		return gerencialService.buscaPorId(cpf);
	}

}
