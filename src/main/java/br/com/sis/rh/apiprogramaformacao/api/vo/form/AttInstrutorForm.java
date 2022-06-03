package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;
import br.com.sis.rh.apiprogramaformacao.core.repository.informacoesgerais.InstrutorRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel("Formulário de alteração do instrutor")
public class AttInstrutorForm {

	@ApiModelProperty(value = "cpf do instrutor", required = true, example = "89620531019")
	private String cpf;

	@ApiModelProperty(value = "telefone do instrutor", required = true, example = "21999887766")
	private String telefone;

	@ApiModelProperty(value = "status do instrutor", required = true, example = "ATIVO")
	private String status;

	@ApiModelProperty(value = "nome do instrutor", required = true, example = "João da Silva")
	private String nome;

	@ApiModelProperty(value = "email do instrutor", required = true, example = "instrutor@sisconsultoria.com.br")
	private String email;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public boolean atualizaInstrutor(InstrutorRepository repository, String cpf) {
		Optional<Instrutor> optionalInstrutor = repository.findById(cpf);

		if (optionalInstrutor.isPresent()) {
			Instrutor instrutor = optionalInstrutor.get();

			instrutor.setStatus(this.status);
			instrutor.setEmail(this.email);
			instrutor.setTelefone(this.telefone);
			instrutor.setNome(this.nome);
			repository.save(instrutor);

			return true;
		} else {
			return false;
		}
	}
}
