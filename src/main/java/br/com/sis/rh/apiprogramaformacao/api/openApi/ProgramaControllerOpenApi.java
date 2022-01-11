package br.com.sis.rh.apiprogramaformacao.api.openApi;

import java.util.List;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.sis.rh.apiprogramaformacao.api.vo.form.ProgramaAtualizaForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.ProgramaCadastroForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "ProgramaController")
public interface ProgramaControllerOpenApi {

	// GET

	@ApiOperation("Busca lista de programas")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = ProgramaBuscaVo.class) })
	List<ProgramaBuscaVo> getPadrao();

	@ApiOperation("Busca nome de turmas")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = NomeTurmaCandidatoDto.class) })
	NomeTurmaCandidatoDto mostrarTurma(@ApiParam(value = "tipo do registro", example = "1", required = true) Long id);

	@ApiOperation("Busca lista de processos")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = ProcessoSeletivoVo.class) })
	List<ProcessoSeletivoVo> getProcesso();

	@ApiOperation("Busca programa pelo Id")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = ProgramaCompletoVo.class) })
	ResponseEntity<ProgramaCompletoVo> getProgramaById(
			@ApiParam(value = "tipo do registro", example = "1", required = true) long id);

	@ApiOperation("Busca programas em andamento")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = ProcessoSeletivoVo.class) })
	List<ProcessoSeletivoVo> programasEmAndamento();

	@ApiOperation("Busca turmas pelo processo seletivo")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = TurmaDto.class) })
	List<TurmaDto> buscarTurmasPeloProcesso(@ApiParam(value = "Id do processo", example = "1", required = true) Long id);

	@ApiOperation("Busca programas pelo nome")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = TurmaDto.class) })
	List<TurmaDto> buscarProgramaPeloNome(@ApiParam(value = "Nome do programa", example = "Turma II", required = true) String nome);
	
	// PUT
	
	@ApiOperation("Atualiza o programa")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK") })
	void atualizarPrograma(@RequestBody ProgramaAtualizaForm programaAtualizaForm);

	@ApiOperation("Altera o status do programa")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK") })
	ResponseEntity alteraStatus(@ApiParam(value = "Id do programa", example = "1", required = true) Long id);
	
	// POST

	@ApiOperation("Cadastra um novo programa")
	@ApiResponses({ @ApiResponse(code = 201, message = "CREATED", response = ResponseEntity.class) })
	ResponseEntity cadastra(@RequestBody ProgramaCadastroForm programaCadastroForm);
}
