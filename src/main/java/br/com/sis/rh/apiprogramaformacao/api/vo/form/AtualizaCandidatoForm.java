package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.web.multipart.MultipartFile;
import br.com.sis.rh.apiprogramaformacao.api.model.Candidato;
import br.com.sis.rh.apiprogramaformacao.core.repository.CandidatoRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ProcessoSeletivoRepository;

public class AtualizaCandidatoForm {

	private String nome;
	private String telefone;
	private String fonteRecrutamento;
	private String dataAgendamento;
	private String observacao;
	private String status;
	private BigDecimal testeLogico;
	private String notaDisc;
	private MultipartFile disc;
	private MultipartFile curriculo;
	private Long idProcessoSeletivo;

	public Candidato atualizar(Long id, CandidatoRepository candidatoRepository,
			ProcessoSeletivoRepository processoSeletivoRepository) throws IOException {

		LocalDate data = LocalDate.parse(this.dataAgendamento, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

		Candidato candidato = candidatoRepository.getById(id);

		if (disc == null && curriculo == null) {
			candidato.setNome(this.nome);
			candidato.setTelefone(this.telefone);
			candidato.setFonteRecrutamento(this.fonteRecrutamento);
			candidato.setDataAgendamento(data);
			candidato.setObservacao(this.observacao);
			candidato.setStatus(this.status);
			candidato.setTesteLogico(this.testeLogico);
			candidato.setNotaDisc(this.notaDisc);
			candidato.setProcessoSeletivo(processoSeletivoRepository.getById(idProcessoSeletivo));
		
		} else if (disc != null && curriculo == null) {
			candidato.setDisc(this.disc.getBytes());
			candidato.setNome(this.nome);
			candidato.setTelefone(this.telefone);
			candidato.setFonteRecrutamento(this.fonteRecrutamento);
			candidato.setDataAgendamento(data);
			candidato.setObservacao(this.observacao);
			candidato.setStatus(this.status);
			candidato.setTesteLogico(this.testeLogico);
			candidato.setNotaDisc(this.notaDisc);
		
		} else if (disc == null && curriculo != null) {
			candidato.setNome(this.nome);
			candidato.setTelefone(this.telefone);
			candidato.setFonteRecrutamento(this.fonteRecrutamento);
			candidato.setDataAgendamento(data);
			candidato.setObservacao(this.observacao);
			candidato.setStatus(this.status);
			candidato.setTesteLogico(this.testeLogico);
			candidato.setCurriculo(this.curriculo.getBytes());
		
		} else if (disc != null && curriculo != null) {
			candidato.setNome(this.nome);
			candidato.setTelefone(this.telefone);
			candidato.setFonteRecrutamento(this.fonteRecrutamento);
			candidato.setDataAgendamento(data);
			candidato.setObservacao(this.observacao);
			candidato.setStatus(this.status);
			candidato.setTesteLogico(this.testeLogico);
			candidato.setNotaDisc(this.notaDisc);
			candidato.setProcessoSeletivo(processoSeletivoRepository.getById(idProcessoSeletivo));
			candidato.setDisc(this.disc.getBytes()); 
			candidato.setCurriculo(this.curriculo.getBytes());
		}
		return candidato;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getFonteRecrutamento() {
		return fonteRecrutamento;
	}

	public void setFonteRecrutamento(String fonteRecrutamento) {
		this.fonteRecrutamento = fonteRecrutamento;
	}

	public String getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(String dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getTesteLogico() {
		return testeLogico;
	}

	public void setTesteLogico(BigDecimal testeLogico) {
		this.testeLogico = testeLogico;
	}

	public String getNotaDisc() {
		return notaDisc;
	}

	public void setNotaDisc(String notaDisc) {
		this.notaDisc = notaDisc;
	}

	public Long getIdProcessoSeletivo() {
		return idProcessoSeletivo;
	}

	public void setIdProcessoSeletivo(Long idProcessoSeletivo) {
		this.idProcessoSeletivo = idProcessoSeletivo;
	}

	public MultipartFile getDisc() {
		return disc;
	}

	public void setDisc(MultipartFile disc) {
		this.disc = disc;
	}

	public MultipartFile getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(MultipartFile curriculo) {
		this.curriculo = curriculo;
	}

}
