package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.sis.rh.apiprogramaformacao.api.model.processoseletivo.ProcessoSeletivo;

public class  ListaDeProcessoSeletivoDto {

    private Long id;
    private String nome;
    private String nomeTurma;
    private String status;

    public ListaDeProcessoSeletivoDto(ProcessoSeletivo processoSeletivo){
        this.id = processoSeletivo.getId();
        this.nome = processoSeletivo.getNome();
        this.status = processoSeletivo.getStatus();
        this.nomeTurma = processoSeletivo.getNomeTurma();
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

    public String getNomeTurma() {
		return nomeTurma;
	}

	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}

	public static List<ListaDeProcessoSeletivoDto> gerarLista(List<ProcessoSeletivo> lista){
        return lista.stream().map(ListaDeProcessoSeletivoDto::new).collect(Collectors.toList());
    }
}
