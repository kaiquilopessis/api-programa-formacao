package br.com.sis.rh.apiprogramaformacao.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FormacaoBuscaDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ParticipanteBuscaDto;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusAtivo;
import br.com.sis.rh.apiprogramaformacao.core.repository.FormacaoRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;

@Service
public class BuscaService {

	@Autowired
	private ParticipanteRepository participanteRepository;

	@Autowired
	private FormacaoRepository formacaoRepository;


	public List<ParticipanteBuscaDto> buscaPorStatus(String status) {
		List<Participante> participantes = participanteRepository.findByStatus(String.valueOf(StatusAtivo.ATIVO));
		return ParticipanteBuscaDto.converter(participantes);
	}

	public List<FormacaoBuscaDto> buscaPorStatusForm(String status){
		List<Programa> formacoes = formacaoRepository.findByStatus(status);
		return FormacaoBuscaDto.converter(formacoes);
	}

}
