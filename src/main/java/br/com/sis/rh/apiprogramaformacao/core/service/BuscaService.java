package br.com.sis.rh.apiprogramaformacao.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sis.rh.apiprogramaformacao.api.model.Formacao;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.core.repository.FormacaoRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;

@Service
public class BuscaService {
	
	@Autowired
	private ParticipanteRepository participanteRepository;
	
	@Autowired
	private FormacaoRepository formacaoRepository;
	
	
	public List<Participante> buscaPorStatus(Boolean status) {
		List<Participante> participantes = participanteRepository.findByStatus(status);
		return participantes;
	}
	
	public List<Formacao> buscaPorStatusForm(Boolean status){
		List<Formacao> formacoes = formacaoRepository.findByStatus(status);
		return formacoes;
	}

}
