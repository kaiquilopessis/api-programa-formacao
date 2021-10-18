package br.com.sis.rh.apiprogramaformacao.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_INSTRUTOR")
public class Instrutor {
    @Id
    @Column(name = "cpf_instrutor")
    private String cpf;

    @Column(name = "telefone")
    private String contato;

    // 0 = Inativo | 1 = Ativo
    private int status;

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getContato() {
        return contato;
    }
    public void setContato(String contato) {
        this.contato = contato;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
}
