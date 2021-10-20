package br.com.sis.rh.apiprogramaformacao.api.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.sis.rh.apiprogramaformacao.api.model.FeedBack;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;

public class FeedBackForm {
	
	private String data;
	private String anotacoes;
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getAnotacoes() {
		return anotacoes;
	}
	public void setAnotacoes(String anotacoes) {
		this.anotacoes = anotacoes;
	}
	
	public FeedBack converter (Participante participante) {
		LocalDate data = LocalDate.parse(this.data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return new FeedBack(data, anotacoes, participante);
	}

}
