package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.sis.rh.apiprogramaformacao.api.model.Conclusao;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.model.RemuneracaoPrograma;
import br.com.sis.rh.apiprogramaformacao.core.enums.ResultadoConclusao;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusConclusao;
import br.com.sis.rh.apiprogramaformacao.core.repository.RemuneracaoProgramaRepository;

public class ConclusaoProgressivaForm {

	private ResultadoConclusao resultado;
	private String dataAlteracao;
	private String cargo;
	private String comprovante;

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

	public String getComprovante() {
		return comprovante;
	}

	public void setComprovante(String comprovante) {
		this.comprovante = comprovante;
	}

	public Conclusao converter(Participante participante, RemuneracaoProgramaRepository remuneracaoProgramaRepository) {
		LocalDate data = LocalDate.parse(this.dataAlteracao, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		RemuneracaoPrograma cargo = remuneracaoProgramaRepository.findByCargo(this.cargo);
		return new Conclusao(participante, data, cargo, comprovante, resultado, StatusConclusao.PROGRESSIVA);
	}
}
