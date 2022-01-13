package br.com.sis.rh.apiprogramaformacao.api.openApi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@Api(tags = "Autenticação Controller")
public interface AutenticacaoControllerOpenApi {

	@ApiOperation("Verifica o token do usuario logado na aplicação")
	@ApiResponses({@ApiResponse(code = 200, message = "OK", response = String.class)})
	String verificaToken(@ApiParam(value = "token gerado na autenticação", required = true) String token);
}
