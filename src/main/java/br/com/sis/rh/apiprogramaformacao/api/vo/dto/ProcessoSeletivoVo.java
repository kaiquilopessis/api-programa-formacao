package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.sis.rh.apiprogramaformacao.api.model.processoseletivo.ProcessoSeletivo;

public class ProcessoSeletivoVo {
    private Long id;
    private String nome;
    private String status;
    private String nomeTurma;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getNomeTurma() {
		return nomeTurma;
	}

	public ProcessoSeletivoVo(ProcessoSeletivo processoSeletivo) {
        this.id = processoSeletivo.getId();
        this.nome = processoSeletivo.getNome();
        this.status = processoSeletivo.getStatus();
        this.nomeTurma = processoSeletivo.getNomeTurma();
    }
    public static List<ProcessoSeletivoVo> converter(List<ProcessoSeletivo> listarProcesso){
        return listarProcesso.stream().map(ProcessoSeletivoVo::new).collect(Collectors.toList());
    }
}