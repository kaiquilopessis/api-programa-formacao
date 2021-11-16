package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;
import br.com.sis.rh.apiprogramaformacao.api.model.ProcessoSeletivo;
import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ProcessoSeletivoDto;
import br.com.sis.rh.apiprogramaformacao.core.repository.InstrutorRepository;

import java.time.LocalDate;

public class ProcessoSeletivoForm {

    private String nome;
    private String nomeInstrutor;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Long qtdEstagiario;
    private Long qtdTrainees;
    private Long qtdAprendizes;

    public ProcessoSeletivo converter(InstrutorRepository instrutorRepository){
        ProcessoSeletivo processoSeletivo = new ProcessoSeletivo();
        processoSeletivo.setNome(this.nome);
        processoSeletivo.setDataFim(this.dataFim);
        processoSeletivo.setDataInicio(this.dataInicio);
        processoSeletivo.setStatus("EM_ANDAMENTO");
        processoSeletivo.setQtdAprendiz(this.qtdAprendizes);
        processoSeletivo.setQtdEstagiario(this.qtdEstagiario);
        processoSeletivo.setQtdTrainee(this.qtdTrainees);
        processoSeletivo.setInstrutor(instrutorRepository.findInstrutorByNome(this.nomeInstrutor));

        return processoSeletivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeInstrutor() {
        return nomeInstrutor;
    }

    public void setNomeInstrutor(String nomeInstrutor) {
        this.nomeInstrutor = nomeInstrutor;
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

    public Long getQtdEstagiario() {
        return qtdEstagiario;
    }

    public void setQtdEstagiario(Long qtdEstagiario) {
        this.qtdEstagiario = qtdEstagiario;
    }

    public Long getQtdTrainees() {
        return qtdTrainees;
    }

    public void setQtdTrainees(Long qtdTrainees) {
        this.qtdTrainees = qtdTrainees;
    }

    public Long getQtdAprendizes() {
        return qtdAprendizes;
    }

    public void setQtdAprendizes(Long qtdAprendizes) {
        this.qtdAprendizes = qtdAprendizes;
    }
}
