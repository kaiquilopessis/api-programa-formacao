package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.web.multipart.MultipartFile;

import br.com.sis.rh.apiprogramaformacao.api.model.Ciclo;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.core.enums.ResultadoCiclo;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusCiclo;

public class CicloFinalForm {
	private ResultadoConclusao resultado;
	private String dataAlteracao;
	private String cargoEfetivado;
	private MultipartFile comprovante;
	private String campoObservacao;

	public ResultadoCiclo getResultado() {
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

	public MultipartFile getComprovante() {
		return comprovante;
	}

	public void setComprovante(MultipartFile comprovante) {
		this.comprovante = comprovante;
	}

	public String getCampoObservacao() {
		return campoObservacao;
	}

	public void setCampoObservacao(String campoObservacao) {
		this.campoObservacao = campoObservacao;
	}

	public Ciclo converter(Participante participante) throws IOException {
		LocalDate data = LocalDate.parse(this.dataAlteracao, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return new Ciclo(participante, data, cargoEfetivado, comprovante.getBytes(), resultado, StatusConclusao.FINAL,
				campoObservacao);
	}

}
