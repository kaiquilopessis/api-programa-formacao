package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;

import br.com.sis.rh.apiprogramaformacao.api.model.AvaliacaoDesempenho;
import br.com.sis.rh.apiprogramaformacao.api.model.Avaliacoes;

public class AvaliacoesDto {

	private Long id;

	private BigDecimal notaTecnica;

	private AvaliacaoDesempenho notaComportamental;

	private BigDecimal notaPraticasAgeis;

	private BigDecimal notaLideranca;

	private BigDecimal notaNegocios;

	private Long idAvaliacaoDesempenho;

	public AvaliacoesDto(Avaliacoes avaliacao) {
		this.id = avaliacao.getId();
		this.idAvaliacaoDesempenho = avaliacao.getAvaliacaoDesempenho().getId();
		this.notaComportamental = avaliacao.getAvaliacaoDesempenho();
		this.notaLideranca = avaliacao.getNotaLideranca();
		this.notaNegocios = avaliacao.getNotaNegocios();
		this.notaPraticasAgeis = avaliacao.getNotaPraticasAgeis();
		this.notaTecnica = avaliacao.getNotaTecnica();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getNotaTecnica() {
		return notaTecnica;
	}

	public void setNotaTecnica(BigDecimal notaTecnica) {
		this.notaTecnica = notaTecnica;
	}

	

	public AvaliacaoDesempenho getNotaComportamental() {
		return notaComportamental;
	}

	public void setNotaComportamental(AvaliacaoDesempenho notaComportamental) {
		this.notaComportamental = notaComportamental;
	}

	public BigDecimal getNotaPraticasAgeis() {
		return notaPraticasAgeis;
	}

	public void setNotaPraticasAgeis(BigDecimal notaPraticasAgeis) {
		this.notaPraticasAgeis = notaPraticasAgeis;
	}

	public BigDecimal getNotaLideranca() {
		return notaLideranca;
	}

	public void setNotaLideranca(BigDecimal notaLideranca) {
		this.notaLideranca = notaLideranca;
	}

	public BigDecimal getNotaNegocios() {
		return notaNegocios;
	}

	public void setNotaNegocios(BigDecimal notaNegocios) {
		this.notaNegocios = notaNegocios;
	}

	public Long getIdAvaliacaoDesempenho() {
		return idAvaliacaoDesempenho;
	}

	public void setIdAvaliacaoDesempenho(Long idAvaliacaoDesempenho) {
		this.idAvaliacaoDesempenho = idAvaliacaoDesempenho;
	}

	public static ResponseEntity<List<AvaliacoesDto>> converter(List<Avaliacoes> avaliacoes) {
		return (ResponseEntity<List<AvaliacoesDto>>) avaliacoes.stream().map(AvaliacoesDto::new).collect(Collectors.toList());
	}

}
