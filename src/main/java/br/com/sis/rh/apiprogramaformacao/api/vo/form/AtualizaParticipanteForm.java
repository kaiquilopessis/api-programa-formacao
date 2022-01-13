package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Formulario para Atualizar participante")
public class AtualizaParticipanteForm {

	@ApiModelProperty(value = "Nome", required = true, example = "Carlos Alberto")
	private String nome;
	@ApiModelProperty(value = "Cpf do participante", required = true, example = "50749052813")
	private String cpf;
	@ApiModelProperty(value = "Telefone", required = true, example = "11976716444")
	private String telefone;
	@ApiModelProperty(value = "Fonte de recrutamento", required = true, example = "Palestra")
	private String fonteRecrutamento;
	@ApiModelProperty(value = "Nome Faculdade", required = true, example = "Fatec")
	private String nmFaculdade;
	@ApiModelProperty(value = "Nome do curso", required = true, example = "Engenharia da computação")
	private String curso;
	@ApiModelProperty(value = "Final da graduação", required = true, example = "2022-12-31")
	private String dataFimGraduacao;
	@ApiModelProperty(value = "Cargo", required = true, example = "Estágiario")
	private String observacao;
	@ApiModelProperty(value = "email", required = true, example = "Sis@sisconsultoria.com.br")
	private String email;
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



	public MultipartFile getTce() {
		return tce;
	}

	public void setTce(MultipartFile tce) {
		this.tce = tce;
	}

}
