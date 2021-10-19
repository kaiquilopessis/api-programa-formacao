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

import br.com.sis.rh.apiprogramaformacao.api.model.Alura;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.vo.AluraDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.AluraForm;
import br.com.sis.rh.apiprogramaformacao.core.repository.AluraRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;

@RestController
@RequestMapping("/alura")
public class AluraController {
	
	@Autowired
	private AluraRepository aluraRepository;
	
	@Autowired
	private ParticipanteRepository participanteRepository;
	
	@GetMapping("/{cpf}")
	public List<AluraDto> listaRegistros (@PathVariable String cpf){
		List<Alura> alura = aluraRepository.findAllByParticipanteCpf(cpf);
		return AluraDto.converter(alura);
	}
	
	@PostMapping("/novo/{cpf}")
	public ResponseEntity<AluraDto> cadastrar (@PathVariable String cpf ,@RequestBody AluraForm aluraForm, UriComponentsBuilder uriComponentsBuilder){
		Optional<Participante> participante = participanteRepository.findById(cpf);
		if(participante.isPresent()) {
			Alura alura = aluraForm.converter(participante.get());
			aluraRepository.save(alura);
			URI uri = uriComponentsBuilder.path("/alura/novo/{id}").buildAndExpand(alura.getCodigoAlura()).toUri();
			return ResponseEntity.created(uri).body(new AluraDto(alura));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<AluraDto> deletar (@PathVariable Long id){
		Optional<Alura> alura = aluraRepository.findById(id);
		if(alura.isPresent()) {
			aluraRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
