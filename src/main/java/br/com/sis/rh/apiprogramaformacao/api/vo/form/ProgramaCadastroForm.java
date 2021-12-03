package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;
import br.com.sis.rh.apiprogramaformacao.api.model.ProcessoSeletivo;
import br.com.sis.rh.apiprogramaformacao.api.model.Programa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProgramaCadastroForm {

    private String nome;
    private String inicio;
    private String termino;
    private String instrutor;
    private String turma;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getTermino() {
        return termino;
    }

    public void setTermino(String termino) {
        this.termino = termino;
    }

    public String getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(String instrutor) {
        this.instrutor = instrutor;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public Programa converter(ProcessoSeletivo processoSeletivo, Instrutor instrutor,
                              ProgramaCadastroForm programaCadastroForm){
        Programa programa = new Programa();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dataInicio = LocalDate.parse((CharSequence) programaCadastroForm.getInicio(), formatter);
        LocalDate dataFim = LocalDate.parse((CharSequence) programaCadastroForm.getTermino(), formatter);

        programa.setProcessoSeletivo(processoSeletivo);
        programa.setDataInicio(dataInicio);
        programa.setDataFim(dataFim);
        programa.getProcessoSeletivo().setInstrutor(instrutor);
        programa.setNomeTurma(programaCadastroForm.getTurma());
        programa.setStatus("EM_ANDAMENTO");

        return programa;
    }
}
