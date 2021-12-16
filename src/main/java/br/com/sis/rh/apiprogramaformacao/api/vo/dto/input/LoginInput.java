package br.com.sis.rh.apiprogramaformacao.api.vo.dto.input;

import javax.validation.constraints.NotBlank;

public class LoginInput {

	@NotBlank
	private String matricula;

	@NotBlank
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
		super();
		this.matricula = matricula;
		this.senha = senha;
	}

}
