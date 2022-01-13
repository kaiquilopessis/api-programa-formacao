package br.com.sis.rh.apiprogramaformacao.api.openApi;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.AvaliacaoDesempenhoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.AvaliacoesDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AvaliacoesForm;
import br.com.sis.rh.apiprogramaformacao.core.ad.UsuarioAD;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Avaliações Controller")
public interface AvaliacoesControllerOpenApi {

	@ApiOperation("Busca as notas do participante informado")
	@ApiResponses({@ApiResponse(code = 200, message = "OK", response = AvaliacoesDto.class)})
	List<AvaliacoesDto> listarNotas(
			@ApiParam(value = "CPF do participante", example = "45976389899", required = true) String cpf);

	@ApiOperation("Lista as avaliações de desempenho referente a Avaliação informada")
	@ApiResponses({@ApiResponse(code = 200, message = "OK", response = AvaliacoesDto.class)})
	ResponseEntity<AvaliacaoDesempenhoDto> listarAvaliacaoDesempenho(
			@ApiParam(value = "Id da avaliação", example = "4", required = true) Long id);

	@ApiOperation("Cadastra a avaliação e avaliação de desempenho")
	@ApiResponses({@ApiResponse(code = 201, message = "OK", response = AvaliacoesDto.class)})
	ResponseEntity<AvaliacoesDto> cadastrar(
			@ApiParam(value = "CPF do participante", example = "45976389899", required = true) String cpf,
			AvaliacoesForm avaliacoesForm, UriComponentsBuilder uriComponentsBuilder);

	@ApiOperation("Deleta a avaliação e avaliação de desempenho")
	@ApiResponses({@ApiResponse(code = 200, message = "OK", response = AvaliacoesDto.class)})
	ResponseEntity<AvaliacoesDto> deletar(@ApiParam(value = "ID da avaliação", example = "3", required = true) Long id);

}
