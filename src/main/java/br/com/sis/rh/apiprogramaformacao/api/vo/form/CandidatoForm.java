package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import br.com.sis.rh.apiprogramaformacao.api.model.Candidato;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusCandidato;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class CandidatoForm {

    private String nome;
    private String telefone;
    private String fonteRecrutamento;
    private LocalDate dataAgendamento;
    private String curso;
    private String observacao;
    private StatusCandidato status;
    private BigDecimal testeLogico;
    private String notaDisc;

    public Candidato converter (){
        return new Candidato(nome, telefone, dataAgendamento, testeLogico, notaDisc, status, observacao, fonteRecrutamento, curso);
    }
}
