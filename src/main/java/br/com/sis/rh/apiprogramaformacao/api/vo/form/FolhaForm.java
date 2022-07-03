package br.com.sis.rh.apiprogramaformacao.api.vo.form;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.sis.rh.apiprogramaformacao.api.model.informacoesgerais.Participante;
import br.com.sis.rh.apiprogramaformacao.api.model.investimentos.Investimentos;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@ApiModel("Formulário para incluir um investimento")
public class FolhaForm {
	@ApiModelProperty(value = "Cpf do participante", required = true, example = "33092410840")
    private String cpf;
	@ApiModelProperty(value = "Data de inclusão", required = true, example = "2022-02-21")
    private String mesAno;
	@ApiModelProperty(value = "Remuneração", required = true, example = "1500")
    private String remuneracao;
	@ApiModelProperty(value = "Encargos", required = true, example = "500")
    private String encargos;
	@ApiModelProperty(value = "Beneficios", required = true, example = "450")
    private String beneficios;
	@ApiModelProperty(value = "Descrição", required = true, example = "Descrição descrição")
    private String descricao;

    public static Investimentos converter(FolhaForm folhaForm, Participante participante){
        BigDecimal remuneracaoFormatada = new BigDecimal(folhaForm.getRemuneracao());
        BigDecimal encargoFormatado = new BigDecimal(folhaForm.getEncargos());
        BigDecimal beneficiosFormatado = new BigDecimal(folhaForm.getBeneficios());
        LocalDate dataFormatada = LocalDate.parse(folhaForm.getMesAno(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
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
