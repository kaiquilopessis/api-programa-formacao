package br.com.sis.rh.apiprogramaformacao.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ParticipanteDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ProgramaDto;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusAtivo;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusEfetivo;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusFormacao;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ProgramaRepository;

/**
 * Classe Service: contém a lógica para as buscas no banco de dados
 * Essa lógica está sendo chamada no RelatoriosController. 
 * @author psedassari
 *
 */
@Service
public class FiltroRelatorio {
	
	@Autowired
	private ParticipanteRepository participanteRepository;

	@Autowired
	private ProgramaRepository programaRepository;
	
	/*
	 * Lógica para buscar a contagem total (Integer) de participantes ativos,
	 * participantes efetivados e formações em andamento, retornando um vetor
	 * com os respectivos números.
	 */
	public List<Integer> numeroTotalParaCadaFiltro() {
		Integer totalParticipantes = (Integer)participanteRepository.totalParticipantesAtivos();
		Integer totalEfetivados = (Integer)participanteRepository.totalEfetivados();
		Integer totalFormacoes = (Integer)programaRepository.totalFormacoes();
		List<Integer> vetor = new ArrayList<Integer>();
		vetor.add(totalParticipantes);
		vetor.add(totalEfetivados);
		vetor.add(totalFormacoes);
		return vetor;
	}
	
	//Lógica para listar os participantes de todos os programas com status ATIVO
	public List<ParticipanteDto> listaTotalParticipantesAtivos() {
		List<Participante> participantesAtivos = participanteRepository.findByStatusAtivo(StatusAtivo.ATIVO);
		return ParticipanteDto.converter(participantesAtivos);
	} 
	
	//Lógica para listar os participantes de todos os programas com status EFETIVADO
	public List<ParticipanteDto> listaTotalParticipantesEfetivados() {
		List<Participante> participantesEfetivados = participanteRepository.findByStatusEfetivo(StatusEfetivo.EFETIVADO);
		return ParticipanteDto.converter(participantesEfetivados);
	}
	
	//Lógica para listar todas as formações com status EM_ANDAMENTO
	public List<ProgramaDto> listaTotalFormacoesEmAndamento() {
		List<Programa> programa = programaRepository.findByStatusFormacao(StatusFormacao.EM_ANDAMENTO);
		return ProgramaDto.converter(programa);
	}

}
