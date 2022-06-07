package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.sis.rh.apiprogramaformacao.api.model.cargos.RemuneracaoInstrutor;
import br.com.sis.rh.apiprogramaformacao.api.model.informacoesgerais.Instrutor;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@ApiModel("Formulário de Investimento do instrutor")
public class InvestimentoInstrutorForm {

	@ApiModelProperty(value = "cpf do instrutor", required = true, example = "89620531019")
	private String cpf;
	
	@ApiModelProperty(value = "mes/ano do investimento", required = true, example = "2022-02-02")
	private String mesAno;
	@ApiModelProperty(value = "valor investido por hora", required = true, example = "1.500")
	private String valorHora;
	@ApiModelProperty(value = "quantidade de horas trabalhadas", required = true, example = "8")
	private String horasTrabalhadas;

	public static RemuneracaoInstrutor converter(InvestimentoInstrutorForm investimentoInstrutorForm,
			Instrutor instrutor) {
		DateTimeFormatter nome = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		BigDecimal valorHoraFormatado = new BigDecimal(investimentoInstrutorForm.getValorHora());
		Integer horasTrabalhadasFormatada = Integer.parseInt(investimentoInstrutorForm.getHorasTrabalhadas());
		LocalDate dataFormatada = LocalDate.parse(investimentoInstrutorForm.getMesAno(), nome);
		return new RemuneracaoInstrutor(dataFormatada, valorHoraFormatado, horasTrabalhadasFormatada, instrutor);
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

	public String getValorHora() {
		return valorHora;
	}

	public void setValorHora(String valorHora) {
		this.valorHora = valorHora;
	}

	public String getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(String horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

}
