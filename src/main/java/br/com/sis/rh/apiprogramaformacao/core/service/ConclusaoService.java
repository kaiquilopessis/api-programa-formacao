package br.com.sis.rh.apiprogramaformacao.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.sis.rh.apiprogramaformacao.api.model.Conclusao;
import br.com.sis.rh.apiprogramaformacao.api.vo.ConclusaoDto;
import br.com.sis.rh.apiprogramaformacao.core.repository.ConclusaoRepository;

public class ConclusaoService {
	
	@Autowired
	private ConclusaoRepository conclusaoRepository;
	
	public List<ConclusaoDto> listar(String cpf){
		List<Conclusao> conclusoes = conclusaoRepository.findAllByParticipanteCpf(cpf);
		return ConclusaoDto.converter(conclusoes);
	}
}
