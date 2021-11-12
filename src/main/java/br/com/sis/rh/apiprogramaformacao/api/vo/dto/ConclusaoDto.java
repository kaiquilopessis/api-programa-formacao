package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.sis.rh.apiprogramaformacao.api.model.Conclusao;
import br.com.sis.rh.apiprogramaformacao.core.enums.ResultadoConclusao;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusConclusao;

public class ConclusaoDto {

	private Long id;
	private ResultadoConclusao resultado;
	private LocalDate dataRegistro;
	private StatusConclusao status;
	private byte[] comprovante;
	private String cargoPrograma;
	private String cargoEfetivado;
	private String observacao;

	public ConclusaoDto(Conclusao conclusao) {
		this.id = conclusao.getId();
		this.resultado = conclusao.getResultado();
		this.dataRegistro = conclusao.getDataAlteracao();
		this.status = conclusao.getStatusProgresso();
		this.comprovante = conclusao.getComprovanteRematricula();
		if (conclusao.getStatusProgresso() == StatusConclusao.PROGRESSIVA) {
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

	public ResultadoConclusao getResultado() {
		return resultado;
	}

	public void setResultado(ResultadoConclusao resultado) {
		this.resultado = resultado;
	}

	public LocalDate getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(LocalDate dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public StatusConclusao getStatus() {
		return status;
	}

	public void setStatus(StatusConclusao status) {
		this.status = status;
	}

	public byte[] getComprovante() {
		return comprovante;
	}

	public void setComprovante(byte[] comprovante) {
		this.comprovante = comprovante;
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

	public static List<ConclusaoDto> converter(List<Conclusao> conclusoes) {
		return conclusoes.stream().map(ConclusaoDto::new).collect(Collectors.toList());
	}

}
