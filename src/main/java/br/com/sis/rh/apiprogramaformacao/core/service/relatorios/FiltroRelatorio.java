package br.com.sis.rh.apiprogramaformacao.core.service.relatorios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sis.rh.apiprogramaformacao.api.model.informacoesgerais.Programa;
import br.com.sis.rh.apiprogramaformacao.api.model.processoseletivo.ProcessoSeletivo;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.NomeProgramaEmAndamentoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ParticipanteProgramaDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.TurmaDto;
import br.com.sis.rh.apiprogramaformacao.core.repository.informacoesgerais.ParticipanteRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.informacoesgerais.ProgramaRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.processoseletivo.ProcessoSeletivoRepository;

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
		return participanteRepository.buscarParticipantesProgramaAtivos();
	} 
	
	//Lógica para listar os participantes de todos os programas com status EFETIVADO
	public List<ParticipanteProgramaDto> listaTotalParticipantesEfetivados() {
		return participanteRepository.findByStatusEfetivo();
	}
	
	//Lógica para listar todas as formações com status EM_ANDAMENTO
	public List<NomeProgramaEmAndamentoDto> listaTotalFormacoesEmAndamento() {
		return processoSeletivoRepository.buscarFormacoesEmAndamento();
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
