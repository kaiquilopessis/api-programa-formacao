package br.com.sis.rh.apiprogramaformacao.core.service;

import java.math.BigDecimal;
import java.util.List;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FiltragemFolhaDto;
import br.com.sis.rh.apiprogramaformacao.core.repository.FolhaDtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;

@Service
public class ParticipanteService {
	@Autowired
	ParticipanteRepository repository;

	@Autowired
	FolhaDtoRepository folhaRepository;
	
	public List<Participante> todosParticipantes(){
		return repository.findAll();
	}

	//Métodos criados por: Marco Aguiar

	public List<FiltragemFolhaDto> listagemFiltroFolha(String nomeParticipante, String nomeFormacao, String nomeTurma, BigDecimal bolsaAux){
		return folhaRepository.findByNomeFormacaoTurmaBolsa(nomeParticipante, nomeFormacao, nomeTurma, bolsaAux);
	}

	public List<FiltragemFolhaDto> listagemFiltroFolhaTodos(){
		return folhaRepository.findByNomeFormacaoTurmaBolsaTodos();
	}
}
