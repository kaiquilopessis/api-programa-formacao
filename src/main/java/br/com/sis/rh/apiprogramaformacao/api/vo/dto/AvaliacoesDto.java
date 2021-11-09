package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.sis.rh.apiprogramaformacao.api.model.Avaliacoes;

public class AvaliacoesDto {

	private Long id;

	private Double notaTecnica;

	private Double notaComportamental;

	private Double notaPraticasAgeis;

	private Double notaLideranca;

	private Double notaNegocios;

	public AvaliacoesDto(Avaliacoes avaliacao) {
		this.id = avaliacao.getId();
		this.notaComportamental = avaliacao.getAvaliacaoDesempenho().getMedia();
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

	public Double getNotaTecnica() {
		return notaTecnica;
	}

	public void setNotaTecnica(Double notaTecnica) {
		this.notaTecnica = notaTecnica;
	}

	public Double getNotaComportamental() {
		return notaComportamental;
	}

	public void setNotaComportamental(Double notaComportamental) {
		this.notaComportamental = notaComportamental;
	}

	public Double getNotaPraticasAgeis() {
		return notaPraticasAgeis;
	}

	public void setNotaPraticasAgeis(Double notaPraticasAgeis) {
		this.notaPraticasAgeis = notaPraticasAgeis;
	}

	public Double getNotaLideranca() {
		return notaLideranca;
	}

	public void setNotaLideranca(Double notaLideranca) {
		this.notaLideranca = notaLideranca;
	}

	public Double getNotaNegocios() {
		return notaNegocios;
	}

	public void setNotaNegocios(Double notaNegocios) {
		this.notaNegocios = notaNegocios;
	}

	public static List<AvaliacoesDto> converter(List<Avaliacoes> avaliacoes) {
		return avaliacoes.stream().map(AvaliacoesDto::new).collect(Collectors.toList());
	}

}
