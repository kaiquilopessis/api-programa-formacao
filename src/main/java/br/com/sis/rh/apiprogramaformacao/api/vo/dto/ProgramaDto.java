package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.sis.rh.apiprogramaformacao.api.model.Programa;


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
        this.qtdAprendiz = programa.getProcessoSeletivo().getQtdAprendiz();
        this.qtdEstagiario = programa.getProcessoSeletivo().getQtdEstagiario();
        this.qtdTrainee = programa.getProcessoSeletivo().getQtdTrainee();

        // Participantes se referem a soma dos colaboradores
        this.participantesTotais = (programa.getProcessoSeletivo().getQtdAprendiz() + programa.getProcessoSeletivo().getQtdEstagiario() + programa.getProcessoSeletivo().getQtdTrainee());
    }
    


    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public String getNomeInstrutor() {
        return nomeInstrutor;
    }

    public void setNomeInstrutor(String nomeInstrutor) {
        this.nomeInstrutor = nomeInstrutor;
    }

    public long getQtdAprendiz() {
        return qtdAprendiz;
    }

    public void setQtdAprendiz(long qtdAprendiz) {
        this.qtdAprendiz = qtdAprendiz;
    }

    public long getQtdEstagiario() {
        return qtdEstagiario;
    }

    public void setQtdEstagiario(long qtdEstagiario) {
        this.qtdEstagiario = qtdEstagiario;
    }

    public long getQtdTrainee() {
        return qtdTrainee;
    }

    public void setQtdTrainee(long qtdTrainee) {
        this.qtdTrainee = qtdTrainee;
    }

    public long getParticipantesTotais() {
        return participantesTotais;
    }

    public void setParticipantesTotais(long participantesTotais) {
        this.participantesTotais = participantesTotais;
    }
    
    public static List<ProgramaDto> converter(List<Programa> programa){
		return programa.stream().map(ProgramaDto::new).collect(Collectors.toList());
	}
}
