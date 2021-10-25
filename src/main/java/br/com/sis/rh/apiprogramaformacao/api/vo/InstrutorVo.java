package br.com.sis.rh.apiprogramaformacao.api.vo;

import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;

import java.util.ArrayList;
import java.util.List;

public class InstrutorVo {
    private String cpf;
    private int status;
    private String telefone;
    private String nome =  "Leticia";
    private String email =  "leticiaangulo.sisconsultoria@.com.br";

    public InstrutorVo(Instrutor instrutor) {
        this.cpf = instrutor.getCpfInstrutor();
        this.status = instrutor.getStatus();
        this.telefone = instrutor.getTelefone();
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
