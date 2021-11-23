package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import br.com.sis.rh.apiprogramaformacao.api.controller.FolhaController;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class FiltragemFolhaDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cpf_participante")
	private String cpfParticipante;

	@Column(name = "nome_participante")
	private String nomeParticipante;

	@Column(name = "nome_programa")
	private String nomeFormacao;

	@Column(name = "nome_turma")
	private String nomeTurma;

	@Column(name = "bolsa_aux")
	private BigDecimal bolsaAux;

	@Column(name = "beneficios")
	private BigDecimal beneficios;

	@Column(name = "convenio")
	private BigDecimal convenio;

	@Column(name = "hr_extra")
	private BigDecimal horaExtra;

	@Column(name = "beneficio_legislacao")
	private BigDecimal beneficioLegislacao;

	@Column(name = "remun_esporadica")
	private BigDecimal remuneracaoEsporadica;

	@Column(name = "remun_extra")
	private BigDecimal remuneracaoExtra;

	@Column(name = "alura")
	private BigDecimal alura;

	@Column(name = "data_fim_programa")
	private LocalDate dataFim;

	@Column(name = "data_inicio_programa")
	private LocalDate dataInicio;

	public FiltragemFolhaDto() {

	}

	public String getCpfParticipante() {
		return cpfParticipante;
	}

	public void setCpfParticipante(String cpfParticipante) {
		this.cpfParticipante = cpfParticipante;
	}

	public String getNomeParticipante() {
		return nomeParticipante;
	}

	public void setNomeParticipante(String nomeParticipante) {
		this.nomeParticipante = nomeParticipante;
	}

	public String getNomeFormacao() {
		return nomeFormacao;
	}

	public void setNomeFormacao(String nomeFormacao) {
		this.nomeFormacao = nomeFormacao;
	}

	public String getNomeTurma() {
		return nomeTurma;
	}

	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}

	public BigDecimal getBolsaAux() {
		return bolsaAux;
	}

	public void setBolsaAux(BigDecimal bolsaAux) {
		this.bolsaAux = bolsaAux;
	}

	public BigDecimal getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(BigDecimal beneficios) {
		this.beneficios = beneficios;
	}

	public BigDecimal getConvenio() {
		return convenio;
	}

	public void setConvenio(BigDecimal convenio) {
		this.convenio = convenio;
	}

	public BigDecimal getHoraExtra() {
		return horaExtra;
	}

	public void setHoraExtra(BigDecimal horaExtra) {
		this.horaExtra = horaExtra;
	}

	public BigDecimal getBeneficioLegislacao() {
		return beneficioLegislacao;
	}

	public void setBeneficioLegislacao(BigDecimal beneficioLegislacao) {
		this.beneficioLegislacao = beneficioLegislacao;
	}

	public BigDecimal getRemuneracaoEsporadica() {
		return remuneracaoEsporadica;
	}

	public void setRemuneracaoEsporadica(BigDecimal remuneracaoEsporadica) {
		this.remuneracaoEsporadica = remuneracaoEsporadica;
	}

	public BigDecimal getRemuneracaoExtra() {
		return remuneracaoExtra;
	}

	public void setRemuneracaoExtra(BigDecimal remuneracaoExtra) {
		this.remuneracaoExtra = remuneracaoExtra;
	}

	public BigDecimal getAlura() {
		return alura;
	}

	public void setAlura(BigDecimal alura) {
		this.alura = alura;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

}
