package br.com.sis.rh.apiprogramaformacao.api.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sis.rh.apiprogramaformacao.api.model.Avaliacoes;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.vo.AvaliacoesDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.AvaliacoesForm;
import br.com.sis.rh.apiprogramaformacao.core.repository.AvaliacoesRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacoesController {

	@Autowired
	private AvaliacoesRepository avaliacoesRepository;

	@Autowired
	private ParticipanteRepository participanteRepository;

	@GetMapping("/{cpf}")
	public List<AvaliacoesDto> listarNotas(@PathVariable String cpf) {
		List<Avaliacoes> listaNotas = avaliacoesRepository.findAllByParticipanteCpf(cpf);
		return AvaliacoesDto.converter(listaNotas);

	}

	@PostMapping("/novo/{cpf}")
	public ResponseEntity<AvaliacoesDto> cadastrar(@PathVariable String cpf, @RequestBody AvaliacoesForm avaliacoesForm,
			UriComponentsBuilder uriComponentsBuilder) {
		Optional<Participante> participante = participanteRepository.findById(cpf);
		if (participante.isPresent()) {
			Avaliacoes avaliacoes = avaliacoesForm.converter(participante.get());
			avaliacoesRepository.save(avaliacoes);
			URI uri = uriComponentsBuilder.path("/avaliacoes/novo/{id}").buildAndExpand(avaliacoes.getId()).toUri();
			return ResponseEntity.created(uri).body(new AvaliacoesDto(avaliacoes));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<AvaliacoesDto> deletar(@PathVariable Long id) {
		Optional<Avaliacoes> avaliacoes = avaliacoesRepository.findById(id);
		if (avaliacoes.isPresent()) {
			avaliacoesRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
