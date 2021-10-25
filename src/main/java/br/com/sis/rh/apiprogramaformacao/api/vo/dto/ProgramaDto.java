package br.com.sis.rh.apiprogramaformacao.api.vo.dto;


import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProgramaDto {
    private String nomePrograma;
    private String nomeTurma;

    public ProgramaDto(Programa programa) {
        this.nomePrograma = programa.getNome();
        this.nomeTurma = programa.getNomeTurma();
    }
}
