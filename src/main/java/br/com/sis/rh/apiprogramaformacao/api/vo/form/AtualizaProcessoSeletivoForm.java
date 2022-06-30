package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import java.time.LocalDate;

import br.com.sis.rh.apiprogramaformacao.api.model.processoseletivo.ProcessoSeletivo;
import br.com.sis.rh.apiprogramaformacao.core.repository.informacoesgerais.InstrutorRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.processoseletivo.ProcessoSeletivoRepository;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("AtualizaProcessoSeletivoForm")
public class AtualizaProcessoSeletivoForm {

	@ApiModelProperty(value = "nome do candidato", required = true, example = "João da Silva")
	private String nome;

	@ApiModelProperty(value = "nome do instrutor", required = true, example = "Marcos da Silva")
	private String nomeInstrutor;

	@ApiModelProperty(value = "data do início do processo", required = true, example = "2022-10-05")
	private LocalDate dataInicio;

	@ApiModelProperty(value = "data do término do processo", required = true, example = "2022-12-05")
	private LocalDate dataFim;

	@ApiModelProperty(value = "quantidade de estagiários no processo", required = true, example = "15")
	private Integer qtdEstagiario;

	@ApiModelProperty(value = "quantidade de trainees no processo", required = true, example = "15")
	private Integer qtdTrainees;

	@ApiModelProperty(value = "quantidade de aprendizes no processo", required = true, example = "15")
	private Integer qtdAprendizes;
	
	@ApiModelProperty(value = "status do processo", required = true, example = "EM_ANDAMENTO")
    private String status;
	
	@ApiModelProperty(value = "Nome da turma", required = true, example = "01-2022")
    private String nomeTurma;

    public ProcessoSeletivo atualiza(ProcessoSeletivo processoSeletivo, ProcessoSeletivoRepository repository, InstrutorRepository instrutorRepository){
        processoSeletivo.setInstrutor(instrutorRepository.findInstrutorByNome(this.nomeInstrutor));
        processoSeletivo.setQtdTrainee(this.qtdTrainees);
        processoSeletivo.setQtdAprendiz(this.qtdAprendizes);
        processoSeletivo.setQtdEstagiario(this.qtdEstagiario);
        processoSeletivo.setDataInicio(this.dataInicio);
        processoSeletivo.setDataFim(this.dataFim);
        processoSeletivo.setStatus(this.status);
        processoSeletivo.setNome(this.nome);
        processoSeletivo.setNomeTurma(this.nomeTurma);
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

    public Integer getQtdEstagiario() {
        return qtdEstagiario;
    }

    public void setQtdEstagiario(Integer qtdEstagiario) {
        this.qtdEstagiario = qtdEstagiario;
    }

    public Integer getQtdTrainees() {
        return qtdTrainees;
    }

    public void setQtdTrainees(Integer qtdTrainees) {
        this.qtdTrainees = qtdTrainees;
    }

    public Integer getQtdAprendizes() {
        return qtdAprendizes;
    }

    public void setQtdAprendizes(Integer qtdAprendizes) {
        this.qtdAprendizes = qtdAprendizes;
    }

	public String getNomeTurma() {
		return nomeTurma;
	}
    
    
}
