package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import br.com.sis.rh.apiprogramaformacao.api.model.LoginAD;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class LoginADForm {

    private String matricula;
    private Integer nivelAcesso;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Integer getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(Integer nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public LoginAD converter() {
        LoginAD loginAD = new LoginAD(matricula, nivelAcesso);
        loginAD.setAtivo(new BCryptPasswordEncoder().encode("1"));
        return loginAD;
    }
}
