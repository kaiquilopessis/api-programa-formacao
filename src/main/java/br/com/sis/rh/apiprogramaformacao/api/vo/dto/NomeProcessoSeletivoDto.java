package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import br.com.sis.rh.apiprogramaformacao.api.model.ProcessoSeletivo;

public class NomeProcessoSeletivoDto {
    String nomePrograma;

    public String getNomePrograma() {
        return nomePrograma;
    }

    public void setNomePrograma(String nomePrograma) {
        this.nomePrograma = nomePrograma;
    }

    public NomeProcessoSeletivoDto(){

    }

    public NomeProcessoSeletivoDto(ProcessoSeletivo processoSeletivo){
        this.nomePrograma = processoSeletivo.getNome();
    }
}
