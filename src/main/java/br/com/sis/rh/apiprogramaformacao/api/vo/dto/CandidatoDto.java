package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import br.com.sis.rh.apiprogramaformacao.api.model.Candidato;
import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.api.model.RemuneracaoPrograma;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusCandidatoParticipante;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class CandidatoDto {
    private Long id;
    private String nome;
    private String nomePrograma;
    private String nomeTurma;
    private BigDecimal bolsaAux;


    public CandidatoDto(Candidato candidato, Programa programa, RemuneracaoPrograma remuneracaoPrograma) {
        this.id = candidato.getId();
        this.nome = candidato.getNome();
        this.nomePrograma = programa.getNome();
        this.nomeTurma = programa.getNomeTurma();
        this.bolsaAux = remuneracaoPrograma.getBolsa();

    }

    public CandidatoDto(Candidato candidato) {
    }

    public static List<CandidatoDto> converter(List<Candidato> candidatos) {
        return candidatos.stream().map(CandidatoDto::new).collect(Collectors.toList());
    }
}
