package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;
import java.util.stream.Collectors;


public class CpfInstrutorNomeDto {

    private String cpfInstrutor;
    private String nomeInstrutor;


    public CpfInstrutorNomeDto(Instrutor instrutor){
        this.cpfInstrutor = instrutor.getCpfInstrutor();
        this.nomeInstrutor = instrutor.getNome();
    }
    
    

    public CpfInstrutorNomeDto(String cpfInstrutor, String nomeInstrutor) {
		this.cpfInstrutor = cpfInstrutor;
		this.nomeInstrutor = nomeInstrutor;
	}



	public static List<CpfInstrutorNomeDto> converter(List<Instrutor> listaInstrutores){
        return listaInstrutores.stream().map(CpfInstrutorNomeDto::new).collect(Collectors.toList());
    }

	public String getCpfInstrutor() {
		return cpfInstrutor;
	}

	public void setCpfInstrutor(String cpfInstrutor) {
		this.cpfInstrutor = cpfInstrutor;
	}

	public String getNomeInstrutor() {
		return nomeInstrutor;
	}

	public void setNomeInstrutor(String nomeInstrutor) {
		this.nomeInstrutor = nomeInstrutor;
	}
    
}
