package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.model.ProcessoSeletivo;
import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.api.model.Remuneracao;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CadastroParticipanteForm {
    private String cpf;
    private String instituicaoEnsino;
    private String curso;
    private LocalDate terminoGraduacao;
    private String cargo;
    private BigDecimal salario;
    private Programa nomeTurma;

    public CadastroParticipanteForm(){

    }

    public CadastroParticipanteForm(Participante participante, Programa programa, ProcessoSeletivo processoSeletivo, Remuneracao remuneracao){
        this.cpf = participante.getCpf();
        this.instituicaoEnsino = participante.getFaculdade();
        this.curso = participante.getCurso();
        this.terminoGraduacao = participante.getDataFinal();
        this.cargo = remuneracao.getCargo();
        this.salario = remuneracao.getBolsa();
        this.nomeTurma = programa;
    }

}
