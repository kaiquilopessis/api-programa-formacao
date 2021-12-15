package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import br.com.sis.rh.apiprogramaformacao.api.model.ProcessoSeletivo;

import java.util.List;
import java.util.stream.Collectors;

public class  ListaDeProcessoSeletivoDto {

    private Long id;
    private String nome;
    private String status;

    public ListaDeProcessoSeletivoDto(ProcessoSeletivo processoSeletivo){
        this.id = processoSeletivo.getId();
        this.nome = processoSeletivo.getNome();
        this.status = processoSeletivo.getStatus();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static List<ListaDeProcessoSeletivoDto> gerarLista(List<ProcessoSeletivo> lista){
        return lista.stream().map(ListaDeProcessoSeletivoDto::new).collect(Collectors.toList());
    }
}
