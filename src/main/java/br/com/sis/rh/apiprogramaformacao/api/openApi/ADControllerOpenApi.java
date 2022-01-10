package br.com.sis.rh.apiprogramaformacao.api.openApi;

import javax.naming.NamingException;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.input.LoginInput;
import br.com.sis.rh.apiprogramaformacao.core.ad.UsuarioAD;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "AD Controller")
public interface ADControllerOpenApi {
	
	@ApiOperation("Busca o usuário no Active Directory")
	@ApiResponses({@ApiResponse(code = 200, message = "OK", response = UsuarioAD.class)})
	UsuarioAD buscar(LoginInput loginInput) throws NamingException;
}
