package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

public class TurmaModalDto {
    private Long id;
    private String turma;

    public TurmaModalDto(String turma, Long id) {
        this.turma = turma;
        this.id = id;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
}
