package br.com.sis.rh.apiprogramaformacao.api.openApi;


import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CpfParticipanteNomeDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FeedBackDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FiltragemFolhaDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.FolhaForm;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Folha Controller")
public interface FolhaContollerOpenApi {

    @ApiOperation("Método responsável por mostrar os filtros")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = FiltragemFolhaDto.class)})
    List<FiltragemFolhaDto> mostrarFiltros(@ApiParam(value = "nomePrograma", example = "Formação Java", required = true) String nomePrograma,
                                           @ApiParam(value = "nomeTurma", example = "Turma II", required = true) String nomeTurma);

    @ApiOperation("Método responsável por salvar um investimento")
    @ApiResponses({@ApiResponse(code = 201, message = "Created")})
    void salvarInvestimentos(FolhaForm folhaForm);

    @ApiOperation("Método responsável por mostrar os participantes selecionados usando o filtro")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = CpfParticipanteNomeDto.class)})
    List<CpfParticipanteNomeDto> mostrarParticipantes(@ApiParam(value = "nomePrograma", example = "Formação Java", required = true) String nomePrograma,
                                                      @ApiParam(value = "nomeTurma", example = "Turma II", required = true) String nomeTurma);
}
