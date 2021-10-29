package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;
import br.com.sis.rh.apiprogramaformacao.core.repository.InstrutorRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class InstrutorForm {

    @NotNull @NotEmpty
    private String cpf;

    @NotNull @NotEmpty
    private String telefone;

    @NotNull @NotEmpty
    private String status;
    
    @NotNull @NotEmpty
    private String nome;

    public InstrutorForm(String cpf, String telefone, String status, String nome) {
        this.cpf = cpf;
        this.telefone = telefone;
        this.status = status;
        this.nome = nome;
    }

    public InstrutorForm() {}

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getNome() {
		return nome;
	}
    
    public void setNome(String nome) {
		this.nome = nome;
	}

    public Instrutor converter(){
        return new Instrutor(cpf, telefone,status,nome);
    }

}
