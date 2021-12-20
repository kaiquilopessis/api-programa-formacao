package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.sis.rh.apiprogramaformacao.api.model.Candidato;

public class CandidatoDto {
	private Long id;
	private String nome;
	private String telefone;
	private String fonteRecrutamento;
	private LocalDate dataAgendamento;
	private String status;
	private BigDecimal testeLogico;
	private String notaDisc;
	private String observacao;
	private String processoSeletivo;
	private Long processoSeletivoId;
	private String email;
	private String semestre;
	private String periodoCurso;
	private LocalDate dataConclusao;
	private String duracaoCurso;
	private String endereco;
	private String IndicacaoVaga;

	public CandidatoDto(Candidato candidato) {
		if (this.dataConclusao != null) {
			this.id = candidato.getId();
			this.nome = candidato.getNome();
			this.fonteRecrutamento = candidato.getFonteRecrutamento();
			this.telefone = candidato.getTelefone();
			this.dataAgendamento = candidato.getDataAgendamento();
			this.status = candidato.getStatus().replace("_", " ");
			this.testeLogico = candidato.getTesteLogico();
			this.observacao = candidato.getObservacao();
			this.processoSeletivo = candidato.getProcessoSeletivo().getNome();
			this.processoSeletivoId = candidato.getProcessoSeletivo().getId();
			this.email = candidato.getEmail();
			this.semestre = candidato.getSemestreFaculdade();
			this.periodoCurso = candidato.getPeriodoCurso();			
			this.dataConclusao = candidato.getDataConclusao();
			this.duracaoCurso = candidato.getDuracaoCurso();
			this.endereco = candidato.getEndereco();
			this.IndicacaoVaga = candidato.getIndicacaoVaga();
		}else {
			this.id = candidato.getId();
			this.nome = candidato.getNome();
			this.fonteRecrutamento = candidato.getFonteRecrutamento();
			this.telefone = candidato.getTelefone();
			this.dataAgendamento = candidato.getDataAgendamento();
			this.status = candidato.getStatus().replace("_", " ");
			this.testeLogico = candidato.getTesteLogico();
			this.observacao = candidato.getObservacao();
			this.processoSeletivo = candidato.getProcessoSeletivo().getNome();
			this.processoSeletivoId = candidato.getProcessoSeletivo().getId();
			this.email = candidato.getEmail();
			this.semestre = candidato.getSemestreFaculdade();
			this.periodoCurso = candidato.getPeriodoCurso();
			this.duracaoCurso = candidato.getDuracaoCurso();
			this.endereco = candidato.getEndereco();
			this.IndicacaoVaga = candidato.getIndicacaoVaga();
		}
			
	}
	

	public CandidatoDto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getFonteRecrutamento() {
		return fonteRecrutamento;
	}

	public void setFonteRecrutamento(String fonteRecrutamento) {
		this.fonteRecrutamento = fonteRecrutamento;
	}

	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getTesteLogico() {
		return testeLogico;
	}

	public void setTesteLogico(BigDecimal testeLogico) {
		this.testeLogico = testeLogico;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getProcessoSeletivo() {
		return processoSeletivo;
	}

	public void setProcessoSeletivo(String processoSeletivo) {
		this.processoSeletivo = processoSeletivo;
	}

	public Long getProcessoSeletivoId() {
		return processoSeletivoId;
	}

	public void setProcessoSeletivoId(Long processoSeletivoId) {
		this.processoSeletivoId = processoSeletivoId;
	}

	public String getNotaDisc() {
		return notaDisc;
	}

	public void setNotaDisc(String notaDisc) {
		this.notaDisc = notaDisc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getPeriodoCurso() {
		return periodoCurso;
	}

	public void setPeriodoCurso(String periodoCurso) {
		this.periodoCurso = periodoCurso;
	}

	public LocalDate getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(LocalDate dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	public String getDuracaoCurso() {
		return duracaoCurso;
	}

	public void setDuracaoCurso(String duracaoCurso) {
		this.duracaoCurso = duracaoCurso;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getIndicacaoVaga() {
		return IndicacaoVaga;
	}

	public void setIndicacaoVaga(String indicacaoVaga) {
		IndicacaoVaga = indicacaoVaga;
	}

	public static List<CandidatoDto> converter(List<Candidato> candidato) {
		return candidato.stream().map(CandidatoDto::new).collect(Collectors.toList());
	}

}
