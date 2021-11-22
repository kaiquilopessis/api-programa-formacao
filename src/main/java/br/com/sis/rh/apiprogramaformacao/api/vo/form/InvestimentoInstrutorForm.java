package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;
import br.com.sis.rh.apiprogramaformacao.api.model.Remuneracao_Instrutor;
import lombok.NoArgsConstructor;

@NoArgsConstructor

public class InvestimentoInstrutorForm {

	private String cpf;
	private String mesAno;
	private String valorHora;
	private String horasTrabalhadas;

	public static Remuneracao_Instrutor converter(InvestimentoInstrutorForm investimentoInstrutorForm,
			Instrutor instrutor) {
		DateTimeFormatter nome = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		BigDecimal valorHoraFormatado = new BigDecimal(investimentoInstrutorForm.getValorHora());
		Integer horasTrabalhadasFormatada = Integer.parseInt(investimentoInstrutorForm.getHorasTrabalhadas());
		LocalDate dataFormatada = LocalDate.parse(investimentoInstrutorForm.getMesAno(), nome);
		return new Remuneracao_Instrutor(instrutor, dataFormatada, valorHoraFormatado, horasTrabalhadasFormatada);
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
