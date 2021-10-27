package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.sis.rh.apiprogramaformacao.api.model.FeedBack;

public class FeedBackDto {
	
	private Long id;
	private LocalDate data;
	private String anotacao;
	
	public FeedBackDto(FeedBack feedBack) {
		this.id = feedBack.getId();
		this.data = feedBack.getData();
		this.anotacao = feedBack.getAnotacoes();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public String getAnotacao() {
		return anotacao;
	}
	public void setAnotacao(String anotacao) {
		this.anotacao = anotacao;
	}
	
	public static List<FeedBackDto> converter(List<FeedBack> feedBacks){
		return feedBacks.stream().map(FeedBackDto::new).collect(Collectors.toList());
	}

}
