package br.com.sis.rh.apiprogramaformacao.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "TB_CANDIDATO")
public class Candidato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "nome", nullable = false, length = 50)
	private String nome;

	@Column(name = "telefone", nullable = false, length = 255)
	private String telefone;

	@Column(name = "data_agendamento", nullable = false)
	private LocalDate dataAgendamento;

	@Column(name = "teste_logico", nullable = false)
	private BigDecimal testeLogico;

	@Column(name = "status", nullable = false)
	private String status;

	@Column(name = "observacao", length = 8000)
	private String observacao;

	@Column(name = "DISC")
	@Lob
	private byte[] disc;

	@Column(name = "curriculo")
	@Lob
	private byte[] curriculo;

	@Column(name = "fonte_recrutamento")
	private String fonteRecrutamento;

	@ManyToOne
	@JoinColumn(name = "processo_seletivo_fk", referencedColumnName = "id")
	private ProcessoSeletivo processoSeletivo;

	@Column(name = "email")
	private String email;

	@Column(name = "semestre_faculdade")
	private String semestreFaculdade;

	@Column(name = "periodo_curso")
	private String periodoCurso;

	@Column(name = "data_conclusao")
	private LocalDate dataConclusao;

	@Column(name = "duracao_curso")
	private String duracaoCurso;

	@Column(name = "endereco")
	private String endereco;

	@Column(name = "indicacao_vaga")
	private String indicacaoVaga;

	public Candidato(String nome, String telefone, LocalDate dataAgendamento, BigDecimal testeLogico,
			String status, String observacao, byte[] disc, byte[] curriculo, String fonteRecrutamento,
			ProcessoSeletivo processoSeletivo, String email, String semestreFaculdade, String periodoCurso,
			LocalDate dataConclusao, String duracaoCurso, String endereco, String indicacaoVaga) {
		this.nome = nome;
		this.telefone = telefone;
		this.dataAgendamento = dataAgendamento;
		this.testeLogico = testeLogico;
		this.status = status;
		this.observacao = observacao;
		this.disc = disc;
		this.curriculo = curriculo;
		this.fonteRecrutamento = fonteRecrutamento;
		this.processoSeletivo = processoSeletivo;
		this.email = email;
		this.semestreFaculdade = semestreFaculdade;
		this.periodoCurso = periodoCurso;
		this.dataConclusao = dataConclusao;
		this.duracaoCurso = duracaoCurso;
		this.endereco = endereco;
		this.indicacaoVaga = indicacaoVaga;
	}

	public Candidato(String nome, String telefone, LocalDate dataAgendamento, BigDecimal testeLogico,
			String status, String observacao, byte[] disc, byte[] curriculo, String fonteRecrutamento,
			ProcessoSeletivo processoSeletivo, String email, String endereco, String indicacaoVaga) {
		this.nome = nome;
		this.telefone = telefone;
		this.dataAgendamento = dataAgendamento;
		this.testeLogico = testeLogico;
		this.status = status;
		this.observacao = observacao;
		this.disc = disc;
		this.curriculo = curriculo;
		this.fonteRecrutamento = fonteRecrutamento;
		this.processoSeletivo = processoSeletivo;
		this.email = email;
		this.endereco = endereco;
		this.indicacaoVaga = indicacaoVaga;
	}

	public Candidato() {
	}

	public String getFonteRecrutamento() {
		return fonteRecrutamento;
	}

	public void setFonteRecrutamento(String fonteRecrutamento) {
		this.fonteRecrutamento = fonteRecrutamento;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public BigDecimal getTesteLogico() {
		return testeLogico;
	}

	public void setTesteLogico(BigDecimal testeLogico) {
		this.testeLogico = testeLogico;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public ProcessoSeletivo getProcessoSeletivo() {
		return processoSeletivo;
	}

	public void setProcessoSeletivo(ProcessoSeletivo processoSeletivo) {
		this.processoSeletivo = processoSeletivo;
	}

	public byte[] getDisc() {
		return disc;
	}

	public void setDisc(byte[] disc) {
		this.disc = disc;
	}

	public byte[] getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(byte[] curriculo) {
		this.curriculo = curriculo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSemestreFaculdade() {
		return semestreFaculdade;
	}

	public void setSemestreFaculdade(String semestreFaculdade) {
		this.semestreFaculdade = semestreFaculdade;
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
		return indicacaoVaga;
	}

	public void setIndicacaoVaga(String indicacaoVaga) {
		this.indicacaoVaga = indicacaoVaga;
	}

}
