package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import org.springframework.web.multipart.MultipartFile;

public class AtualizaParticipanteForm {

	private String nome;
	private String cpf;
	private String telefone;
	private String fonteRecrutamento;
	private String nmFaculdade;
	private String curso;
	private String dataFimGraduacao;
	private String cargo;
	private String turma;
	private String observacao;
	private String email;
	private String nomeTurma;
	private String nomePrograma;
	private MultipartFile tce;


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getNmFaculdade() {
		return nmFaculdade;
	}

	public void setNmFaculdade(String nmFaculdade) {
		this.nmFaculdade = nmFaculdade;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getDataFimGraduacao() {
		return dataFimGraduacao;
	}

	public void setDataFimGraduacao(String dataFimGraduacao) {
		this.dataFimGraduacao = dataFimGraduacao;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeTurma() {
		return nomeTurma;
	}

	public MultipartFile getTce() {
		return tce;
	}

	public void setTce(MultipartFile tce) {
		this.tce = tce;
	}

	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}

	public String getNomePrograma() {
		return nomePrograma;
	}

	public void setNomePrograma(String nomePrograma) {
		this.nomePrograma = nomePrograma;
	}

}
