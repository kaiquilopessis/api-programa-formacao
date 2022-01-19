package br.com.sis.rh.apiprogramaformacao.api.openApi;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.AluraDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Alura Controller")
public interface AluraControllerOpenApi {

	@ApiOperation("Busca a lista de registros da Alura correspondentes ao CPF passado por parâmetro")
	@ApiResponses({@ApiResponse(code = 200, message = "OK", response = AluraDto.class)})
	ResponseEntity<List<AluraDto>> listaRegistros(@ApiParam(value = "CPF do participante", example = "45976389899", required = true) String cpf);
}
