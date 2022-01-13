package br.com.sis.rh.apiprogramaformacao.api.openApi;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CpfInstrutorNomeDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FiltragemInstrutorDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.InstrutorVo;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AttInstrutorForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.InstrutorForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.InvestimentoInstrutorForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Instrutor Controller")
public interface InstrutorControllerOpenApi {

	// Get

	@ApiOperation("Busca lista de instrutores")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = InstrutorVo.class) })
	ResponseEntity<List<InstrutorVo>> getPadrao();

	@ApiOperation("Retorna instrutor por cpf")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = InstrutorVo.class) })
	ResponseEntity<InstrutorVo> getByCpf(
			@ApiParam(value = "tipo do registro", example = "896.205.310-19", required = true) String cpf);

	@ApiOperation("Retorna instrutor pelo status")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = InstrutorVo.class) })
	ResponseEntity<List<InstrutorVo>> getByStatus(
			@ApiParam(value = "tipo do registro", example = "ATIVO", required = true) String status);

	// PUT
	@ApiOperation("Altera o status do instrutor")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = ResponseEntity.class) })
	ResponseEntity alteraStatus(@ApiParam(value = "tipo do registro", example = "ATIVO", required = true) String cpf);

	@ApiOperation("Altera o instrutor")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = ResponseEntity.class) })
	ResponseEntity alterarInstrutor(
			@ApiParam(value = "tipo do registro", example = "ATIVO", required = true) String cpf,
			AttInstrutorForm attInstrutorForm);

	// POST
	@ApiOperation("Cadastra um novo instrutor")
	@ApiResponses({ @ApiResponse(code = 201, message = "Created", response = ResponseEntity.class) })
	ResponseEntity cadastro(InstrutorForm form);

	// Get relacionado a Remuneracao
	@ApiOperation("Mostra dados de instrutores")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = FiltragemInstrutorDto.class) })
	List<FiltragemInstrutorDto> mostrarDados(
			@ApiParam(value = "tipo do registro", example = "Java", required = true) String nomePrograma,
			@ApiParam(value = "tipo do registro", example = "Turma 1", required = true) String nomeTurma);

	@ApiOperation("Mostra os instrutores")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = CpfInstrutorNomeDto.class) })
	List<CpfInstrutorNomeDto> mostrarInstrutores(
			@ApiParam(value = "tipo do registro", example = "Java", required = true) String nomePrograma,
			@ApiParam(value = "tipo do registro", example = "Turma 1", required = true) String nomeTurma);

	// POST relacionado a Remuneracao

	@ApiOperation("Salva os investimentos")
	@ApiResponses({ @ApiResponse(code = 201, message = "CREATED", response = ResponseEntity.class) })
	public ResponseEntity salvarInvestimentos(InvestimentoInstrutorForm investimentoInstrutorForm);

}
