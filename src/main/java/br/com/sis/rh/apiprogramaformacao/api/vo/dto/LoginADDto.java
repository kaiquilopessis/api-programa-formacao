package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import br.com.sis.rh.apiprogramaformacao.api.model.LoginAD;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class LoginADDto {
    private String matricula;
    private LocalDate dataPrimeiroAcesso;

    public LoginADDto(LoginAD login) {
        this.matricula = login.getMatricula();
        this.dataPrimeiroAcesso = login.getDataPrimeiroAcesso();
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

    public static List<LoginADDto> converter(List<LoginAD> matriculas){
        return matriculas.stream().map(LoginADDto::new).collect(Collectors.toList());
    }
}
