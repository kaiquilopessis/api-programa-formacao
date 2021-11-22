package br.com.sis.rh.apiprogramaformacao.api.vo.form;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.sis.rh.apiprogramaformacao.api.model.Investimentos;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class FolhaForm {
    private String cpf;
    private String mesAno;
    private String remuneracao;
    private String encargos;
    private String beneficios;
    private String descricao;

    public static Investimentos converter(FolhaForm folhaForm, Participante participante){
        DateTimeFormatter nome = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        BigDecimal remuneracaoFormatada = new BigDecimal(folhaForm.getRemuneracao());
        BigDecimal encargoFormatado = new BigDecimal(folhaForm.getEncargos());
        BigDecimal beneficiosFormatado = new BigDecimal(folhaForm.getBeneficios());
        LocalDate dataFormatada = LocalDate.parse(folhaForm.getMesAno(), nome);
        return new Investimentos(participante, dataFormatada, remuneracaoFormatada, encargoFormatado, beneficiosFormatado, folhaForm.getDescricao());
    }

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getMesAno() {
		return mesAno;
	}

	public void setMesAno(String mesAno) {
		this.mesAno = mesAno;
	}

	public String getRemuneracao() {
		return remuneracao;
	}

	public void setRemuneracao(String remuneracao) {
		this.remuneracao = remuneracao;
	}

	public String getEncargos() {
		return encargos;
	}

	public void setEncargos(String encargos) {
		this.encargos = encargos;
	}

	public String getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
    

}
