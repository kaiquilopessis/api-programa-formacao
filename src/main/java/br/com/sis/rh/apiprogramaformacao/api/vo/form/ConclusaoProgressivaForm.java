package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.sis.rh.apiprogramaformacao.api.model.Conclusao;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.model.Remuneracao;
import br.com.sis.rh.apiprogramaformacao.core.enums.ResultadoConclusao;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusConclusao;
import br.com.sis.rh.apiprogramaformacao.core.repository.RemuneracaoRepository;

public class ConclusaoProgressivaForm {

	private ResultadoConclusao resultado;
	private String dataAlteracao;
	private String cargo;
	private byte[] comprovante;

	public ResultadoConclusao getResultado() {
		return resultado;
	}

	public void setResultado(ResultadoConclusao resultado) {
		this.resultado = resultado;
	}

	public String getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(String dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public byte[] getComprovante() {
		return comprovante;
	}

	public void setComprovante(byte[] comprovante) {
		this.comprovante = comprovante;
	}

	public Conclusao converter(Participante participante, RemuneracaoRepository remuneracaoRepository) {
		LocalDate data = LocalDate.parse(this.dataAlteracao, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Remuneracao cargo = remuneracaoRepository.findByCargo(this.cargo);
		return new Conclusao(participante, data, cargo, comprovante, resultado, StatusConclusao.PROGRESSIVA);
	}
}
