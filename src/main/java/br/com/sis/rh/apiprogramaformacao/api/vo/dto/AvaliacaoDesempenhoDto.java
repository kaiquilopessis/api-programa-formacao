package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import br.com.sis.rh.apiprogramaformacao.api.model.AvaliacaoDesempenho;
import br.com.sis.rh.apiprogramaformacao.api.model.Parecer;
import br.com.sis.rh.apiprogramaformacao.core.enums.Avaliacao;

public class AvaliacaoDesempenhoDto {
	private Long id;
	
	private Avaliacao avaliacao;

	private Parecer parecer;

	private Double adaptacao;

	private Double qualidade;

	private Double capTecnica;

	private Double comunicabilidade;

	private Double apPratica;

	private Double dedicacao;

	private Double cooperacao;

	private Double iniciativa;

	private Double disciplina;

	private Double organizacao;

	private Double responsabilidade;

	private Double sociabilidade;

	private Double media;
	
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

	public Double getAdaptacao() {
		return adaptacao;
	}

	public void setAdaptacao(Double adaptacao) {
		this.adaptacao = adaptacao;
	}

	public Double getQualidade() {
		return qualidade;
	}

	public void setQualidade(Double qualidade) {
		this.qualidade = qualidade;
	}

	public Double getCapTecnica() {
		return capTecnica;
	}

	public void setCapTecnica(Double capTecnica) {
		this.capTecnica = capTecnica;
	}

	public Double getComunicabilidade() {
		return comunicabilidade;
	}

	public void setComunicabilidade(Double comunicabilidade) {
		this.comunicabilidade = comunicabilidade;
	}

	public Double getApPratica() {
		return apPratica;
	}

	public void setApPratica(Double apPratica) {
		this.apPratica = apPratica;
	}

	public Double getCooperacao() {
		return cooperacao;
	}

	public void setCooperacao(Double cooperacao) {
		this.cooperacao = cooperacao;
	}

	public Double getIniciativa() {
		return iniciativa;
	}

	public void setIniciativa(Double iniciativa) {
		this.iniciativa = iniciativa;
	}

	public Double getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Double disciplina) {
		this.disciplina = disciplina;
	}

	public Double getOrganizacao() {
		return organizacao;
	}

	public void setOrganizacao(Double organizacao) {
		this.organizacao = organizacao;
	}

	public Double getResponsabilidade() {
		return responsabilidade;
	}

	public void setResponsabilidade(Double responsabilidade) {
		this.responsabilidade = responsabilidade;
	}

	public Double getSociabilidade() {
		return sociabilidade;
	}

	public void setSociabilidade(Double sociabilidade) {
		this.sociabilidade = sociabilidade;
	}

	public Double getMedia() {
		return media;
	}

	public void setMedia(Double media) {
		this.media = media;
	}
	
	public Double getDedicacao() {
		return dedicacao;
	}

	public void setDedicacao(Double dedicacao) {
		this.dedicacao = dedicacao;
	}

}
