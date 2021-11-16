package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ProgramaDto {

    private String nomeTurma;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String nomeInstrutor;
    private long qtdAprendiz;
    private long qtdEstagiario;
    private long qtdTrainee;
    private long participantesTotais;

    public ProgramaDto(Programa programa) {
        this.nomeTurma = programa.getNomeTurma();
        this.dataInicio = programa.getDataInicio();
        this.dataFim = programa.getDataFim();
        this.qtdAprendiz = programa.getQtdAprendiz();
        this.qtdEstagiario = programa.getQtdEstagiario();
        this.qtdTrainee = programa.getQtdTrainee();

        // Participantes se referem a soma dos colaboradores
        this.participantesTotais = (programa.getQtdAprendiz() + programa.getQtdEstagiario() + programa.getQtdTrainee());
    }

}
