package br.com.sis.rh.apiprogramaformacao.core.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sis.rh.apiprogramaformacao.api.model.Alura;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.RelatorioAluraVo;
import br.com.sis.rh.apiprogramaformacao.core.repository.AluraRepository;
import br.com.sis.rh.apiprogramaformacao.core.util.FormatadorDataUtil;

/**
 * Classe onde estão as regras de negócio referente a tela de relatorios
 * do acompanhamento da plataforma Alura dos participantes de determinado programa.
 */

@Service
public class AluraService {
	
	@Autowired
	private AluraRepository aluraRepository;
	
//	@Autowired
//	private ParticipanteRepository participanteRepository;

	@Autowired
	private FormatadorDataUtil formatador;
	
	/**
	 * Executa outros métodos para popular o Vo
	 * para levar as informações para o front-end e popular
	 * os cards.
	 * 
	 * @param formacao nome do programa de formação selecionado
	 * @param turma turma do programa de formação selecionado
	 * @return Vo populado com a media de horas, maior e menor
	 * horas registradas, data do último registro, nome e cargo
	 * do participante que teve a maior e menor hora, além do 
	 * nome do programa e a turma.
	 */
	
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

	/**
	 * Calcula a média de horas por semana dos participantes,
	 * busca a maior e a menor quantidade de horas registradas.
	 *
	 * @param relatorios Lista do último registro de apontamento
	 * de horas da plataforma Alura
	 * @return Vo com os campos de média, máxima e menor quantidade
	 * de horas populados.
	 */
	
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
