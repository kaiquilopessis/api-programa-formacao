package br.com.sis.rh.apiprogramaformacao.api.vo.dto.input;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginInput {
	
	@NotBlank
	private String matricula;
	
	@NotBlank
	private String senha;

}
