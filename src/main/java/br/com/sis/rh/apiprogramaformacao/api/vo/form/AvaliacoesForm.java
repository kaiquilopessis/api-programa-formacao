package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import br.com.sis.rh.apiprogramaformacao.api.model.AvaliacaoDesempenho;
import br.com.sis.rh.apiprogramaformacao.api.model.Avaliacoes;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;

public class AvaliacoesForm {
	
	private Float notaTecnica;

	private AvaliacaoDesempenhoForm avaliacaoDesempenhoForm;

	private Float notaPraticasAgeis;

	private Float notaLideranca;

	private Float notaNegocios;

	public Float getNotaTecnica() {
		return notaTecnica;
	}

	public void setNotaTecnica(Float notaTecnica) {
		this.notaTecnica = notaTecnica;
	}

	public void setAvaliacaoDesempenhoForm(AvaliacaoDesempenhoForm avaliacaoDesempenhoForm) {
		this.avaliacaoDesempenhoForm = avaliacaoDesempenhoForm;
	}

	public Float getNotaPraticasAgeis() {
		return notaPraticasAgeis;
	}

	public void setNotaPraticasAgeis(Float notaPraticasAgeis) {
		this.notaPraticasAgeis = notaPraticasAgeis;
	}

	public Float getNotaLideranca() {
		return notaLideranca;
	}

	public void setNotaLideranca(Float notaLideranca) {
		this.notaLideranca = notaLideranca;
	}

	public Float getNotaNegocios() {
		return notaNegocios;
	}

	public void setNotaNegocios(Float notaNegocios) {
		this.notaNegocios = notaNegocios;
	}
	
	
	
	
	public Avaliacoes converter(Participante participante) {
		return new Avaliacoes(participante, notaTecnica, notaNegocios, notaPraticasAgeis, notaLideranca,
				avaliacaoDesempenho);
	}
}
