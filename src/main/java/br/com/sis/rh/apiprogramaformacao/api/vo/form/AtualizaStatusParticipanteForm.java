package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import br.com.sis.rh.apiprogramaformacao.core.enums.StatusAtivo;

public class AtualizaStatusParticipanteForm {

	private StatusAtivo statusAtivo;
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
