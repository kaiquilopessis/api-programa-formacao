package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;
import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.core.repository.InstrutorRepository;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Optional;

public class ProgramaCadastroForm {

    @NotNull @NotEmpty
    private String nome;
    @NotNull
    private LocalDate inicio;
    @NotNull
    private LocalDate termino;
    @NotNull @NotEmpty
    private Instrutor instrutor;
    @NotNull @NotEmpty
    private String turma;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getInicio() {
        return inicio;
    }
    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public LocalDate getTermino() {
        return termino;
    }
    public void setTermino(LocalDate termino) {
        this.termino = termino;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }

    public String getTurma() {
        return turma;
    }
    public void setTurma(String turma) {
        this.turma = turma;
    }

    public Programa converter(InstrutorRepository repository){
        Programa programa = new Programa();
        System.out.println(this.instrutor.getCpfInstrutor());
        Optional<Instrutor> optInstrutor = repository.findById(this.instrutor.getCpfInstrutor());

        programa.getProcessoSeletivo().setNome(this.nome);
        programa.setDataInicio(this.inicio);
        programa.setDataFim(this.termino);
        programa.getProcessoSeletivo().setInstrutor(optInstrutor.get());
        programa.setNomeTurma(this.turma);
        programa.setStatus("EM_ANDAMENTO");

        return programa;
    }
}
