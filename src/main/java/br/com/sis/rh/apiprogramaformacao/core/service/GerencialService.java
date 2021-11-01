package br.com.sis.rh.apiprogramaformacao.core.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ParticipanteBuscaNomeDto;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;

@Service
public class GerencialService {

	@Autowired
	private ParticipanteRepository participanteRepository;

	public ResponseEntity<ParticipanteBuscaNomeDto> buscaPorId (String cpf){
		Optional<Participante> participante = participanteRepository.findById(cpf);
		if(participante.isPresent()) {
			return ResponseEntity.ok(new ParticipanteBuscaNomeDto(participante.get()));
		}
		return ResponseEntity.notFound().build();
	}

}
