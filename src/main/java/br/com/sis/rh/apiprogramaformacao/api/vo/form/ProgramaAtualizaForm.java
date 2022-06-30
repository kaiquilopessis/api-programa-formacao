package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import java.time.LocalDate;

import br.com.sis.rh.apiprogramaformacao.api.model.informacoesgerais.Instrutor;
import br.com.sis.rh.apiprogramaformacao.api.model.informacoesgerais.Programa;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Formulário para atualizar o programa")
public class ProgramaAtualizaForm {
	
	@ApiModelProperty(value = "id do programa", required = true, example = "1")
	private Long id;
	
	@ApiModelProperty(value = "data do início do processo", required = true, example = "2022-10-05")
	private LocalDate dataInicio;

	@ApiModelProperty(value = "data do término do processo", required = true, example = "2022-12-05")
	private LocalDate dataFim;
	
	@ApiModelProperty(value = "nome do instrutor", required = true, example = "Marcos da Silva")
	private String instrutor;
	
	@ApiModelProperty(value = "nome da turma", required = true, example = "02-2022")
	private String nomeTurma;
	
	public Programa atualizar(Programa programa, Instrutor instrutor) {
		programa.setDataInicio(this.dataInicio);
		programa.setDataFim(this.dataFim);
		programa.getProcessoSeletivo().setInstrutor(instrutor);
		programa.getProcessoSeletivo().setNomeTurma(this.nomeTurma);
		return programa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	public String getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(String instrutor) {
		this.instrutor = instrutor;
	}

}
