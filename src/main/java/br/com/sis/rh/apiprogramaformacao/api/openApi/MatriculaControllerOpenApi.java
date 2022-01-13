package br.com.sis.rh.apiprogramaformacao.api.openApi;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.LoginADDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.PerfilDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.LoginADForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Matricula Controller")
public interface MatriculaControllerOpenApi {


	@ApiOperation("Busca lista de matriculas")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = LoginADDto.class) })
	List<LoginADDto> listaMatriculas();

	@ApiOperation("Busca lista de perfis")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = PerfilDto.class) })
	List<PerfilDto> getPerfis();

	// POST

	@ApiOperation("Valida matrícula do usuário")
	@ApiResponses({ @ApiResponse(code = 201, message = "CREATED", response = ResponseEntity.class) })
	ResponseEntity<LoginADDto> autorizaMatricula(LoginADForm form, UriComponentsBuilder uriBuilder);

	// DELETE
	@ApiOperation("Deleta matrícula do usuário")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = ResponseEntity.class) })
	ResponseEntity<LoginADDto> deletarMatricula(
			@ApiParam(value = "tipo do registro", example = "jsilva", required = true) String matricula);
}
