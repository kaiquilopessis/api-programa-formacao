package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import br.com.sis.rh.apiprogramaformacao.api.model.Perfil;

import java.util.List;
import java.util.stream.Collectors;

public class PerfilDto {

    private Integer id;
    private String nome;

    public PerfilDto (Perfil perfil){
        this.id = perfil.getId();
        this.nome = perfil.getNome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static List<PerfilDto> converter(List<Perfil> perfil){
       return perfil.stream().map(PerfilDto::new).collect(Collectors.toList());
    }
}
