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

import br.com.sis.rh.apiprogramaformacao.api.model.FeedBack;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.vo.FeedBackDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.FeedBackForm;
import br.com.sis.rh.apiprogramaformacao.core.repository.FeedBackRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;

@RestController
@RequestMapping("/feedback")
public class FeedBackController {
	
	@Autowired
	private FeedBackRepository feedBackRepository;
	
	@Autowired
	private ParticipanteRepository participanteRepository;
	
	@GetMapping("/{cpf}")
	public List<FeedBackDto> listar(@PathVariable String cpf){
		List<FeedBack> feedbacks = feedBackRepository.findAllByParticipanteCpf(cpf);
		return FeedBackDto.converter(feedbacks);
	}
	
	@PostMapping("/novo/{cpf}")
	public ResponseEntity<FeedBackDto> cadastrar(@PathVariable String cpf, @RequestBody FeedBackForm feedBackForm, UriComponentsBuilder uriComponentsBuilder){
		Optional<Participante> participante = participanteRepository.findById(cpf);
		if(participante.isPresent()) {
			FeedBack feedback = feedBackForm.converter(participante.get());
			feedBackRepository.save(feedback);
			URI uri = uriComponentsBuilder.path("feedback/novo/{id}").buildAndExpand(feedback.getId()).toUri();
			return ResponseEntity.created(uri).body(new FeedBackDto(feedback));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<FeedBackDto> deletar (@PathVariable Long id){
		Optional<FeedBack> feedBack = feedBackRepository.findById(id);
		if(feedBack.isPresent()) {
			feedBackRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	

}
