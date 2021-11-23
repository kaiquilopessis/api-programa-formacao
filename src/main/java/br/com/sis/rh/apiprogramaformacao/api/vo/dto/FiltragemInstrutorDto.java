package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FiltragemInstrutorDto {
	private String cpfInstrutor;
	private String nomeInstrutor;
	private String nomePrograma;
	private String nomeTurma;
	private Integer qtdHora;
	private BigDecimal vlrHora;
	private LocalDate dataLancamento;
	private LocalDate dataFim;

	public FiltragemInstrutorDto(String cpfInstrutor, String nomeInstrutor, String nomePrograma, String nomeTurma,
			Integer qtdHora, BigDecimal vlrHora, LocalDate dataLancamento, LocalDate dataFim) {
		this.cpfInstrutor = cpfInstrutor;
		this.nomeInstrutor = nomeInstrutor;
		this.nomePrograma = nomePrograma;
		this.nomeTurma = nomeTurma;
		this.qtdHora = qtdHora;
		this.vlrHora = vlrHora;
		this.dataLancamento = dataLancamento;
		this.dataFim = dataFim;
	}

	public FiltragemInstrutorDto() {

	}

	public String getCpfInstrutor() {
		return cpfInstrutor;
	}

	public void setCpfInstrutor(String cpfInstrutor) {
		this.cpfInstrutor = cpfInstrutor;
	}

	public String getNomeInstrutor() {
		return nomeInstrutor;
	}

	public void setNomeInstrutor(String nomeInstrutor) {
		this.nomeInstrutor = nomeInstrutor;
	}

	public String getNomePrograma() {
		return nomePrograma;
	}

	public void setNomePrograma(String nomePrograma) {
		this.nomePrograma = nomePrograma;
	}

	public String getNomeTurma() {
		return nomeTurma;
	}

	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}

	public Integer getQtdHora() {
		return qtdHora;
	}

	public void setQtdHora(Integer qtdHora) {
		this.qtdHora = qtdHora;
	}

	public BigDecimal getVlrHora() {
		return vlrHora;
	}

	public void setVlrHora(BigDecimal vlrHora) {
		this.vlrHora = vlrHora;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

}
