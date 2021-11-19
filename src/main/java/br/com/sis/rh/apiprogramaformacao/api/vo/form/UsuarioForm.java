package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import br.com.sis.rh.apiprogramaformacao.api.model.UsuarioAcesso;

public class UsuarioForm {
    private String usuario;
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

    public UsuarioAcesso converter(){
        return new UsuarioAcesso(usuario, senha);
    }

}
