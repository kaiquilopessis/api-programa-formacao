package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.web.multipart.MultipartFile;

import br.com.sis.rh.apiprogramaformacao.api.model.FeedBack;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;

public class FeedBackForm {

	private String data;
	private String anotacoes;
	private MultipartFile disc;

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

	public MultipartFile getDisc() {
		return disc;
	}

	public void setDisc(MultipartFile disc) {
		this.disc = disc;
	}

	public FeedBack converter(Participante participante) throws IOException {
		LocalDate data = LocalDate.parse(this.data, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		if(disc == null){
			return new FeedBack(data, anotacoes, participante);
		}
		return new FeedBack(data, anotacoes, participante, disc.getBytes());
	}
	
}
