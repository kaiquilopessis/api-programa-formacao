package br.com.sis.rh.apiprogramaformacao.api.vo;

import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;

import java.util.ArrayList;
import java.util.List;

public class InstrutorVo {
    private String cpf;
    private String status;
    private String telefone;
    private String nome;

    public InstrutorVo(Instrutor instrutor) {
        this.cpf = instrutor.getCpfInstrutor();
        this.status = instrutor.getStatus();
        this.telefone = instrutor.getTelefone();
        this.nome = "Instrutor Teste";
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
        List<InstrutorVo> instrutoresVos = new ArrayList<>();

        instrutores.forEach(instrutor -> {
            instrutoresVos.add(new InstrutorVo(instrutor));
        });

        return instrutoresVos;
    }
}