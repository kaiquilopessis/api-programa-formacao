package br.com.sis.rh.apiprogramaformacao.api.vo.dto;


import br.com.sis.rh.apiprogramaformacao.api.model.Candidato;
import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.api.model.RemuneracaoPrograma;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class InstrutorDto {
    private Long id;
    private String nome;
    private String nomePrograma;
    private String nomeTurma;
    private BigDecimal bolsaAux;


    public InstrutorDto(Candidato candidato, Programa programa, RemuneracaoPrograma remuneracaoPrograma) {
        this.id = candidato.getId();
        this.nome = candidato.getNome();
        this.nomePrograma = programa.getNome();
        this.nomeTurma = programa.getNomeTurma();
        this.bolsaAux = remuneracaoPrograma.getBolsa();
    }
//        public static CandidatoDto converterParaDto(Candidato candidato){
//        return new CandidatoDto(candidato);
//    }
//
//    public static List<CandidatoDto> converterListaParaDto(List<Candidato> candidatos){
//        List<CandidatoDto> CandidatoDtos = new ArrayList<>();
//
//        candidatos.forEach(candidato -> {
//            CandidatoDtos.add(new CandidatoDto(candidatos));
//        });
//
//        return CandidatoDtos;
//    }
//

}
