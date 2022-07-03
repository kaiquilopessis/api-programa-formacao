package br.com.sis.rh.apiprogramaformacao.api.openApi;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sis.rh.apiprogramaformacao.api.model.cargos.Remuneracao;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CargosDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ListaRemuneracaoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.RelatorioAvaliacoesVo;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.RemuneracaoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AtualizaRemuneracaoForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.RemuneracaoForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Remuneração Controller")
public interface RemuneracaoControllerOpenApi {
	
	@ApiOperation("Lista remuneração")
	@ApiResponses({@ApiResponse(code = 200, message = "OK", response = RelatorioAvaliacoesVo.class)})
	List<ListaRemuneracaoDto> listaRemuneracao();
	
	@ApiOperation("Exibe remuneração")
	@ApiResponses({@ApiResponse(code = 200, message = "OK", response = RelatorioAvaliacoesVo.class)})
	ResponseEntity<RemuneracaoDto> exibeRemuneracao (@ApiParam(value = "Exibição da remuneração",
            example = "1", required = true)long id);
	
	@ApiOperation("Cria um novo cargo")
    @ApiResponses({@ApiResponse(code = 201, message = "Created", response = Remuneracao.class)})
    ResponseEntity<RemuneracaoDto> criaRemuneracao(RemuneracaoForm form, UriComponentsBuilder uriBuilder) throws IOException;
	
	@ApiOperation("Mostra cargo")
	@ApiResponses({@ApiResponse(code = 200, message = "OK", response = CargosDto.class)})
	List<CargosDto> mostrarCargos();
	
	@ApiOperation("Edita um cargo")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = Remuneracao.class)})
	ResponseEntity<RemuneracaoDto>atualizarRemuneracao(@ApiParam(value = "id", example = "1", required = true) Long id, AtualizaRemuneracaoForm form) throws IOException;
	
 
}
