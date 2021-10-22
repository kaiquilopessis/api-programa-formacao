package br.com.sis.rh.apiprogramaformacao.core.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;

@Service
public class GerencialService {
	
	@Autowired
	private ParticipanteRepository participanteRepository;
	
	public Optional<Participante> buscaPorId (String cpf){
		Optional<Participante> participante = participanteRepository.findById(cpf);
		return participante;
	}

}
