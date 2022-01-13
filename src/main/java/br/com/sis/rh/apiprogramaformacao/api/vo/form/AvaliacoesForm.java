package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import java.math.BigDecimal;

import br.com.sis.rh.apiprogramaformacao.api.model.AvaliacaoDesempenho;
import br.com.sis.rh.apiprogramaformacao.api.model.Avaliacoes;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Formulário para cadastrar a avaliação do participante")
public class AvaliacoesForm {

	@ApiModelProperty(value = "Nota técnica", required = true, example = "10")
	private BigDecimal notaTecnica;

	@ApiModelProperty(value = "Avaliacao de desempenho", required = true)
	private AvaliacaoDesempenhoForm avaliacaoDesempenhoForm;

	@ApiModelProperty(value = "Nota práticas ágeis", required = true, example = "10")
	private BigDecimal notaPraticasAgeis;

	@ApiModelProperty(value = "Nota liderança", required = true, example = "10")
	private BigDecimal notaLideranca;

	@ApiModelProperty(value = "Nota negócios", required = true, example = "10")
	private BigDecimal notaNegocios;

	public BigDecimal getNotaTecnica() {
		return notaTecnica;
	}

	public void setNotaTecnica(BigDecimal notaTecnica) {
		this.notaTecnica = notaTecnica;
	}

	public AvaliacaoDesempenhoForm getAvaliacaoDesempenhoForm() {
		return avaliacaoDesempenhoForm;
	}

	public void setAvaliacaoDesempenhoForm(AvaliacaoDesempenhoForm avaliacaoDesempenhoForm) {
		this.avaliacaoDesempenhoForm = avaliacaoDesempenhoForm;
	}

	public BigDecimal getNotaPraticasAgeis() {
		return notaPraticasAgeis;
	}

	public void setNotaPraticasAgeis(BigDecimal notaPraticasAgeis) {
		this.notaPraticasAgeis = notaPraticasAgeis;
	}

	public BigDecimal getNotaLideranca() {
		return notaLideranca;
	}

	public void setNotaLideranca(BigDecimal notaLideranca) {
		this.notaLideranca = notaLideranca;
	}

	public BigDecimal getNotaNegocios() {
		return notaNegocios;
	}

	public void setNotaNegocios(BigDecimal notaNegocios) {
		this.notaNegocios = notaNegocios;
	}

	public Avaliacoes converter(Participante participante) {
		AvaliacaoDesempenho avaliacaoDesempenho = avaliacaoDesempenhoForm.converter();
		return new Avaliacoes(participante, notaTecnica, notaPraticasAgeis, notaLideranca, notaNegocios,
				avaliacaoDesempenho);
	}
}
