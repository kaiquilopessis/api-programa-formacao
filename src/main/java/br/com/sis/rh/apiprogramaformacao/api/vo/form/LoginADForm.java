package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import br.com.sis.rh.apiprogramaformacao.api.model.LoginAD;
import br.com.sis.rh.apiprogramaformacao.api.model.Perfil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ApiModel("Form de Login AD SiS")
public class LoginADForm {

	@ApiModelProperty(value = "matrícula do usuário", required = true, example = "jsilva")
    private String matricula;
	
	@ApiModelProperty(value = "perfil do usuário", required = true, example = "ROLE_USUARIOPADRAO")
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
