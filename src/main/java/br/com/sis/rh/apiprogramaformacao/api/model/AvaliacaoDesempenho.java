package br.com.sis.rh.apiprogramaformacao.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.sis.rh.apiprogramaformacao.core.enums.Avaliacao;

@Entity
@Table(name = "TB_AVALIACAO_DESEMPENHO")
public class AvaliacaoDesempenho {

	@Column(name = "ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "AVALIACAO")
	private Avaliacao avaliacao;

	@Enumerated(EnumType.STRING)
	@Column(name = "PARECER")
	private Parecer parecer;

	@Column(name = "ADAPTACAO")
	private Double adaptacao;

	@Column(name = "QUALIDADE")
	private Double qualidade;

	@Column(name = "CAP_TECNICA")
	private Double capTecnica;

	@Column(name = "COMUNICABILIDADE")
	private Double comunicabilidade;

	@Column(name = "AP_PRATICA")
	private Double apPratica;

	@Column(name = "DEDICACAO")
	private Double dedicado;

	@Column(name = "COOPERACAO")
	private Double cooperacao;

	@Column(name = "INICIATIVA")
	private Double iniciativa;

	@Column(name = "DISCIPLINA")
	private Double disciplina;

	@Column(name = "ORGANIZACAO")
	private Double organizacao;

	@Column(name = "RESPONSABILIDADE")
	private Double responsabilidade;

	@Column(name = "SOCIABILIDADE")
	private Double sociabilidade;

	@Column(name = "MEDIA")
	private Double media;

	public AvaliacaoDesempenho() {

	}

	public AvaliacaoDesempenho(Avaliacao avaliacao, Parecer parecer, Double adaptacao, Double qualidade,
			Double capTecnica, Double comunicabilidade, Double apPratica, Double dedicado, Double cooperacao,
			Double iniciativa, Double disciplina, Double organizacao, Double responsabilidade, Double sociabilidade,
			Double media) {
		this.avaliacao = avaliacao;
		this.parecer = parecer;
		this.adaptacao = adaptacao;
		this.qualidade = qualidade;
		this.capTecnica = capTecnica;
		this.comunicabilidade = comunicabilidade;
		this.apPratica = apPratica;
		this.dedicado = dedicado;
		this.cooperacao = cooperacao;
		this.iniciativa = iniciativa;
		this.disciplina = disciplina;
		this.organizacao = organizacao;
		this.responsabilidade = responsabilidade;
		this.sociabilidade = sociabilidade;
		this.media = media;
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

	public Double getDedicado() {
		return dedicado;
	}

	public void setDedicado(Double dedicado) {
		this.dedicado = dedicado;
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

}
