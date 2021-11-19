package br.com.sis.rh.apiprogramaformacao.api.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.sis.rh.apiprogramaformacao.core.enums.Avaliacao;
import br.com.sis.rh.apiprogramaformacao.core.enums.Parecer;

@Entity(name = "TB_AVALIACAO_DESEMPENHO")
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
	private BigDecimal adaptacao;

	@Column(name = "QUALIDADE")
	private BigDecimal qualidade;

	@Column(name = "CAP_TECNICA")
	private BigDecimal capTecnica;

	@Column(name = "COMUNICABILIDADE")
	private BigDecimal comunicabilidade;

	@Column(name = "AP_PRATICA")
	private BigDecimal apPratica;

	@Column(name = "DEDICACAO")
	private BigDecimal dedicacao;

	@Column(name = "COOPERACAO")
	private BigDecimal cooperacao;

	@Column(name = "INICIATIVA")
	private BigDecimal iniciativa;

	@Column(name = "DISCIPLINA")
	private BigDecimal disciplina;

	@Column(name = "ORGANIZACAO")
	private BigDecimal organizacao;

	@Column(name = "RESPONSABILIDADE")
	private BigDecimal responsabilidade;

	@Column(name = "SOCIABILIDADE")
	private BigDecimal sociabilidade;

	@Column(name = "MEDIA")
	private BigDecimal media;

	public AvaliacaoDesempenho() {

	}

	public AvaliacaoDesempenho(Avaliacao avaliacao, Parecer parecer, BigDecimal adaptacao, BigDecimal qualidade,
			BigDecimal capTecnica, BigDecimal comunicabilidade, BigDecimal apPratica, BigDecimal dedicacao, BigDecimal cooperacao,
			BigDecimal iniciativa, BigDecimal disciplina, BigDecimal organizacao, BigDecimal responsabilidade, BigDecimal sociabilidade,
			BigDecimal media) {
		this.avaliacao = avaliacao;
		this.parecer = parecer;
		this.adaptacao = adaptacao;
		this.qualidade = qualidade;
		this.capTecnica = capTecnica;
		this.comunicabilidade = comunicabilidade;
		this.apPratica = apPratica;
		this.dedicacao = dedicacao;
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

	public BigDecimal getDedicacao() {
		return dedicacao;
	}

	public void setDedicacao(BigDecimal dedicacao) {
		this.dedicacao = dedicacao;
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

}
