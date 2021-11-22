package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

public class RelatorioConclusaoVO {

	// Variaveis do banco
	private String programadeformacao;
	private String turma;
	private Integer participantesAtivos;
	private Integer participantesEfetivados;
	private String dataConclusao;
	
	// Construtor criado para definir variaveis do banco
	public RelatorioConclusaoVO(String programadeformacao, String turma, Integer participantesAtivos,
			Integer participantesEfetivados, String dataConclusao) {
		this.programadeformacao = programadeformacao;
		this.turma = turma;
		this.participantesAtivos = participantesAtivos;
		this.participantesEfetivados = participantesEfetivados;
		this.dataConclusao = dataConclusao;
	}
	
	// Criando um construtor vazio
	public RelatorioConclusaoVO() {
	}

	public String getProgramadeformacao() {
		return programadeformacao;
	}

	public void setProgramadeformacao(String programadeformacao) {
		this.programadeformacao = programadeformacao;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public Integer getParticipantesAtivos() {
		return participantesAtivos;
	}

	public void setParticipantesAtivos(Integer participantesAtivos) {
		this.participantesAtivos = participantesAtivos;
	}

	public Integer getParticipantesEfetivados() {
		return participantesEfetivados;
	}

	public void setParticipantesEfetivados(Integer participantesEfetivados) {
		this.participantesEfetivados = participantesEfetivados;
	}

	public String getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(String dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

}
