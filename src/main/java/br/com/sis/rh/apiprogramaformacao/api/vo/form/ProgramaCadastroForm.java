package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;
import br.com.sis.rh.apiprogramaformacao.api.model.ProcessoSeletivo;
import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@ApiModel("Forulário para cadastrar um novo programa")
public class ProgramaCadastroForm {

	@ApiModelProperty(value = "nome do programa", required = true, example = "Java")
	private String nome;
	
	@ApiModelProperty(value = "data do início do programa", required = true, example = "2022-01-21")
	private String inicio;
	
	@ApiModelProperty(value = "data do término do programa", required = true, example = "2022-06-21")
	private String termino;
	
	@ApiModelProperty(value = "nome do instrutor", required = true, example = "Pablo Oliveira")
	private String instrutor;
	
	@ApiModelProperty(value = "nome da turma", required = true, example = "Turma 2")
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
			ProgramaCadastroForm programaCadastroForm) {
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
