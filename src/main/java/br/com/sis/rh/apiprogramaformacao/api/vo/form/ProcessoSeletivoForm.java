package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import java.time.LocalDate;

import br.com.sis.rh.apiprogramaformacao.api.model.ProcessoSeletivo;
import br.com.sis.rh.apiprogramaformacao.core.repository.informacoesgerais.InstrutorRepository;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Formulário do Processo seletivo")
public class ProcessoSeletivoForm {

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

	public ProcessoSeletivo converter(InstrutorRepository instrutorRepository) {
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
}
