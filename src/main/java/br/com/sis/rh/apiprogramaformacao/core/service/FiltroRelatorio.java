package br.com.sis.rh.apiprogramaformacao.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sis.rh.apiprogramaformacao.api.model.Formacoes;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.vo.FormacoesDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.ParticipanteDto;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusAtivo;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusEfetivo;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusFormacao;
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
		List<Participante> participantesAtivos = participanteRepository.findByAtivo(StatusAtivo.ATIVO);
		return ParticipanteDto.converter(participantesAtivos);
	}

	public List<ParticipanteDto> listaTotalParticipantesEfetivados() {
		List<Participante> participantesEfetivados = participanteRepository.findByEfetivo(StatusEfetivo.EFETIVADO);
		return ParticipanteDto.converter(participantesEfetivados);
	}

	public List<FormacoesDto> listaTotalFormacoesEmAndamento() {
		List<Formacoes> formacoes = formacoesRepository.findByStatusFormacao(StatusFormacao.EM_ANDAMENTO);
		return FormacoesDto.converter(formacoes);
	}
}
