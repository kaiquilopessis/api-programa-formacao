package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.sis.rh.apiprogramaformacao.api.model.Conclusao;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.core.enums.ResultadoConclusao;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusConclusao;

public class ConclusaoFinalForm {
	private ResultadoConclusao resultado;
	private String dataAlteracao;
	private String cargoEfetivado;
	private byte[] comprovante;
	private String campoObservacao;
	
	

	public ResultadoConclusao getResultado() {
		return resultado;
	}
	public void setResultado(ResultadoConclusao resultado) {
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

	public Conclusao converter (Participante participante) {
		LocalDate data = LocalDate.parse(this.dataAlteracao, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return new Conclusao(participante, data, cargoEfetivado, comprovante, resultado,
				StatusConclusao.FINAL, campoObservacao);
	}


}
