package br.com.sis.rh.apiprogramaformacao.core.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sis.rh.apiprogramaformacao.api.vo.RelatorioAluraVo;
import br.com.sis.rh.apiprogramaformacao.core.model.Alura;
import br.com.sis.rh.apiprogramaformacao.core.repository.AluraRepository;
import br.com.sis.rh.apiprogramaformacao.core.util.FormatadorDataUtil;

@Service
public class AluraService {
	
	@Autowired
	private AluraRepository aluraRepository;
	
//	@Autowired
//	private ParticipanteRepository participanteRepository;

	@Autowired
	private FormatadorDataUtil formatador;
	
	public RelatorioAluraVo popularCards(String formacao, String turma) {
		RelatorioAluraVo aluraVo = new RelatorioAluraVo();
		List<Alura> relatorios = new ArrayList<Alura>();
		
		relatorios = aluraRepository.buscarRegistroHoras();
		aluraVo = calcularMediaMaxMinHoras(relatorios);
		LocalDate dataRegistro = relatorios.get(0).getDataRegistro();
		aluraVo.setDataUltimoRegistro(formatador.formatarData(dataRegistro));
		
//		aluraVo = buscarParticipantesComMaiorEMenorQtdHoras(aluraVo);
		String turmaFormatada = turma.replace("+", " ");
		System.out.println(turmaFormatada);
		aluraVo.setProgramaDeFormacao(formacao);
		aluraVo.setTurma(turmaFormatada);
		
		return aluraVo;
	}
	
	public RelatorioAluraVo popularVo() {
		RelatorioAluraVo aluraVo = new RelatorioAluraVo();
		List<Alura> relatorios = new ArrayList<Alura>();
		
		relatorios = aluraRepository.buscarRegistroHoras();
		aluraVo = calcularMediaMaxMinHoras(relatorios);
		LocalDate dataRegistro = relatorios.get(0).getDataRegistro();
		aluraVo.setDataUltimoRegistro(formatador.formatarData(dataRegistro));
		
		return aluraVo;
	}

	public RelatorioAluraVo calcularMediaMaxMinHoras(List<Alura> relatorios) {
		RelatorioAluraVo aluraVo = new RelatorioAluraVo();
		aluraVo.setMediaDeHorasDosParticipantes(0);
		aluraVo.setMaiorQuantidadeDeHorasDosParticipantes(relatorios.get(0).getQtdHoras());
		aluraVo.setMenorQuantidadeDeHorasDosParticipantes(relatorios.get(0).getQtdHoras());
		relatorios.forEach(relatorio -> {
			if(relatorio.getQtdHoras() > aluraVo.getMaiorQuantidadeDeHorasDosParticipantes()) {
				aluraVo.setMaiorQuantidadeDeHorasDosParticipantes(relatorio.getQtdHoras());
			}
			if(relatorio.getQtdHoras() < aluraVo.getMenorQuantidadeDeHorasDosParticipantes()) {
				aluraVo.setMenorQuantidadeDeHorasDosParticipantes(relatorio.getQtdHoras());
			}
			aluraVo.setMediaDeHorasDosParticipantes(aluraVo.getMediaDeHorasDosParticipantes() + relatorio.getQtdHoras());
		});
		aluraVo.setMediaDeHorasDosParticipantes(aluraVo.getMediaDeHorasDosParticipantes() / relatorios.size());
		
		return aluraVo;
	}
	
//	public RelatorioAluraVo buscarParticipantesComMaiorEMenorQtdHoras(RelatorioAluraVo aluraVo) {
//		String cpfMaiorHora = aluraRepository.buscarCpfMaiorHora();
//		String cpfMenorHora = aluraRepository.buscarCpfMenorHora();
//
//		Participante participanteMaiorHora = participanteRepository.findByCpf(cpfMaiorHora);
//		Participante participanteMenorHora = participanteRepository.findByCpf(cpfMenorHora);
//		
//		aluraVo.setNomeFuncionarioComMaiorQuantidadeHoras(participanteMaiorHora.getNome());
//		aluraVo.setCargoFuncionarioComMaiorQuantidadeHoras(participanteMaiorHora.getCargo());
//		
//		aluraVo.setNomeFuncionarioComMenorQuantidadeHoras(participanteMenorHora.getNome());
//		aluraVo.setCargoFuncionarioComMenorQuantidadeHoras(participanteMenorHora.getCargo());
//		
//		return aluraVo;
//	}
}
