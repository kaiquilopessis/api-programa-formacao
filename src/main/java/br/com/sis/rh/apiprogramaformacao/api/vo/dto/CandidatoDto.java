package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import br.com.sis.rh.apiprogramaformacao.api.model.Candidato;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CandidatoDto {
    private Long id;
    private String nome;
    private String contato;
    private String fonteRecrutamento;
    private LocalDate dataAgendamento;
    private String curso;
    private Long status;
    private BigDecimal provaPratica;
    //private File curriculo;
    //private File arquivoDisc;
    private String disc;
    private String observacoes;

    public CandidatoDto(Candidato candidato){
        this.id = candidato.getId();
        this.nome = candidato.getNome();
        this.fonteRecrutamento = candidato.getFonteRecrutamento();
        this.contato = candidato.getTelefone();
        this.dataAgendamento = candidato.getDataAgendamento();
        this.curso = candidato.getCurso();
        this.status = candidato.getStatus();
        this.provaPratica = candidato.getTesteLogico();
        this.observacoes = candidato.getObservacao();
        this.disc = candidato.getNotaDisc();
    }
}
