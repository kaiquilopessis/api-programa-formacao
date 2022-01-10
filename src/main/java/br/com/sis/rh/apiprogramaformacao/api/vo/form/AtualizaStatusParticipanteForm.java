package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import br.com.sis.rh.apiprogramaformacao.core.enums.StatusAtivo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Formulario para atualizar o status do participante")
public class AtualizaStatusParticipanteForm {

	@ApiModelProperty(value = "Status", required = true, example = "ATIVO")
	private StatusAtivo statusAtivo;
	@ApiModelProperty(value = "Cpf do participante", required = true, example = "50749052813")
	private String cpf;

	public AtualizaStatusParticipanteForm(StatusAtivo statusAtivo, String cpf) {
		this.statusAtivo = statusAtivo;
		this.cpf = cpf;
	}

	public StatusAtivo getStatusAtivo() {
		return statusAtivo;
	}

	public void setStatusAtivo(StatusAtivo statusAtivo) {
		this.statusAtivo = statusAtivo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
