package br.com.sis.rh.apiprogramaformacao.api.openApi;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.RelatorioAluraVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@Api(tags = "Relatório Alura Controller")
public interface RelatorioAluraControllerOpenApi {

	// GET

	@ApiOperation("Popula os cards")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = RelatorioAluraVo.class) })
	RelatorioAluraVo popularCards(
			@ApiParam(value = "tipo do registro", example = "Java", required = true) String formacao,
			@ApiParam(value = "tipo do registro", example = "Turma 1", required = true) String turma,
			@ApiParam(value = "tipo do registro", example = "Alura", required = true) String escopo);

	@ApiOperation("Realiza download em xlsx")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK") })
	void downloadXLSX(HttpServletResponse response,
			@ApiParam(value = "tipo do registro", example = "Java", required = true) String formacao,
			@ApiParam(value = "tipo do registro", example = "Turma 1", required = true) String turma)
			throws IOException;

	@ApiOperation("Realiza download em pdf")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK") })
	void downloadPDF(HttpServletResponse response,
			@ApiParam(value = "tipo do registro", example = "Java", required = true) String formacao,
			@ApiParam(value = "tipo do registro", example = "Turma 1", required = true) String turma)
			throws DocumentException, IOException;
}
