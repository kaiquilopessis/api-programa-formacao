package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import br.com.sis.rh.apiprogramaformacao.api.model.Candidato;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusCandidatoParticipante;
import br.com.sis.rh.apiprogramaformacao.core.repository.CandidatoRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CandidatoForm {

    private String nome;
    private String telefone;
    private String fonteRecrutamento;
    private LocalDate dataAgendamento;
    private String curso;
    private String observacao;
    private StatusCandidatoParticipante status;
    private BigDecimal testeLogico;
    private String notaDisc;

    public CandidatoForm(Candidato candidato){
        this.nome = candidato.getNome();
        this.telefone = candidato.getTelefone();
        this.fonteRecrutamento = candidato.getFonteRecrutamento();
        this.dataAgendamento = candidato.getDataAgendamento();
        this.curso = candidato.getCurso();
        this.observacao = candidato.getObservacao();
        this.status = candidato.getStatusCandidatoParticipante();
        this.testeLogico = candidato.getTesteLogico();
        this.notaDisc = candidato.getNotaDisc();
    }

    public Candidato converter (){
        return new Candidato(nome, telefone, dataAgendamento, testeLogico, notaDisc, status, observacao, fonteRecrutamento, curso);
    }
}
