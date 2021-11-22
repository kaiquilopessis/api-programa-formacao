package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;
import br.com.sis.rh.apiprogramaformacao.core.repository.InstrutorRepository;

import java.util.Optional;

public class AttInstrutorForm {

    private String nome;
    private String status;
    private String email;
    private String telefone;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean atualizaInstrutor (InstrutorRepository repository, String cpf){
        Optional<Instrutor> optionalInstrutor = repository.findById(cpf);

        if(optionalInstrutor.isPresent()){
            Instrutor instrutor = optionalInstrutor.get();

            instrutor.setStatus(this.status);
            instrutor.setEmail(this.email);
            instrutor.setTelefone(this.telefone);
            instrutor.setNome(this.nome);
            repository.save(instrutor);

            return true;
        }else{
            return false;
        }
    }
}
