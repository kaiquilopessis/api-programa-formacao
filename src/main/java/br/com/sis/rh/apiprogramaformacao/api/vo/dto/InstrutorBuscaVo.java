package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;

public class InstrutorBuscaVo {
    private String cpf;
    private String nome;
    private String instrutor;
    private String status;

    public InstrutorBuscaVo(Instrutor instrutor){
        this.cpf = instrutor.getCpf();
        this.instrutor = instrutor.getCpf();
        this.status = instrutor.getStatus();
    }

    public String getId() {
        return cpf;
    }

    public String getInstrutor() {
        return instrutor;
    }

    public String getStatus() {
        return status;
    }

    public static InstrutorBuscaVo converter(Instrutor instrutor){
        return new InstrutorBuscaVo(instrutor);
    }

    public static List<InstrutorBuscaVo> converterLista(List<Instrutor> instrutores){
        List<InstrutorBuscaVo> instrutoresVo = new ArrayList<>();

        instrutores.forEach(instrutor -> {
            instrutoresVo.add(new InstrutorBuscaVo(instrutor));
        });

        return instrutoresVo;
    }
}
