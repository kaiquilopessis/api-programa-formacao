package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import br.com.sis.rh.apiprogramaformacao.api.model.UsuarioAcesso;
import lombok.Data;

@Data
public class UsuarioForm {
    private String usuario;
    private String senha;

    public UsuarioAcesso converter(){
        return new UsuarioAcesso(usuario, senha);
    }
}
