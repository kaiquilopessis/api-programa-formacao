package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.sis.rh.apiprogramaformacao.api.model.ProcessoSeletivo;

public class ProcessoSeletivoVo {
    private String nome;
    private String status;

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

    public ProcessoSeletivoVo(ProcessoSeletivo processoSeletivo) {
        this.nome = processoSeletivo.getNome();
        this.status = processoSeletivo.getStatus();
    }
    public static List<ProcessoSeletivoVo> converter(List<ProcessoSeletivo> listarProcesso){
        return listarProcesso.stream().map(ProcessoSeletivoVo::new).collect(Collectors.toList());
    }
}