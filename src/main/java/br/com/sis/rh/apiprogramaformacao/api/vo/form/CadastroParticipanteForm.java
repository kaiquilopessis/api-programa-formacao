package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import java.io.IOException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.web.multipart.MultipartFile;

import br.com.sis.rh.apiprogramaformacao.api.model.cargos.Remuneracao;
import br.com.sis.rh.apiprogramaformacao.api.model.informacoesgerais.Participante;
import br.com.sis.rh.apiprogramaformacao.api.model.informacoesgerais.Programa;
import br.com.sis.rh.apiprogramaformacao.api.model.processoseletivo.Candidato;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusAtivo;
import br.com.sis.rh.apiprogramaformacao.core.util.FormatterUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Formulario para cadastro de participante")
public class CadastroParticipanteForm {
	@ApiModelProperty(value = "Cpf do participante", required = true, example = "50749052813")
	private String cpf;
	@ApiModelProperty(value = "Instituição de ensino", required = true, example = "Fatec")
	private String instituicaoEnsino;
	@ApiModelProperty(value = "Curso", required = true, example = "Engenharia da computaçõa")
	private String curso;
	@ApiModelProperty(value = "Remuneraçõa", required = true, example = "1")
	private Long idRemuneracao;
	@ApiModelProperty(value = "Candidato", required = true, example = "1")
	private Long idCandidato;
	@ApiModelProperty(value = "Programa", required = true, example = "1")
	private Long idPrograma;
	@ApiModelProperty(value = "Email", required = true, example = "Sis@sisconsultoria.com.br")
	private String email;
	private MultipartFile tce;
	@ApiModelProperty(value = "Data da entrega", required = true, example = "2022-01-10")
	private String dataEntrega;
	@ApiModelProperty(value = "Data inicio", required = true, example = "2022-02-10")
	private String dataInicio;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getInstituicaoEnsino() {
		return instituicaoEnsino;
	}

	public void setInstituicaoEnsino(String instituicaoEnsino) {
		this.instituicaoEnsino = instituicaoEnsino;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Long getIdRemuneracao() {
		return idRemuneracao;
	}

	public void setIdRemuneracao(Long idRemuneracao) {
		this.idRemuneracao = idRemuneracao;
	}

	public Long getIdCandidato() {
		return idCandidato;
	}

	public void setIdCandidato(Long idCandidato) {
		this.idCandidato = idCandidato;
	}

	public Long getIdPrograma() {
		return idPrograma;
	}

	public void setIdPrograma(Long idPrograma) {
		this.idPrograma = idPrograma;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public MultipartFile getTce() {
		return tce;
	}

	public void setTce(MultipartFile tce) {
		this.tce = tce;
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Participante converter(CadastroParticipanteForm cadastroParticipanteForm, Remuneracao remuneracao,
			Programa programa, Candidato candidato) throws IOException {

		LocalDate dataEntregaFormatada = LocalDate.parse(this.dataEntrega, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		Participante participante = new Participante();

		participante.setCpf(FormatterUtil.removerMascara(cadastroParticipanteForm.getCpf()));
		participante.setFaculdade(cadastroParticipanteForm.getInstituicaoEnsino());
		participante.setCurso(cadastroParticipanteForm.getCurso());
		participante.setRemuneracao(remuneracao);
		participante.setPrograma(programa);
		participante.setCandidato(candidato);
		participante.getPrograma().setProcessoSeletivo(participante.getCandidato().getProcessoSeletivo());
		participante.setEmail(cadastroParticipanteForm.getEmail());
		participante.setStatus(StatusAtivo.ATIVO);
		participante.setTce(cadastroParticipanteForm.getTce().getBytes());
		participante.setDataEntrega(dataEntregaFormatada);
		return participante;
	}
}
