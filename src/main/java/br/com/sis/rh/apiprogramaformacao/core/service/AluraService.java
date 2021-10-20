package br.com.sis.rh.apiprogramaformacao.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sis.rh.apiprogramaformacao.api.model.Alura;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.core.repository.AluraRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;

@Service
public class AluraService {
	
	@Autowired
	private AluraRepository aluraRepository;
	
	@Autowired
	private ParticipanteRepository participanteRepository;
	
	public List<Alura> buscaParticipanteCpf (String cpf){
		List<Alura> alura = aluraRepository.findAllByParticipanteCpf(cpf);
		return alura;
	}
	
	public Optional<Participante> buscaParticipanteId (String cpf){
		Optional<Participante> participante = participanteRepository.findById(cpf);
		return participante;
	}
	
	public Optional<Alura> buscaAluraId (Long id){
		Optional<Alura> alura = aluraRepository.findById(id);
		return alura;
	}

	
	public void salvar(Alura alura) {
		aluraRepository.save(alura);
	}
	
	public void deletarPorId(Long id) {
		aluraRepository.deleteById(id);
	}
}
