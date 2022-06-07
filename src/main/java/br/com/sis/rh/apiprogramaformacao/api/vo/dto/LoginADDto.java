package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.sis.rh.apiprogramaformacao.api.model.permissoes.LoginAD;

public class LoginADDto {
    private String matricula;
    private LocalDate dataPrimeiroAcesso;
    private String perfil;

    public LoginADDto(LoginAD login) {
        this.matricula = login.getMatricula();
        this.dataPrimeiroAcesso = login.getDataPrimeiroAcesso();
        this.perfil = login.getFk_perfil().getNome();
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDate getDataPrimeiroAcesso() {
        return dataPrimeiroAcesso;
    }

    public void setDataPrimeiroAcesso(LocalDate dataPrimeiroAcesso) {
        this.dataPrimeiroAcesso = dataPrimeiroAcesso;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public static List<LoginADDto> converter(List<LoginAD> matriculas){
        return matriculas.stream().map(LoginADDto::new).collect(Collectors.toList());
    }
}
