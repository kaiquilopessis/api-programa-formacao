package br.com.sis.rh.apiprogramaformacao.api.vo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.sis.rh.apiprogramaformacao.api.model.Conclusao;
import br.com.sis.rh.apiprogramaformacao.api.model.FeedBack;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.core.enums.ResultadoConclusao;

public class ConclusaoFinalForm {
	private ResultadoConclusao resultado;
	private LocalDate dataAlteracao;
	private BigDecimal salario;
	private String cargoEfetivado;
	private String comprovante;
	private String campoObservacao;
	
	
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
	public String getCargoEfetivado() {
		return cargoEfetivado;
	}
	public void setCargoEfetivado(String cargoEfetivado) {
		this.cargoEfetivado = cargoEfetivado;
	}
	public String getComprovante() {
		return comprovante;
	}
	public void setComprovante(String comprovante) {
		this.comprovante = comprovante;
	}
	public String getCampoObservacao() {
		return campoObservacao;
	}
	public void setCampoObservacao(String campoObservacao) {
		this.campoObservacao = campoObservacao;
	}
	
	
	public Conclusao converter (Participante participante) {
		LocalDate data = LocalDate.parse(this.data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return new Conclusao(resultado, dataAlteracao, salario, cargoEfetivado, comprovante, campoObservacao);
	
	
	
}
