package br.com.sis.rh.apiprogramaformacao.api.vo;

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

    @NotNull
    private int status;

    public InstrutorForm(String cpf, String telefone, int status) {
        this.cpf = cpf;
        this.telefone = telefone;
        this.status = status;
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

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public Instrutor converter(){
        return new Instrutor(cpf, telefone,status);
    }

}
