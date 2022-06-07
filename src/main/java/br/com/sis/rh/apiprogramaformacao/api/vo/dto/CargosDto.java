package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.sis.rh.apiprogramaformacao.api.model.cargos.Remuneracao;

public class CargosDto {

    private Long id;
    private String nome;

    public CargosDto(){

    }

    public CargosDto (Remuneracao remuneracao){
        this.nome = remuneracao.getCargo();
        this.id = remuneracao.getId();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static List<CargosDto> converter(List<Remuneracao> remuneracoes) {
        return remuneracoes.stream().map(CargosDto::new).collect(Collectors.toList());
    }

}
