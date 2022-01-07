package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import br.com.sis.rh.apiprogramaformacao.api.model.LoginAD;
import br.com.sis.rh.apiprogramaformacao.api.model.Perfil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class LoginADForm {

    private String matricula;
    private String perfil;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public LoginAD converter(Perfil perfil) {
        LoginAD loginAD = new LoginAD(matricula, perfil);
        loginAD.setAtivo(new BCryptPasswordEncoder().encode("1"));
        return loginAD;
    }
}
