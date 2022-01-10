package br.com.sis.rh.apiprogramaformacao.api.vo.dto.input;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel("LoginAD")
public class LoginInput {

	@NotBlank
	@ApiModelProperty(value = "matricula do usuário", required = true, example = "jsilva")
	private String matricula;

	@NotBlank
	@ApiModelProperty(value = "senha da usuário", required = true, example = "1234")
	private String senha;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public LoginInput(@NotBlank String matricula, @NotBlank String senha) {
		this.matricula = matricula;
		this.senha = senha;
	}

}
