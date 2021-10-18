package br.com.sis.rh.apiprogramaformacao.api.vo;

public class InstrutorBuscaVo {
    private String cpf;
    private String nome;
    private String status;

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

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
}
