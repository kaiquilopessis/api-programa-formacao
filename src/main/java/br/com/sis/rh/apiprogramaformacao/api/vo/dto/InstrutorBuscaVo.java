package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InstrutorBuscaVo {
    private String cpf;
    private String nome;
    private String instrutor;
    private String status;

    public InstrutorBuscaVo(Instrutor instrutor){
        this.cpf = instrutor.getCpfInstrutor();
        this.instrutor = instrutor.getCpfInstrutor();
        this.status = instrutor.getStatus();
        this.nome = instrutor.getNome();
    }


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

    public String getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(String instrutor) {
        this.instrutor = instrutor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static InstrutorBuscaVo converter(Instrutor instrutor){
        return new InstrutorBuscaVo(instrutor);
    }

    public static List<InstrutorBuscaVo> converterLista(List<Instrutor> instrutores){
        return instrutores.stream().map(InstrutorBuscaVo::new).collect(Collectors.toList());
    }
}
