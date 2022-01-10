package br.com.sis.rh.apiprogramaformacao.api.openApi;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.InstrutorVo;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ListaDeProcessoSeletivoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ProcessoSeletivoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ProcessoSeletivoNomeDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AtualizaProcessoSeletivoForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.ProcessoSeletivoForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Processo Seletivo Controller")
public interface ProcessoSeletivoControllerOpenApi {

	// GET

	@ApiOperation("Busca lista de todos os processos")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = ListaDeProcessoSeletivoDto.class) })
	List<ListaDeProcessoSeletivoDto> listaTodosOsProcessos();

	@ApiOperation("Retorna apenas um processo")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = ProcessoSeletivoDto.class) })
	ProcessoSeletivoDto retornaUnicoProcessoSeletivo(
			@ApiParam(value = "tipo do registro", example = "1", required = true) Long id);

	@ApiOperation("Retorna nome do processo seletivo")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = ProcessoSeletivoNomeDto.class) })
	ProcessoSeletivoNomeDto retornaNomeProcessoSeletivo(
			@ApiParam(value = "tipo do registro", example = "1", required = true) Long id);

	// POST

	@ApiOperation("Cria um novo processo seletivo")
	@ApiResponses({ @ApiResponse(code = 201, message = "CREATED", response = ResponseEntity.class) })
	ResponseEntity<ProcessoSeletivoDto> criaNovoProcessoSeletivo(ProcessoSeletivoForm form,
			UriComponentsBuilder uriBuilder);

	// PUT
	
	@ApiOperation("Atualiza o processo seletivo")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = ResponseEntity.class) })
	ResponseEntity<ProcessoSeletivoDto> atualizaProcessoEspecifico(
			AtualizaProcessoSeletivoForm form,
			@ApiParam(value = "tipo do registro", example = "1", required = true) Long id);
}
