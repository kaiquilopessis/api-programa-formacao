package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.sis.rh.apiprogramaformacao.api.model.informacoesgerais.Programa;


public class TurmaDto {

    private String nomeTurma;

    public TurmaDto(Programa programa) {
        this.nomeTurma = programa.getProcessoSeletivo().getNomeTurma();
    }

    public static List<TurmaDto> converter (List<Programa> programas){
        return programas.stream().map(TurmaDto::new).collect(Collectors.toList());
    }

	public String getNomeTurma() {
		return nomeTurma;
	}

	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}
    
    
}
