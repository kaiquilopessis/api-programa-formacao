package br.com.sis.rh.apiprogramaformacao.api.openApi;


import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CicloDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CicloFinalDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ListaCandidatoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.RemuneracaoProgramaDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.CicloFinalForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.CicloProgressivoForm;
import io.swagger.annotations.*;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Api(tags = "Ciclo Controller")
public interface CicloControllerOpenApi {

    @ApiOperation("Método responsável por listar as conclusões de um participante selecionado do cpf")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = CicloDto.class)})
    List<CicloDto> listaConclusoes (@ApiParam(value = "cpf", example = "33092410840", required = true) String cpf);

    @ApiOperation("Método responsável por gerar lista com todas as remunerações do programa")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = RemuneracaoProgramaDto.class)})
    List<RemuneracaoProgramaDto> listarRemuneracao();

    @ApiOperation("Método responsável pelo download de comprovantes pelo id")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = ByteArrayResource.class)})
    ResponseEntity<ByteArrayResource> downloadComprovante(@ApiParam(value = "id", example = "1", required = true) Long id);

    @ApiOperation("Método responsável por realizar a inserção de um registro")
    @ApiResponses({@ApiResponse(code = 201, message = "Created", response = CicloDto.class)})
    ResponseEntity<CicloDto> registroProgressivo (@ApiParam(value = "cpf", example = "33092410840", required = true) String cpf ,
                                                  CicloProgressivoForm conclusaoProgressivaForm, UriComponentsBuilder uriComponentsBuilder);

    @ApiOperation("Método responsável por realizar a inserção do registro final")
    @ApiResponses({@ApiResponse(code = 201, message = "Created", response = CicloFinalDto.class)})
    ResponseEntity<CicloFinalDto> registroFinal(@ApiParam(value = "cpf", example = "33092410840", required = true) String cpf,
                                                CicloFinalForm conclusaoFinalForm, UriComponentsBuilder uriComponentsBuilder);
}
