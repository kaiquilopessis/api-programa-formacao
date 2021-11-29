package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

public class NomeInstrutorDto {
    private String nome;
    private String cpfInstrutor;

    public NomeInstrutorDto(String nome, String cpfInstrutor){
        this.nome = nome;
        this.cpfInstrutor = cpfInstrutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfInstrutor() {
        return cpfInstrutor;
    }

    public void setCpfInstrutor(String cpfInstrutor) {
        this.cpfInstrutor = cpfInstrutor;
    }
}
