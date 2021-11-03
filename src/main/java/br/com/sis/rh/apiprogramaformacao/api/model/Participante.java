package br.com.sis.rh.apiprogramaformacao.api.model;

/**
 * Esta classe faz a ligação com a Tabela Participantes contida na database programadeformacao
 */

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.sis.rh.apiprogramaformacao.core.enums.StatusAtivo;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusEfetivo;

@Entity(name = "TB_PARTICIPANTE")
public class Participante {

	@Id
	@Column(name = "cpf_participante")
	private String cpf;
	@Column(name = "nm_faculdade")
	private String nomeFaculdade;
	@Column(name = "nm_curso")
	private String nomeCurso;
	@Column(name = "data_fim_graduacao")
	private LocalDate dataFimGraduacao;
	@OneToMany(fetch = FetchType.LAZY)
	private List<Alura> alura;
	@OneToMany(fetch = FetchType.LAZY)
	private List<Avaliacoes> avaliacoes;
	@ManyToOne
	@JoinColumn(name = "codigo_programa_fk")
	private Programa programa;

	@ManyToOne
	@JoinColumn(name = "FK_codigo_remun")
	private Remuneracao remuneracao;

	@OneToMany(fetch = FetchType.LAZY)
	private List<Conclusao> conclusao;
	
	@Enumerated(EnumType.STRING)
	private StatusEfetivo status_efetivado;

	@Enumerated(EnumType.STRING)
	private StatusAtivo status_ativo;

	public Participante() {}
	
	public Participante(String cpf, String nomeFaculdade, String nomeCurso, LocalDate dataFimGraduacao,
			List<Alura> alura, StatusEfetivo status_efetivado, StatusAtivo status_ativo) {
		this.cpf = cpf;
		this.nomeFaculdade = nomeFaculdade;
		this.nomeCurso = nomeCurso;
		this.dataFimGraduacao = dataFimGraduacao;
		this.alura = alura;
		this.status_efetivado = status_efetivado;
		this.status_ativo = status_ativo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNomeFaculdade() {
		return nomeFaculdade;
	}

	public void setNomeFaculdade(String nomeFaculdade) {
		this.nomeFaculdade = nomeFaculdade;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public LocalDate getDataFimGraduacao() {
		return dataFimGraduacao;
	}

	public void setDataFimGraduacao(LocalDate dataFimGraduacao) {
		this.dataFimGraduacao = dataFimGraduacao;
	}

	public List<Alura> getAlura() {
		return alura;
	}

	public void setAlura(List<Alura> alura) {
		this.alura = alura;
	}
	
	public StatusAtivo getStatus_ativo() {
		return status_ativo;
	}
	
	public void setStatus_ativo(StatusAtivo status_ativo) {
		this.status_ativo = status_ativo;
	}
	
	public StatusEfetivo getStatus_efetivado() {
		return status_efetivado;
	}
	
	public void setStatus_efetivado(StatusEfetivo status_efetivado) {
		this.status_efetivado = status_efetivado;
	}

	@Override
	public String toString() {
		return "CPF: " + this.cpf;
	}

}
