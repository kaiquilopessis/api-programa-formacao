package br.com.sis.rh.apiprogramaformacao.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.api.vo.ParticipanteDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.ProgramaDto;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusFormacao;
import br.com.sis.rh.apiprogramaformacao.core.enums.Status_Ativo;
import br.com.sis.rh.apiprogramaformacao.core.enums.Status_Efetivo;
import br.com.sis.rh.apiprogramaformacao.core.repository.FormacoesRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;

@Service
public class FiltroRelatorio {
	
	@Autowired
	private ParticipanteRepository participanteRepository;

	@Autowired
	private FormacoesRepository formacoesRepository;
	
	public List<Integer> numeroTotalParaCadaFiltro() {
		Integer totalParticipantes = (Integer)participanteRepository.totalParticipantesAtivos();
		Integer totalEfetivados = (Integer)participanteRepository.totalEfetivados();
		Integer totalFormacoes = (Integer)formacoesRepository.totalFormacoes();
		List<Integer> vetor = new ArrayList<Integer>();
		vetor.add(totalParticipantes);
		vetor.add(totalEfetivados);
		vetor.add(totalFormacoes);
		return vetor;
	}
	
	public List<ParticipanteDto> listaTotalParticipantesAtivos() {
		List<Participante> participantesAtivos = participanteRepository.findByStatusAtivo(Status_Ativo.ATIVO);
		return ParticipanteDto.converter(participantesAtivos);
	} 

	public List<ParticipanteDto> listaTotalParticipantesEfetivados() {
		List<Participante> participantesEfetivados = participanteRepository.findByStatusEfetivo(Status_Efetivo.EFETIVADO);
		return ParticipanteDto.converter(participantesEfetivados);
	}

	public List<ProgramaDto> listaTotalFormacoesEmAndamento() {
		List<Programa> programa = formacoesRepository.findByStatusFormacao(StatusFormacao.EM_ANDAMENTO);
		return ProgramaDto.converter(programa);
	}

}
