package br.com.sis.rh.apiprogramaformacao.api.openApi;

import java.util.List;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.NomeProgramaEmAndamentoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ParticipanteProgramaDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.RelatorioAvaliacoesVo;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.TurmaDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Relatórios Controller")
public interface RelatoriosControllerOpenApi {
	

	@ApiOperation("Retorna participantes ativos")
	@ApiResponses({@ApiResponse(code = 200, message = "OK", response = RelatorioAvaliacoesVo.class)})
	List<ParticipanteProgramaDto> listaParticipantesAtivos();
	
	@ApiOperation("Retorna participantes efetivados")
	@ApiResponses({@ApiResponse(code = 200, message = "OK", response = RelatorioAvaliacoesVo.class)})
	List<ParticipanteProgramaDto> listaParticipantesEfetivados();
	
	@ApiOperation("Retorna formações em andamento")
	@ApiResponses({@ApiResponse(code = 200, message = "OK", response = RelatorioAvaliacoesVo.class)})
	List<NomeProgramaEmAndamentoDto> listaFormacoesEmAndamento();
	
	@ApiOperation("Retorna formações")
	@ApiResponses({@ApiResponse(code = 200, message = "OK", response = RelatorioAvaliacoesVo.class)})
	List<NomeProgramaEmAndamentoDto> buscarTodasFormacoes();
	
	@ApiOperation("Retorna todas as turmas")
	@ApiResponses({@ApiResponse(code = 200, message = "OK", response = RelatorioAvaliacoesVo.class)})
	public List<TurmaDto> buscarTodasTurmas(@ApiParam (value = "busca todas as turmas",
            example = "Mainframe", required = true) String nomePrograma);
	
}
