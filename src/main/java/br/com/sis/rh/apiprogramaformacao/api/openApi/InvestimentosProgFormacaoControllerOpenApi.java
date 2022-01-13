package br.com.sis.rh.apiprogramaformacao.api.openApi;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.DocumentException;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.InvestimentoProgFormacaoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Investimentos Prog. Formação Controller")
public interface InvestimentosProgFormacaoControllerOpenApi {


	@ApiOperation("Busca investimentos do Programa")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = InvestimentoProgFormacaoVo.class) })
	InvestimentoProgFormacaoVo investimentosPrograma(
			@ApiParam(value = "tipo do registro", example = "Java", required = true) String nomePrograma,
			@ApiParam(value = "tipo do registro", example = "Turma 1", required = true) String nomeTurma);

	@ApiOperation("Busca investimentos por periodo")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = InvestimentoProgFormacaoVo.class) })
	InvestimentoProgFormacaoVo investDoPeriodoPrograma(
			@ApiParam(value = "tipo do registro", example = "Java", required = true) String nomePrograma,
			@ApiParam(value = "tipo do registro", example = "Turma 2", required = true) String nomeTurma,
			@ApiParam(value = "tipo do registro", example = "2022-01-03", required = true) String dataInicio,
			@ApiParam(value = "tipo do registro", example = "2022-06-02", required = true) String dataFim)
			throws ParseException;

	@ApiOperation("Efetua download dos investimentos em pdf")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK") })
	public void downloadPDF(HttpServletResponse response,
			@ApiParam(value = "tipo do registro", example = "Java", required = true) String nomePrograma,
			@ApiParam(value = "tipo do registro", example = "Turma 2", required = true) String nomeTurma,
			@ApiParam(value = "tipo do registro", example = "2022-01-03", required = true) String dataInicio,
			@ApiParam(value = "tipo do registro", example = "2022-06-02", required = true) String dataFim)
			throws DocumentException, IOException, ParseException;

	@ApiOperation("Efetua download dos investimentos em xlsx")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK") })
	public void downloadXLSX(HttpServletResponse response,
			@ApiParam(value = "tipo do registro", example = "Java", required = true) String nomePrograma,
			@ApiParam(value = "tipo do registro", example = "Turma 2", required = true) String nomeTurma,
			@ApiParam(value = "tipo do registro", example = "2022-01-03", required = true) String dataInicio,
			@ApiParam(value = "tipo do registro", example = "2022-06-02", required = true) String dataFim)
			throws IOException, ParseException;
}
