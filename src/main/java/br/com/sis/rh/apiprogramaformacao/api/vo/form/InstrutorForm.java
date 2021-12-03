package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;

public class InstrutorForm {

    @NotNull @NotEmpty
    private String cpf;

    @NotNull @NotEmpty
    private String telefone;

    @NotNull @NotEmpty
    private String status;
    
    @NotNull @NotEmpty
    private String nome;
    
    @NotNull @NotEmpty
    private String email;

    public InstrutorForm(String cpf, String telefone, String status, String nome, String email) {
        this.cpf = cpf;
        this.telefone = telefone;
        this.status = status;
        this.nome = nome;
        this.email = email;
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
    
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

    public Instrutor converter(){
        cpf = cpf.replace(".", "").replace("-", "");
        return new Instrutor(cpf, telefone,status,nome,email);
    }

}
