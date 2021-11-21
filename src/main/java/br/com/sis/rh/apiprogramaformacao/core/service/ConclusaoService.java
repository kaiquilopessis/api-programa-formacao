package br.com.sis.rh.apiprogramaformacao.core.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.RelatorioConclusaoVO;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ProgramaRepository;
import br.com.sis.rh.apiprogramaformacao.core.util.DataConfiguration;

@Service
public class ConclusaoService {
	
	@Autowired
	private ParticipanteRepository participanteRepository;
	@Autowired
	private ProgramaRepository programaRepository;
	@Autowired
	private DataConfiguration dataConfiguration;
	
	public RelatorioConclusaoVO popularCards(String formacao, String turma) {
		String turmaFormatada = turma.replace("+", " ");
		
		RelatorioConclusaoVO relatorioConclusaoVO = new RelatorioConclusaoVO();
		relatorioConclusaoVO = partAtivos(formacao, turmaFormatada, relatorioConclusaoVO);
		relatorioConclusaoVO = partEfetivados(formacao, turmaFormatada, relatorioConclusaoVO);
		relatorioConclusaoVO = dataConclusao(formacao, turmaFormatada, relatorioConclusaoVO);
		
		relatorioConclusaoVO.setProgramadeformacao(formacao);
		relatorioConclusaoVO.setTurma(turmaFormatada);
		
		return relatorioConclusaoVO;
	}
	
	public RelatorioConclusaoVO partAtivos(String formacao, String turma, RelatorioConclusaoVO relatorio) {
		Integer totalAtivos = participanteRepository.listaParticipantesAtivos(formacao, turma);
		relatorio.setParticipantesAtivos(totalAtivos);
		return relatorio;
	}
	
	public RelatorioConclusaoVO partEfetivados(String formacao, String turma, RelatorioConclusaoVO relatorio) {
		Integer totalEfetivados = participanteRepository.listaParticipantesEfetivados(formacao, turma);
		relatorio.setParticipantesEfetivados(totalEfetivados);
		return relatorio;
	}
	
	public RelatorioConclusaoVO dataConclusao(String formacao, String turma, RelatorioConclusaoVO relatorio) {
		LocalDate dataFim = programaRepository.dataConclusao(formacao, turma);
		System.out.println(dataFim);
		String data = dataConfiguration.dataFormatada(dataFim);
		relatorio.setDataConclusao(data);
		
		return relatorio;
	}

}
