package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.sis.rh.apiprogramaformacao.api.model.informacoesgerais.Instrutor;

public class InstrutorVo {
    private String cpf;
    private String status;
    private String telefone;
    private String nome;
    private String email;

    public InstrutorVo(Instrutor instrutor) {
        this.cpf = instrutor.getCpfInstrutor();
        this.status = instrutor.getStatus();
        this.telefone = instrutor.getTelefone();
        this.nome = instrutor.getNome();
        this.email = instrutor.getEmail();
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public static InstrutorVo converterParaVo(Instrutor instrutor){
        return new InstrutorVo(instrutor);
    }

    public static List<InstrutorVo> converterListaParaVo(List<Instrutor> instrutores){
        return instrutores.stream().map(InstrutorVo::new).collect(Collectors.toList());
    }

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
