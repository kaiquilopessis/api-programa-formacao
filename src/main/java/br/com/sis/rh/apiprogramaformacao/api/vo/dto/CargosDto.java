package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import br.com.sis.rh.apiprogramaformacao.api.model.Remuneracao;

import java.util.List;
import java.util.stream.Collectors;

public class CargosDto {

    private String nome;

    public CargosDto(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CargosDto (Remuneracao remuneracao){
        this.nome = remuneracao.getCargo();
    }

    public static List<CargosDto> converter(List<Remuneracao> remuneracoes) {
        return remuneracoes.stream().map(CargosDto::new).collect(Collectors.toList());
    }

}
