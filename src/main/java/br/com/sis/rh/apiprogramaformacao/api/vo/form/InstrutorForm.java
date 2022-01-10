package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;
import br.com.sis.rh.apiprogramaformacao.core.util.FormatterUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Formulário de Cadastro de instrutor")
public class InstrutorForm {

	@NotNull
	@NotEmpty
	@ApiModelProperty(value = "cpf do instrutor", required = true, example = "896.205.310-19")
	private String cpf;

	@NotNull
	@NotEmpty
	@ApiModelProperty(value = "telefone do instrutor", required = true, example = "21999887766")
	private String telefone;

	@NotNull
	@NotEmpty
	@ApiModelProperty(value = "status do instrutor", required = true, example = "ATIVO")
	private String status;

	@NotNull
	@NotEmpty
	@ApiModelProperty(value = "nome do instrutor", required = true, example = "João da Silva")
	private String nome;

	@NotNull
	@NotEmpty
	@ApiModelProperty(value = "email do instrutor", required = true, example = "instrutor@sisconsultoria.com.br")
	private String email;

	public InstrutorForm(String cpf, String telefone, String status, String nome, String email) {
		this.cpf = cpf;
		this.telefone = telefone;
		this.status = status;
		this.nome = nome;
		this.email = email;
	}

	public InstrutorForm() {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Instrutor converter() {
		return new Instrutor(FormatterUtil.removerMascara(cpf), telefone, status, nome, email);
	}

}
