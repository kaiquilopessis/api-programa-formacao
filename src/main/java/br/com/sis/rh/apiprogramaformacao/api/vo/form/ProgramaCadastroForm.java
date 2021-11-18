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
    private String instrutorCpf;
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

    public String getInstrutorCpf() {
        return instrutorCpf;
    }
    public void setInstrutorCpf(String instrutorCpf) {
        this.instrutorCpf = instrutorCpf;
    }

    public String getTurma() {
        return turma;
    }
    public void setTurma(String turma) {
        this.turma = turma;
    }

    public Programa converter(InstrutorRepository repository){
        Programa programa = new Programa();
        Optional<Instrutor> optInstrutor = repository.findById(this.instrutorCpf);

        programa.getProcessoSeletivo().setNome(this.nome);
        programa.setDataInicio(this.inicio);
        programa.setDataFim(this.termino);
        programa.getProcessoSeletivo().setInstrutor(optInstrutor.get());
        programa.setNomeTurma(this.turma);
        programa.setStatus("EM_ANDAMENTO");

        return programa;
    }
}
