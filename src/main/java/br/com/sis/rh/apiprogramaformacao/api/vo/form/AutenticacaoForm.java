package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AutenticacaoForm {

    @NotEmpty
    @NotNull
    private String usuario;

    @NotEmpty @NotNull
    private String senha;

    public UsernamePasswordAuthenticationToken converter() {
        return new UsernamePasswordAuthenticationToken(usuario, senha);
    }
}
