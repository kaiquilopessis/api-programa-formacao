package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.sis.rh.apiprogramaformacao.api.model.Avaliacoes;

public class AvaliacoesDto {

	private Long id;

	private Float notaTecnica;

	private Float notaComportamental;

	private Float notaPraticasAgeis;

	private Float notaLideranca;

	private Float notaNegocios;

	public AvaliacoesDto(Avaliacoes avaliacao) {
		this.id = avaliacao.getId();
		this.notaComportamental = avaliacao.getNotaComportamental();
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

	public Float getNotaTecnica() {
		return notaTecnica;
	}

	public void setNotaTecnica(Float notaTecnica) {
		this.notaTecnica = notaTecnica;
	}

	public Float getNotaComportamental() {
		return notaComportamental;
	}

	public void setNotaComportamental(Float notaComportamental) {
		this.notaComportamental = notaComportamental;
	}

	public Float getNotaPraticasAgeis() {
		return notaPraticasAgeis;
	}

	public void setNotaPraticasAgeis(Float notaPraticasAgeis) {
		this.notaPraticasAgeis = notaPraticasAgeis;
	}

	public Float getNotaLideranca() {
		return notaLideranca;
	}

	public void setNotaLideranca(Float notaLideranca) {
		this.notaLideranca = notaLideranca;
	}

	public Float getNotaNegocios() {
		return notaNegocios;
	}

	public void setNotaNegocios(Float notaNegocios) {
		this.notaNegocios = notaNegocios;
	}
	
	public static List<AvaliacoesDto> converter (List<Avaliacoes> avaliacoes){
		return avaliacoes.stream().map(AvaliacoesDto::new).collect(Collectors.toList());
	}
	
}
