package br.com.sis.rh.apiprogramaformacao.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sis.rh.apiprogramaformacao.api.model.ProcessoSeletivo;
import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.NomeProgramaEmAndamentoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ParticipanteProgramaDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ProgramaDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.TurmaDto;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusEfetivado;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusParticipante;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusProcessoSeletivo;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ProcessoSeletivoRepository;
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

	@Autowired
	private ProcessoSeletivoRepository processoSeletivoRepository;
	
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
	public List<ParticipanteProgramaDto> listaTotalParticipantesAtivos() {
		return participanteRepository.buscarParticipantesProgramaAtivos(StatusParticipante.ATIVO);
	} 
	
	//Lógica para listar os participantes de todos os programas com status EFETIVADO
	public List<ParticipanteProgramaDto> listaTotalParticipantesEfetivados() {
		return participanteRepository.findByStatusEfetivo(StatusEfetivado.EFETIVADO);
	}
	
	//Lógica para listar todas as formações com status EM_ANDAMENTO
	public List<ProgramaDto> listaTotalFormacoesEmAndamento() {
		return processoSeletivoRepository.buscarFormacoesEmAndamento(StatusProcessoSeletivo.EM_ANDAMENTO);
	}

	//Busca todas os programas de formações
    public List<NomeProgramaEmAndamentoDto> buscarTodasAsFormacoes() {
		List<ProcessoSeletivo> processoSeletivos = processoSeletivoRepository.findAll();
		return NomeProgramaEmAndamentoDto.converter(processoSeletivos);
    }

	//Busca todas as turmas de um determinado programa
	public List<TurmaDto> buscarTodasAsTurmas(String nomePrograma) {
		List<Programa> programas = programaRepository.buscarTurmasPeloNomePrograma(nomePrograma);
		return TurmaDto.converter(programas);
	}
	
	
}
