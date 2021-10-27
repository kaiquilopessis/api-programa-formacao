package br.com.sis.rh.apiprogramaformacao.api.vo.form;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AutenticacaoForm {

    @NotEmpty @NotNull
    private String usuario;

    @NotEmpty @NotNull
    private String senha;

    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public UsernamePasswordAuthenticationToken converter() {
        return new UsernamePasswordAuthenticationToken(usuario, senha);
    }
}
