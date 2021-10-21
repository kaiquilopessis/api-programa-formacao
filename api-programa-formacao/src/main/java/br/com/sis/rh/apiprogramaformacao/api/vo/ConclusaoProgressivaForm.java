package br.com.sis.rh.apiprogramaformacao.api.vo;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.sis.rh.apiprogramaformacao.core.enums.ResultadoConclusao;

public class ConclusaoProgressivaForm {
	private ResultadoConclusao resultado;
	private LocalDate dataAlteracao;
	// TODO Falar com Guilherme mudar para cargo
	private BigDecimal salario;
	// TODO Mudar para receber arquivo
	private String Comprovante;

	public ResultadoConclusao getResultado() {
		return resultado;
	}

	public void setResultado(ResultadoConclusao resultado) {
		this.resultado = resultado;
	}

	public LocalDate getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(LocalDate dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public String getComprovante() {
		return Comprovante;
	}

	public void setComprovante(String comprovante) {
		Comprovante = comprovante;
	}

}
