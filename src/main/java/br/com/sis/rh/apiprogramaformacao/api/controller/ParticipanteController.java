package br.com.sis.rh.apiprogramaformacao.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ParticipanteBuscaDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ParticipanteBuscaNomeDto;
import br.com.sis.rh.apiprogramaformacao.core.service.ParticipanteService;

@RestController
@RequestMapping("/api/participante")
public class ParticipanteController {

	@Autowired
	private ParticipanteService participanteService;

	@GetMapping
	public ResponseEntity<List<ParticipanteBuscaDto>> getPadrao() {
		List<Participante> listaParticipante = participanteService.todosParticipantes();
		List<ParticipanteBuscaDto> participanteBuscaVos = ParticipanteBuscaDto.converter(listaParticipante);

		return ResponseEntity.ok(participanteBuscaVos);
	}

	/* lista participantes na tabela - busca participantes*/
	
	@GetMapping("/ativos")
	public List<ParticipanteBuscaDto> listarPart() {
		return participanteService.buscaPorStatus();
	}

	@GetMapping("/{cpf}")
	public ResponseEntity<ParticipanteBuscaNomeDto> mostraNome(@PathVariable String cpf) {
		return participanteService.buscaPorId(cpf);
	}

}
