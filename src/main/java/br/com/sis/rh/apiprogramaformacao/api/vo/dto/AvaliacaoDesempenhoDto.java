package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import java.math.BigDecimal;

import br.com.sis.rh.apiprogramaformacao.api.model.AvaliacaoDesempenho;
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

	public void setId(Long id) {
		this.id = id;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Parecer getParecer() {
		return parecer;
	}

	public void setParecer(Parecer parecer) {
		this.parecer = parecer;
	}

	public BigDecimal getAdaptacao() {
		return adaptacao;
	}

	public void setAdaptacao(BigDecimal adaptacao) {
		this.adaptacao = adaptacao;
	}

	public BigDecimal getQualidade() {
		return qualidade;
	}

	public void setQualidade(BigDecimal qualidade) {
		this.qualidade = qualidade;
	}

	public BigDecimal getCapTecnica() {
		return capTecnica;
	}

	public void setCapTecnica(BigDecimal capTecnica) {
		this.capTecnica = capTecnica;
	}

	public BigDecimal getComunicabilidade() {
		return comunicabilidade;
	}

	public void setComunicabilidade(BigDecimal comunicabilidade) {
		this.comunicabilidade = comunicabilidade;
	}

	public BigDecimal getApPratica() {
		return apPratica;
	}

	public void setApPratica(BigDecimal apPratica) {
		this.apPratica = apPratica;
	}

	public BigDecimal getCooperacao() {
		return cooperacao;
	}

	public void setCooperacao(BigDecimal cooperacao) {
		this.cooperacao = cooperacao;
	}

	public BigDecimal getIniciativa() {
		return iniciativa;
	}

	public void setIniciativa(BigDecimal iniciativa) {
		this.iniciativa = iniciativa;
	}

	public BigDecimal getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(BigDecimal disciplina) {
		this.disciplina = disciplina;
	}

	public BigDecimal getOrganizacao() {
		return organizacao;
	}

	public void setOrganizacao(BigDecimal organizacao) {
		this.organizacao = organizacao;
	}

	public BigDecimal getResponsabilidade() {
		return responsabilidade;
	}

	public void setResponsabilidade(BigDecimal responsabilidade) {
		this.responsabilidade = responsabilidade;
	}

	public BigDecimal getSociabilidade() {
		return sociabilidade;
	}

	public void setSociabilidade(BigDecimal sociabilidade) {
		this.sociabilidade = sociabilidade;
	}

	public BigDecimal getMedia() {
		return media;
	}

	public void setMedia(BigDecimal media) {
		this.media = media;
	}
	
	public BigDecimal getDedicacao() {
		return dedicacao;
	}

	public void setDedicacao(BigDecimal dedicacao) {
		this.dedicacao = dedicacao;
	}

}
