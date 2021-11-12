package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.sis.rh.apiprogramaformacao.api.model.Ciclo;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.core.enums.ResultadoCiclo;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusCiclo;

public class CicloFinalForm {
	private ResultadoCiclo resultado;
	private String dataAlteracao;
	private String cargoEfetivado;
	private byte[] comprovante;
	private String campoObservacao;
	
	

	public ResultadoCiclo getResultado() {
		return resultado;
	}
	public void setResultado(ResultadoCiclo resultado) {
		this.resultado = resultado;
	}
	public String getDataAlteracao() {
		return dataAlteracao;
	}
	public void setDataAlteracao(String dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
	public String getCargoEfetivado() {
		return cargoEfetivado;
	}
	public void setCargoEfetivado(String cargoEfetivado) {
		this.cargoEfetivado = cargoEfetivado;
	}

	public byte[] getComprovante() {
		return comprovante;
	}
	public void setComprovante(byte[] comprovante) {
		this.comprovante = comprovante;
	}
	public String getCampoObservacao() {
		return campoObservacao;
	}
	public void setCampoObservacao(String campoObservacao) {
		this.campoObservacao = campoObservacao;
	}

	public Ciclo converter (Participante participante) {
		LocalDate data = LocalDate.parse(this.dataAlteracao, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return new Ciclo(participante, data, cargoEfetivado, comprovante, resultado,
				StatusCiclo.FINAL, campoObservacao);
	}


}
