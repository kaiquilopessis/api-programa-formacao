package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurmaDto {

    private String nomeTurma;

    public TurmaDto(Programa programa) {
        this.nomeTurma = programa.getNomeTurma();
    }

    public static List<TurmaDto> converter (List<Programa> programas){
        return programas.stream().map(TurmaDto::new).collect(Collectors.toList());
    }
}
