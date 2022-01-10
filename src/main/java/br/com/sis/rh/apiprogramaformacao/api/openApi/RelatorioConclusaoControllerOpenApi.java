package br.com.sis.rh.apiprogramaformacao.api.openApi;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.RelatorioConclusaoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Relatório Conclusão Controller")
public interface RelatorioConclusaoControllerOpenApi {
	
	@ApiOperation("Retornando a url  com turma, formação e escopo para popular os cards")
	@ApiResponses({@ApiResponse(code = 200, message = "OK", response = RelatorioConclusaoVO.class)})
	RelatorioConclusaoVO listaParticipantesAtivo(@ApiParam(value = "Formação desejada",
            example = "Java", required = true) String formacao, @ApiParam(value = "Turma desejada",
            example = "Turma I", required = true) String turma,@ApiParam(value = "Escopo do relatório",
            example = "Alura", required = true) String escopo);
}
