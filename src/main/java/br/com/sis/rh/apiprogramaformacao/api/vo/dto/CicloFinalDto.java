package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import java.time.LocalDate;

import br.com.sis.rh.apiprogramaformacao.api.model.acompanhamento.Ciclo;
import br.com.sis.rh.apiprogramaformacao.core.enums.ResultadoCiclo;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusCiclo;

public class CicloFinalDto {

	private Long id;
	private ResultadoCiclo resultado;
	private LocalDate dataRegistro;
	private StatusCiclo status;
	private String cargoPrograma;
	private String cargoEfetivado;
	private String observacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ResultadoCiclo getResultado() {
		return resultado;
	}

	public void setResultado(ResultadoCiclo resultado) {
		this.resultado = resultado;
	}

	public LocalDate getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(LocalDate dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public StatusCiclo getStatus() {
		return status;
	}

	public void setStatus(StatusCiclo status) {
		this.status = status;
	}

	public String getCargoPrograma() {
		return cargoPrograma;
	}

	public void setCargoPrograma(String cargoPrograma) {
		this.cargoPrograma = cargoPrograma;
	}

	public String getCargoEfetivado() {
		return cargoEfetivado;
	}

	public void setCargoEfetivado(String cargoEfetivado) {
		this.cargoEfetivado = cargoEfetivado;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public CicloFinalDto(Ciclo conclusaoFinal) {
		this.id = conclusaoFinal.getId();
		this.resultado = conclusaoFinal.getResultado();
		this.dataRegistro = conclusaoFinal.getDataAlteracao();
		this.cargoEfetivado = conclusaoFinal.getCargoEfetivado();
		this.observacao = conclusaoFinal.getObservacao();
	}
}
