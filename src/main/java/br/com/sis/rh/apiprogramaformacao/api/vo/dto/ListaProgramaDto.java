package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

/*
 * Referenciar com a chamada de todos os atributos que vierem da url 'busca';
 */

@Getter
@Setter
@NoArgsConstructor
public class ListaProgramaDto {

    private Long id;
    private String nome;
    private String status;

    public ListaProgramaDto(Programa programa) {
        this.id = programa.getId();
        this.nome = programa.getNome();
        this.status = programa.getStatus();
    }

    // Transformar a lista em lista DTO
    public static List<ListaProgramaDto> toListaProgramaDto(List<Programa> programa){
        return programa.stream().map(ListaProgramaDto::new).collect(Collectors.toList());
    }
}
