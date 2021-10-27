package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import br.com.sis.rh.apiprogramaformacao.api.model.Candidato;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusCandidato;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CandidatoDto {
    private Long id;
    private String nome;
    private String telefone;
    private String fonteRecrutamento;
    private LocalDate dataAgendamento;
    private String curso;
    private String status;
    private BigDecimal testeLogico;
    //private File curriculo;
    //private File arquivoDisc;
    private String notaDisc;
    private String observacoes;

    public CandidatoDto(Candidato candidato){
        this.id = candidato.getId();
        this.nome = candidato.getNome();
        this.fonteRecrutamento = candidato.getFonteRecrutamento();
        this.telefone = candidato.getTelefone();
        this.dataAgendamento = candidato.getDataAgendamento();
        this.curso = candidato.getCurso();
        this.status = candidato.getStatus();
        this.testeLogico = candidato.getTesteLogico();
        this.observacoes = candidato.getObservacao();
        this.notaDisc = candidato.getNotaDisc();
    }
}
