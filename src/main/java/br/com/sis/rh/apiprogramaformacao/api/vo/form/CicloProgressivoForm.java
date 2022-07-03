package br.com.sis.rh.apiprogramaformacao.api.vo.form;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.multipart.MultipartFile;

import br.com.sis.rh.apiprogramaformacao.api.model.acompanhamento.Ciclo;
import br.com.sis.rh.apiprogramaformacao.api.model.cargos.Remuneracao;
import br.com.sis.rh.apiprogramaformacao.api.model.informacoesgerais.Participante;
import br.com.sis.rh.apiprogramaformacao.core.enums.ResultadoCiclo;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusCiclo;
import br.com.sis.rh.apiprogramaformacao.core.repository.cargos.RemuneracaoRepository;

@ApiModel("Formuário para criar um Ciclo Progressivo")
public class CicloProgressivoForm {

	@ApiModelProperty(value = "Resultado do ciclo", required = true, example = "REAJUSTE_SALARIO")
	private ResultadoCiclo resultado;
	@ApiModelProperty(value = "Data de alteração", required = true, example = "2022-02-02")
	private String dataAlteracao;
	@ApiModelProperty(value = "Cargo do participante", required = true, example = "Estagiario")
	private String cargo;
	@ApiModelProperty(value = "Comprovante", required = true, dataType = "MultipartFile")
	private MultipartFile comprovante;

	public ResultadoCiclo getResultado() {
		return resultado;
	}

	public void setResultado(ResultadoCiclo resultado) {
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

	public MultipartFile getComprovante() {
		return comprovante;
	}

	public void setComprovante(MultipartFile comprovante) {
		this.comprovante = comprovante;
	}

	public Ciclo converter(Participante participante, RemuneracaoRepository remuneracaoProgramaRepository)
			throws IOException {
		LocalDate data = LocalDate.parse(this.dataAlteracao, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		Remuneracao cargo = remuneracaoProgramaRepository.findByCargo(this.cargo);
		return new Ciclo(participante, data, cargo, comprovante.getBytes(), resultado, StatusCiclo.PROGRESSIVA);
	}
}