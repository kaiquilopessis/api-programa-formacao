package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.sis.rh.apiprogramaformacao.api.model.processoseletivo.Candidato;
import br.com.sis.rh.apiprogramaformacao.api.model.processoseletivo.ProcessoSeletivo;

public class CandidatoCompletoDto {
	private long id;
	private String nome;
	private String telefone;
	private LocalDate dataAgendamento;
	private BigDecimal testeLogico;
	private String notaDisc;
	private String status;
	private String observacao;
	private byte[] disc;
	private byte[] curriculo;
	private String fonteRecrutamento;
	private String indicacao;
	private ProcessoSeletivo processoSeletivo;
	private LocalDate dataConclusao;

	public CandidatoCompletoDto() {

	}

	public CandidatoCompletoDto(Candidato candidato) {
		this.id = candidato.getId();
		this.nome = candidato.getNome();
		this.telefone = candidato.getTelefone();
		this.dataAgendamento = candidato.getDataAgendamento();
		this.testeLogico = candidato.getTesteLogico();
		this.status = candidato.getStatus();
		this.observacao = candidato.getObservacao();
		this.disc = candidato.getDisc();
		this.curriculo = candidato.getCurriculo();
		this.fonteRecrutamento = candidato.getFonteRecrutamento();
		this.indicacao = candidato.getIndicacaoVaga();
		this.processoSeletivo = candidato.getProcessoSeletivo();
		this.dataConclusao = candidato.getDataConclusao();
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}

	public BigDecimal getTesteLogico() {
		return testeLogico;
	}

	public String getNotaDisc() {
		return notaDisc;
	}

	public String getStatus() {
		return status;
	}

	public String getObservacao() {
		return observacao;
	}

	public byte[] getDisc() {
		return disc;
	}

	public byte[] getCurriculo() {
		return curriculo;
	}

	public String getFonteRecrutamento() {
		return fonteRecrutamento;
	}

	public String getIndicacao() {
		return indicacao;
	}

	public ProcessoSeletivo getProcessoSeletivo() {
		return processoSeletivo;
	}

	public LocalDate getDataConclusao() {
		return dataConclusao;
	}

}
