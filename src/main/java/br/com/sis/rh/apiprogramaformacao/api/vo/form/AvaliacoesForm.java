package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import br.com.sis.rh.apiprogramaformacao.api.model.AvaliacaoDesempenho;
import br.com.sis.rh.apiprogramaformacao.api.model.Avaliacoes;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;

public class AvaliacoesForm {

	private Double notaTecnica;

	private AvaliacaoDesempenhoForm avaliacaoDesempenhoForm;

	private Double notaPraticasAgeis;

	private Double notaLideranca;

	private Double notaNegocios;

	public Double getNotaTecnica() {
		return notaTecnica;
	}

	public void setNotaTecnica(Double notaTecnica) {
		this.notaTecnica = notaTecnica;
	}

	public AvaliacaoDesempenhoForm getAvaliacaoDesempenhoForm() {
		return avaliacaoDesempenhoForm;
	}

	public void setAvaliacaoDesempenhoForm(AvaliacaoDesempenhoForm avaliacaoDesempenhoForm) {
		this.avaliacaoDesempenhoForm = avaliacaoDesempenhoForm;
	}

	public Double getNotaPraticasAgeis() {
		return notaPraticasAgeis;
	}

	public void setNotaPraticasAgeis(Double notaPraticasAgeis) {
		this.notaPraticasAgeis = notaPraticasAgeis;
	}

	public Double getNotaLideranca() {
		return notaLideranca;
	}

	public void setNotaLideranca(Double notaLideranca) {
		this.notaLideranca = notaLideranca;
	}

	public Double getNotaNegocios() {
		return notaNegocios;
	}

	public void setNotaNegocios(Double notaNegocios) {
		this.notaNegocios = notaNegocios;
	}

	public Avaliacoes converter(Participante participante) {
		AvaliacaoDesempenho avaliacaoDesempenho = avaliacaoDesempenhoForm.converter();
		return new Avaliacoes(participante, notaTecnica, notaNegocios, notaPraticasAgeis, notaLideranca,
				avaliacaoDesempenho);
	}
}
