package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import javax.persistence.Column;


public class ParticipanteProgramaDto {

    @Column(name = "nomeParticipante")
    private String nomeParticipante;
   
    @Column(name = "nomePrograma")
    private String nomePrograma;
    
	public String getNomeParticipante() {
		return nomeParticipante;
	}
	public void setNomeParticipante(String nomeParticipante) {
		this.nomeParticipante = nomeParticipante;
	}
	public String getNomePrograma() {
		return nomePrograma;
	}
	public void setNomePrograma(String nomePrograma) {
		this.nomePrograma = nomePrograma;
	}
	public ParticipanteProgramaDto(String nomeParticipante, String nomePrograma) {
		this.nomeParticipante = nomeParticipante;
		this.nomePrograma = nomePrograma;
	}
	public ParticipanteProgramaDto() {
		
	}
	
	
}
