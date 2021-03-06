package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.sis.rh.apiprogramaformacao.api.model.acompanhamento.Ciclo;
import br.com.sis.rh.apiprogramaformacao.core.enums.ResultadoCiclo;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusCiclo;

public class CicloDto {

	private Long id;
	private ResultadoCiclo resultado;
	private LocalDate dataRegistro;
	private StatusCiclo status;
	private String cargoPrograma;
	private String cargoEfetivado;
	private String observacao;

	public CicloDto(Ciclo conclusao) {
		this.id = conclusao.getId();
		this.resultado = conclusao.getResultado();
		this.dataRegistro = conclusao.getDataAlteracao();
		this.status = conclusao.getStatusProgresso();
		if (conclusao.getStatusProgresso() == StatusCiclo.PROGRESSIVA) {
			this.cargoPrograma = conclusao.getCargoPrograma().getCargo();
		}
		this.cargoEfetivado = conclusao.getCargoEfetivado();
		this.observacao = conclusao.getObservacao();
	}

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

	public static List<CicloDto> converter(List<Ciclo> conclusoes) {
		return conclusoes.stream().map(CicloDto::new).collect(Collectors.toList());
	}

}
