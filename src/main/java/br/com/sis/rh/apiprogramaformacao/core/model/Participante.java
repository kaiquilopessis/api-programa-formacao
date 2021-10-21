package br.com.sis.rh.apiprogramaformacao.core.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	@OneToMany(mappedBy = "participante.cpf")
	private List<Alura> alura;

	public Participante() {}
	
	public Participante(String cpf, String nomeFaculdade, String nomeCurso, LocalDate dataFimGraduacao,
			List<Alura> alura) {
		this.cpf = cpf;
		this.nomeFaculdade = nomeFaculdade;
		this.nomeCurso = nomeCurso;
		this.dataFimGraduacao = dataFimGraduacao;
		this.alura = alura;
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

	@Override
	public String toString() {
		return "CPF: " + this.cpf;
	}
}
