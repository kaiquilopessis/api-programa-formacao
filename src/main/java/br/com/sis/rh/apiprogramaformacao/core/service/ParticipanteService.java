package br.com.sis.rh.apiprogramaformacao.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AtualizaParticipanteForm;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ProgramaRepository;

@Service
public class ParticipanteService {
	@Autowired
	ParticipanteRepository repository;
	
	@Autowired
	ProgramaRepository programaRepository;
	
	public List<Participante> todosParticipantes(){
		return repository.findAll();
	}
	
	public Participante participanteCpf(String cpf){
		Optional<Participante> optional = repository.findById(cpf);
		return optional.get();
	}
	
	public Participante atualizaParticipante(String cpf, AtualizaParticipanteForm form) {
		Optional<Participante> optionalParticipante = repository.findById(cpf);
		if(optionalParticipante.isPresent()) {
			Participante participante = form.atualizar(cpf, repository, programaRepository);
			return participante;
		}
		return null;
	}
	
}
