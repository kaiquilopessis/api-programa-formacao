package br.com.sis.rh.apiprogramaformacao.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;

@Service
public class FiltroConclusao {

	@Autowired
	private ParticipanteRepository participanteRepository;
	
	public Integer listaParticipantesAtivosPorFormacao(String parametro){
		System.out.println(parametro);
		return participanteRepository.listaParticipantesJava(parametro);
	}
}