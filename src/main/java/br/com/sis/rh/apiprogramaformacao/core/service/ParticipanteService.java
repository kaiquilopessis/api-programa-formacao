package br.com.sis.rh.apiprogramaformacao.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ParticipanteBuscaDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ParticipanteBuscaNomeDto;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusParticipante;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;

@Service
public class ParticipanteService {
	@Autowired
	ParticipanteRepository repository;
	
	public List<Participante> todosParticipantes(){
		return repository.findAll();
	}
	
	public List<ParticipanteBuscaDto> buscaPorStatus() {
		List<Participante> participantes = repository.findByStatus(StatusParticipante.ATIVO);
		return ParticipanteBuscaDto.converter(participantes);
	}
	
	public ResponseEntity<ParticipanteBuscaNomeDto> buscaPorId (String cpf){
		Optional<Participante> participante = repository.findById(cpf);
		if(participante.isPresent()) {
			return ResponseEntity.ok(new ParticipanteBuscaNomeDto(participante.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
}
