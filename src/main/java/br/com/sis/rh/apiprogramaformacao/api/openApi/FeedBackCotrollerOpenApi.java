package br.com.sis.rh.apiprogramaformacao.api.openApi;


import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FeedBackDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.FeedBackForm;
import io.swagger.annotations.*;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Api(tags = "FeedBack Controller")
public interface FeedBackCotrollerOpenApi {

    @ApiOperation("Método responsável por listar os feedbacks do participante selecionado por cpf")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = FeedBackDto.class)})
    List<FeedBackDto> listarFeedBacks(@ApiParam(value = "cpf", example = "33092410840", required = true) String cpf);

    @ApiOperation("Método responsável pelo download do DISC do partcipante selecionando por id")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = ByteArrayResource.class)})
    ResponseEntity<ByteArrayResource> downloadDisc(@ApiParam(value = "id", example = "1", required = true) Long id);

    @ApiOperation("Método responsável por incluir um novo feedback de um participante selecionado por cpf")
    @ApiResponses({@ApiResponse(code = 201, message = "Created", response = FeedBackDto.class)})
    ResponseEntity<FeedBackDto> cadastrarFeed(@ApiParam(value = "cpf", example = "33092410840", required = true) String cpf, FeedBackForm feedBackForm,
                                              UriComponentsBuilder uriComponentsBuilder);

    @ApiOperation("Método responsável por deletar um feedback de um participante selecionando o feedback por id")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = FeedBackDto.class)})
    ResponseEntity<FeedBackDto> deletarFeed(@ApiParam(value = "id", example = "1", required = true) Long id);
}
