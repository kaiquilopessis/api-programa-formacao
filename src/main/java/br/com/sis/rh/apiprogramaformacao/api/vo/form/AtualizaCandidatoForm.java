package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.multipart.MultipartFile;

import br.com.sis.rh.apiprogramaformacao.api.model.processoseletivo.Candidato;
import br.com.sis.rh.apiprogramaformacao.core.repository.processoseletivo.CandidatoRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.processoseletivo.ProcessoSeletivoRepository;

@ApiModel("Formulário para alterar um candidato")
public class AtualizaCandidatoForm {

	@ApiModelProperty(value = "Nome do candidato", required = true, example = "João Silva")
	private String nome;
	@ApiModelProperty(value = "Telefone do candidato", required = true, example = "")
	private String telefone;
	@ApiModelProperty(value = "Fonte de recrutamento", required = true, example = "")
	private String fonteRecrutamento;
	@ApiModelProperty(value = "Data de agendamento da entrevista", required = true, example = "")
	private String dataAgendamento;
	@ApiModelProperty(value = "Observação sobre o candidato", required = true, example = "")
	private String observacao;
	@ApiModelProperty(value = "Status do candidato", required = true, example = "APROVADO_2_FASE")
	private String status;
	@ApiModelProperty(value = "Resultado do teste lógico do Candidato", required = true, example = "10")
	private BigDecimal testeLogico;
	private MultipartFile curriculo;
	private MultipartFile disc;
	@ApiModelProperty(value = "Processo seletivo do candidato", required = true, example = "1")
	private Long idProcessoSeletivo;
	@ApiModelProperty(value = "Email pessoal do candidato", required = true, example = "email@email.com")
	private String email;
	@ApiModelProperty(value = "Semestre da faculdade cursado pelo candidato", required = true, example = "1")
	private String semestreFaculdade;
	@ApiModelProperty(value = "Periodo do curso do candidato", required = true, example = "Noturno")
	private String periodoCurso;
	@ApiModelProperty(value = "Data que o candidato irá concluir o curso", required = true, example = "15/02/2022")
	private String dataConclusao;
	@ApiModelProperty(value = "Duração que o curso terá", required = true, example = "8")
	private String duracaoCurso;
	@ApiModelProperty(value = "Endereço do candidato", required = true, example = "Rua Dra Nilza Lemes de Oliveira")
	private String endereco;
	@ApiModelProperty(value = "Quem indicou o candidato", required = true, example = "Kaiqui Lopes")
	private String indicacaoVaga;

	public Candidato atualizar(Long id, CandidatoRepository candidatoRepository,
			ProcessoSeletivoRepository processoSeletivoRepository) throws IOException {

		LocalDate data = LocalDate.parse(this.dataAgendamento, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

		Candidato candidato = candidatoRepository.getById(id);

		if (disc == null && curriculo == null && dataConclusao != null) {
			LocalDate dataConclusaoFormatada = LocalDate.parse(this.dataConclusao,
					DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			candidato.setNome(this.nome);
			candidato.setTelefone(this.telefone);
			candidato.setFonteRecrutamento(this.fonteRecrutamento);
			candidato.setDataAgendamento(data);
			candidato.setObservacao(this.observacao);
			candidato.setStatus(this.status);
			candidato.setTesteLogico(this.testeLogico);
			candidato.setProcessoSeletivo(processoSeletivoRepository.getById(idProcessoSeletivo));
			candidato.setEmail(this.email);
			candidato.setSemestreFaculdade(this.semestreFaculdade);
			candidato.setPeriodoCurso(this.periodoCurso);
			candidato.setDataConclusao(dataConclusaoFormatada);
			candidato.setDuracaoCurso(this.duracaoCurso);
			candidato.setEndereco(this.endereco);
			candidato.setIndicacaoVaga(this.indicacaoVaga);

		} else if (disc == null && curriculo == null && dataConclusao == null) {
			candidato.setNome(this.nome);
			candidato.setTelefone(this.telefone);
			candidato.setFonteRecrutamento(this.fonteRecrutamento);
			candidato.setDataAgendamento(data);
			candidato.setObservacao(this.observacao);
			candidato.setStatus(this.status);
			candidato.setTesteLogico(this.testeLogico);
			candidato.setProcessoSeletivo(processoSeletivoRepository.getById(idProcessoSeletivo));
			candidato.setEmail(this.email);
			candidato.setSemestreFaculdade(this.semestreFaculdade);
			candidato.setPeriodoCurso(this.periodoCurso);
			candidato.setDuracaoCurso(this.duracaoCurso);
			candidato.setEndereco(this.endereco);
			candidato.setIndicacaoVaga(this.indicacaoVaga);

		}

		else if (disc != null && curriculo == null && dataConclusao != null) {

			LocalDate dataConclusaoFormatada = LocalDate.parse(this.dataConclusao,
					DateTimeFormatter.ofPattern("yyyy-MM-dd"));

			candidato.setDisc(this.disc.getBytes());
			candidato.setNome(this.nome);
			candidato.setTelefone(this.telefone);
			candidato.setFonteRecrutamento(this.fonteRecrutamento);
			candidato.setDataAgendamento(data);
			candidato.setObservacao(this.observacao);
			candidato.setStatus(this.status);
			candidato.setTesteLogico(this.testeLogico);
			candidato.setEmail(this.email);
			candidato.setSemestreFaculdade(this.semestreFaculdade);
			candidato.setDataConclusao(dataConclusaoFormatada);
			candidato.setPeriodoCurso(this.periodoCurso);
			candidato.setDuracaoCurso(this.duracaoCurso);
			candidato.setEndereco(this.endereco);
			candidato.setIndicacaoVaga(this.indicacaoVaga);

		} else if (disc != null && curriculo == null && dataConclusao == null) {

			candidato.setDisc(this.disc.getBytes());
			candidato.setNome(this.nome);
			candidato.setTelefone(this.telefone);
			candidato.setFonteRecrutamento(this.fonteRecrutamento);
			candidato.setDataAgendamento(data);
			candidato.setObservacao(this.observacao);
			candidato.setStatus(this.status);
			candidato.setTesteLogico(this.testeLogico);
			candidato.setEmail(this.email);
			candidato.setSemestreFaculdade(this.semestreFaculdade);
			candidato.setPeriodoCurso(this.periodoCurso);
			candidato.setDuracaoCurso(this.duracaoCurso);
			candidato.setEndereco(this.endereco);
			candidato.setIndicacaoVaga(this.indicacaoVaga);

		}

		else if (disc == null && curriculo != null && dataConclusao != null) {
			LocalDate dataConclusaoFormatada = LocalDate.parse(this.dataConclusao,
					DateTimeFormatter.ofPattern("yyyy-MM-dd"));

			candidato.setNome(this.nome);
			candidato.setTelefone(this.telefone);
			candidato.setFonteRecrutamento(this.fonteRecrutamento);
			candidato.setDataAgendamento(data);
			candidato.setObservacao(this.observacao);
			candidato.setStatus(this.status);
			candidato.setTesteLogico(this.testeLogico);
			candidato.setCurriculo(this.curriculo.getBytes());
			candidato.setEmail(this.email);
			candidato.setSemestreFaculdade(this.semestreFaculdade);
			candidato.setDataConclusao(dataConclusaoFormatada);
			candidato.setPeriodoCurso(this.periodoCurso);
			candidato.setDuracaoCurso(this.duracaoCurso);
			candidato.setEndereco(this.endereco);
			candidato.setIndicacaoVaga(this.indicacaoVaga);

		} else if (disc == null && curriculo != null && dataConclusao == null) {
			candidato.setNome(this.nome);
			candidato.setTelefone(this.telefone);
			candidato.setFonteRecrutamento(this.fonteRecrutamento);
			candidato.setDataAgendamento(data);
			candidato.setObservacao(this.observacao);
			candidato.setStatus(this.status);
			candidato.setTesteLogico(this.testeLogico);
			candidato.setCurriculo(this.curriculo.getBytes());
			candidato.setEmail(this.email);
			candidato.setSemestreFaculdade(this.semestreFaculdade);
			candidato.setPeriodoCurso(this.periodoCurso);
			candidato.setDuracaoCurso(this.duracaoCurso);
			candidato.setEndereco(this.endereco);
			candidato.setIndicacaoVaga(this.indicacaoVaga);

		} else if (disc != null && curriculo != null && dataConclusao != null) {
			LocalDate dataConclusaoFormatada = LocalDate.parse(this.dataConclusao,
					DateTimeFormatter.ofPattern("yyyy-MM-dd"));

			candidato.setNome(this.nome);
			candidato.setTelefone(this.telefone);
			candidato.setFonteRecrutamento(this.fonteRecrutamento);
			candidato.setDataAgendamento(data);
			candidato.setObservacao(this.observacao);
			candidato.setStatus(this.status);
			candidato.setTesteLogico(this.testeLogico);
			candidato.setProcessoSeletivo(processoSeletivoRepository.getById(idProcessoSeletivo));
			candidato.setDisc(this.disc.getBytes());
			candidato.setCurriculo(this.curriculo.getBytes());
			candidato.setEmail(this.email);
			candidato.setSemestreFaculdade(this.semestreFaculdade);
			candidato.setPeriodoCurso(this.periodoCurso);
			candidato.setDataConclusao(dataConclusaoFormatada);
			candidato.setDuracaoCurso(this.duracaoCurso);
			candidato.setEndereco(this.endereco);
			candidato.setIndicacaoVaga(this.indicacaoVaga);
		}

		else if (disc != null && curriculo != null && dataConclusao == null) {

			candidato.setNome(this.nome);
			candidato.setTelefone(this.telefone);
			candidato.setFonteRecrutamento(this.fonteRecrutamento);
			candidato.setDataAgendamento(data);
			candidato.setObservacao(this.observacao);
			candidato.setStatus(this.status);
			candidato.setTesteLogico(this.testeLogico);
			candidato.setProcessoSeletivo(processoSeletivoRepository.getById(idProcessoSeletivo));
			candidato.setDisc(this.disc.getBytes());
			candidato.setCurriculo(this.curriculo.getBytes());
			candidato.setEmail(this.email);
			candidato.setSemestreFaculdade(this.semestreFaculdade);
			candidato.setPeriodoCurso(this.periodoCurso);
			candidato.setDuracaoCurso(this.duracaoCurso);
			candidato.setEndereco(this.endereco);
			candidato.setIndicacaoVaga(this.indicacaoVaga);
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSemestreFaculdade() {
		return semestreFaculdade;
	}

	public void setSemestreFaculdade(String semestreFaculdade) {
		this.semestreFaculdade = semestreFaculdade;
	}

	public String getPeriodoCurso() {
		return periodoCurso;
	}

	public void setPeriodoCurso(String periodoCurso) {
		this.periodoCurso = periodoCurso;
	}

	public String getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(String dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	public String getDuracaoCurso() {
		return duracaoCurso;
	}

	public void setDuracaoCurso(String duracaoCurso) {
		this.duracaoCurso = duracaoCurso;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getIndicacaoVaga() {
		return indicacaoVaga;
	}

	public void setIndicacaoVaga(String indicacaoVaga) {
		this.indicacaoVaga = indicacaoVaga;
	}

}
