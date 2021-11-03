package br.com.sis.rh.apiprogramaformacao.api.vo;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RelatorioConclusaoVO {

	private String programadeformacao;
	private String turma;
	private Integer participantesAtivos;
	private Integer participantesEfetivados;
	private String dataConclusao;
	
	public RelatorioConclusaoVO(String programadeformacao, String turma, Integer participantesAtivos,
			Integer participantesEfetivados, String dataConclusao) {
		this.programadeformacao = programadeformacao;
		this.turma = turma;
		this.participantesAtivos = participantesAtivos;
		this.participantesEfetivados = participantesEfetivados;
		this.dataConclusao = dataConclusao;
	}
	
	public RelatorioConclusaoVO() {
		
	}

}
