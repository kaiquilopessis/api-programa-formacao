package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import br.com.sis.rh.apiprogramaformacao.api.model.Candidato;
import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.api.model.RemuneracaoPrograma;

import java.math.BigDecimal;

public class InvestimentoFolhaDto {
    private Long id;
    private String nome;
    private String nomePrograma;
    private String nomeTurma;
    private BigDecimal bolsaAux;

    public InvestimentoFolhaDto(Candidato candidato, Programa programa, RemuneracaoPrograma remuneracaoPrograma) {
        this.nome = candidato.getNome();
        this.nomePrograma = programa.getNome();
        this.nomeTurma = programa.getNomeTurma();
        this.bolsaAux = remuneracaoPrograma.getBolsa();
    }

}
