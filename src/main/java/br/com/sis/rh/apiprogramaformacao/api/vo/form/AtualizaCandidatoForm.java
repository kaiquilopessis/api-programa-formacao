package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import br.com.sis.rh.apiprogramaformacao.api.model.Candidato;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusCandidato;
import br.com.sis.rh.apiprogramaformacao.core.repository.CandidatoRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class AtualizaCandidatoForm {

    private String nome;
    private String telefone;
    private String fonteRecrutamento;
    private LocalDate dataAgendamento;
    private String curso;
    private String observacao;
    private String status;
    private BigDecimal testeLogico;
    private String notaDisc;

    public Candidato atualizar(Long id, CandidatoRepository candidatoRepository) {

        Candidato candidato = candidatoRepository.getById(id);
        candidato.setNome(this.nome);
        candidato.setTelefone(this.telefone);
        candidato.setFonteRecrutamento(this.fonteRecrutamento);
        candidato.setDataAgendamento(this.dataAgendamento);
        candidato.setCurso(this.curso);
        candidato.setObservacao(this.observacao);
        candidato.setStatus(this.status);
        candidato.setTesteLogico(this.testeLogico);
        candidato.setNotaDisc(this.notaDisc);
        return candidato;
    }
}
