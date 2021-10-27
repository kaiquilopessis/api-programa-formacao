package br.com.sis.rh.apiprogramaformacao.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;

@Service
public class ParticipanteService {
	@Autowired
	ParticipanteRepository repository;
	
	public List<Participante> todosParticipantes(){
		return repository.findAll();
	}
	
}
