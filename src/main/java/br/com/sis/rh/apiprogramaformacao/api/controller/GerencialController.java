package br.com.sis.rh.apiprogramaformacao.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.vo.ParticipanteBuscaNomeDto;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;
import br.com.sis.rh.apiprogramaformacao.core.service.GerencialService;

@RestController
@RequestMapping("/gerencial")
public class GerencialController {
	
	@Autowired
	private GerencialService gerencialService;
	
	@GetMapping("/{cpf}")
	public ResponseEntity<ParticipanteBuscaNomeDto> mostraNome(@PathVariable String cpf){
		Optional<Participante> participante = gerencialService.buscaPorId(cpf);
		if(participante.isPresent()) {
			return ResponseEntity.ok(new ParticipanteBuscaNomeDto(participante.get()));
		}
		return ResponseEntity.notFound().build();
	}

}
