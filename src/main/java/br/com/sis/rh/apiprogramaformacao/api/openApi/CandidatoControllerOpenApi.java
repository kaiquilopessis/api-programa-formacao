package br.com.sis.rh.apiprogramaformacao.api.openApi;


import br.com.sis.rh.apiprogramaformacao.api.vo.dto.*;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AtualizaCandidatoForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.CandidatoForm;
import io.swagger.annotations.*;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;

import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.List;

@Api(tags = "Candidato Controller")
public interface CandidatoControllerOpenApi {

    @ApiOperation("Retorna uma lista de candidatos")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = ListaCandidatoDto.class)})
    List<ListaCandidatoDto> listaCandidato();

    @ApiOperation("Retorna um unico candidato selecionado por um id")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = CandidatoDto.class)})
    ResponseEntity<CandidatoDto> mostrarCandidato(@ApiParam(value = "id", example = "1", required = true) Long id);

    @ApiOperation("Retorna uma lista de candidatos que participam de um processo seletivo especifico, id é referente ao processo seletivo")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = ListaCandidatoDto.class)})
    List<ListaCandidatoDto> mostraListaCandidatoEmProcesso(@ApiParam(value = "id", example = "1", required = true) Long id);

    @ApiOperation("Altera os dados do candidato referente ao id informado no parâmetro")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = CandidatoDto.class)})
    ResponseEntity<CandidatoDto> atualizarCandidato(@ApiParam(value = "id", example = "1", required = true) Long id, AtualizaCandidatoForm form) throws IOException;

    @ApiOperation("Cria um candidato")
    @ApiResponses({@ApiResponse(code = 201, message = "Created", response = CandidatoDto.class)})
    ResponseEntity<CandidatoDto> inserirCandidato(CandidatoForm form, UriComponentsBuilder uriBuilder) throws IOException;

    @ApiOperation("Método responsável por fazer o download do curriculo do candidato selecionado por id")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = ByteArrayResource.class)})
    ResponseEntity<ByteArrayResource> downloadCurriculo(@ApiParam(value = "id", example = "1", required = true) Long id);

    @ApiOperation("Método responsável por fazer o download do DISC do candidato selecionado por id")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = ByteArrayResource.class)})
    ResponseEntity<ByteArrayResource> downloadDisc(@ApiParam(value = "id", example = "1", required = true) Long id);

    @ApiOperation("Método responsável por retornar o nome do programa que o candidato está inserido")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = NomeProgramaCandidatoDto.class)})
    NomeProgramaCandidatoDto listaTurmasEProgramaCandidato (@ApiParam(value = "id", example = "1", required = true) Long id);

    @ApiOperation("Método responsável por retornar o nome da turma em que o candidato está inserido")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = NomeTurmaCandidatoDto.class)})
    List<NomeTurmaCandidatoDto> listarTurmasPorPrograma(@ApiParam(value = "nomePrograma", example = "Turma I", required = true) String nomePrograma);

    @ApiOperation("Retorna o nome do instrutor ativo")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = NomeInstrutorDto.class)})
    List<NomeInstrutorDto> listarInstrutoresAtivos();

    @ApiOperation("Método responsável por retornar o cargo de um candidato selecionado por id")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = CargoModalDto.class)})
    CargoModalDto mostrarCargo(@ApiParam(value = "id", example = "1", required = true) Long id);

    @ApiOperation("Método responsável por retornar a turma de um candidato")
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = TurmaModalDto.class)})
    TurmaModalDto mostrarTurma(@ApiParam(value = "id", example = "1", required = true) Long id);
}
