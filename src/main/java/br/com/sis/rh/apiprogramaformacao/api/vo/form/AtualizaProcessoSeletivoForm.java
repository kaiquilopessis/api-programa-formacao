package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import br.com.sis.rh.apiprogramaformacao.api.model.ProcessoSeletivo;
import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.core.repository.InstrutorRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ProcessoSeletivoRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ProgramaRepository;

import java.time.LocalDate;

public class AtualizaProcessoSeletivoForm {

    private String nome;
    private String nomeInstrutor;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Long qtdEstagiario;
    private Long qtdTrainees;
    private Long qtdAprendizes;
    private String status;

    public ProcessoSeletivo atualiza(Long id , ProcessoSeletivoRepository repository, InstrutorRepository instrutorRepository){
        ProcessoSeletivo processoSeletivo = repository.getById(id);

        processoSeletivo.setInstrutor(instrutorRepository.findInstrutorByNome(this.nomeInstrutor));
        processoSeletivo.setQtdTrainee(this.qtdTrainees);
        processoSeletivo.setQtdAprendiz(this.qtdAprendizes);
        processoSeletivo.setQtdEstagiario(this.qtdEstagiario);
        processoSeletivo.setDataInicio(this.dataInicio);
        processoSeletivo.setDataFim(this.dataFim);
        processoSeletivo.setStatus(this.status);
        processoSeletivo.setNome(this.nome);
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
