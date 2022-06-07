package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import java.math.BigDecimal;

import br.com.sis.rh.apiprogramaformacao.api.model.acompanhamento.AvaliacaoDesempenho;
import br.com.sis.rh.apiprogramaformacao.core.enums.Avaliacao;
import br.com.sis.rh.apiprogramaformacao.core.enums.Parecer;

public class AvaliacaoDesempenhoDto {
	private Long id;
	private Avaliacao avaliacao;
	private Parecer parecer;
	private BigDecimal adaptacao;
	private BigDecimal qualidade;
	private BigDecimal capTecnica;
	private BigDecimal comunicabilidade;
	private BigDecimal apPratica;
	private BigDecimal dedicacao;
	private BigDecimal cooperacao;
	private BigDecimal iniciativa;
	private BigDecimal disciplina;
	private BigDecimal organizacao;
	private BigDecimal responsabilidade;
	private BigDecimal sociabilidade;
	private BigDecimal media;
	
	public AvaliacaoDesempenhoDto(AvaliacaoDesempenho avaliacaoDesempenho) {
		this.id = avaliacaoDesempenho.getId();
		this.avaliacao = avaliacaoDesempenho.getAvaliacao();
		this.parecer = avaliacaoDesempenho.getParecer();
		this.adaptacao = avaliacaoDesempenho.getAdaptacao();
		this.qualidade = avaliacaoDesempenho.getQualidade();
		this.capTecnica = avaliacaoDesempenho.getCapTecnica();
		this.comunicabilidade = avaliacaoDesempenho.getComunicabilidade();
		this.apPratica = avaliacaoDesempenho.getApPratica();
		this.dedicacao = avaliacaoDesempenho.getDedicacao();
		this.cooperacao = avaliacaoDesempenho.getCooperacao();
		this.iniciativa = avaliacaoDesempenho.getIniciativa();
		this.disciplina = avaliacaoDesempenho.getDisciplina();
		this.organizacao = avaliacaoDesempenho.getOrganizacao();
		this.responsabilidade = avaliacaoDesempenho.getResponsabilidade();
		this.sociabilidade = avaliacaoDesempenho.getSociabilidade();
		this.media = avaliacaoDesempenho.getMedia();
	}

	public Long getId() {
		return id;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public Parecer getParecer() {
		return parecer;
	}

	public BigDecimal getAdaptacao() {
		return adaptacao;
	}

	public BigDecimal getQualidade() {
		return qualidade;
	}

	public BigDecimal getCapTecnica() {
		return capTecnica;
	}

	public BigDecimal getComunicabilidade() {
		return comunicabilidade;
	}

	public BigDecimal getApPratica() {
		return apPratica;
	}

	public BigDecimal getDedicacao() {
		return dedicacao;
	}

	public BigDecimal getCooperacao() {
		return cooperacao;
	}

	public BigDecimal getIniciativa() {
		return iniciativa;
	}

	public BigDecimal getDisciplina() {
		return disciplina;
	}

	public BigDecimal getOrganizacao() {
		return organizacao;
	}

	public BigDecimal getResponsabilidade() {
		return responsabilidade;
	}

	public BigDecimal getSociabilidade() {
		return sociabilidade;
	}

	public BigDecimal getMedia() {
		return media;
	}

}
