package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.sis.rh.apiprogramaformacao.api.model.informacoesgerais.Instrutor;


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
