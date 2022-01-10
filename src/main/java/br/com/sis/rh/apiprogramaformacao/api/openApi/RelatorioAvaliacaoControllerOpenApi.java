package br.com.sis.rh.apiprogramaformacao.api.openApi;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.RelatorioAvaliacoesVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Relatório Avaliação Controller")
public interface RelatorioAvaliacaoControllerOpenApi {
	
	@ApiOperation("Retorna informações referentes a escolha nos campos")
	@ApiResponses({@ApiResponse(code = 200, message = "OK", response = RelatorioAvaliacoesVo.class)})
	RelatorioAvaliacoesVo informacoesGeraisDasAvaliacoes(@ApiParam(value = "Formação desejada",
            example = "Java", required = true) String formacao, @ApiParam(value = "Turma desejada",
            example = "Turma I", required = true) String turma,@ApiParam(value = "Escopo do relatório",
            example = "Alura", required = true) String escopo);
}
