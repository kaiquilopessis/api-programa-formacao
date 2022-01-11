package br.com.sis.rh.apiprogramaformacao.api.openApi;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CandidatoCompletoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CandidatoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.NomeProcessoSeletivoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ParticipanteBuscaDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ParticipanteBuscaNomeDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ParticipanteExibeDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AtualizaParticipanteForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AtualizaStatusParticipanteForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.CadastroParticipanteForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

//Get
@Api(tags = "Participante Controller")
public interface ParticipanteControllerOpenApi {
	@ApiOperation("Pega os participantes e converte para uma lista de participantes")
	@ApiResponses({@ApiResponse(code = 200, message = "OK", response = ParticipanteBuscaDto.class)})
	ResponseEntity<List<ParticipanteBuscaDto>> getPadrao();
	
	@ApiOperation("Lista os participantes na tabela de participantes")
	@ApiResponses({@ApiResponse(code = 200, message = "OK", response = ParticipanteBuscaDto.class)})
	 List<ParticipanteBuscaDto> listarPart();
	
	@ApiOperation("Busca o participante para mostrar o nome ")
	@ApiResponses({@ApiResponse(code = 200, message = "OK", response = ParticipanteBuscaNomeDto.class)})
	ResponseEntity<ParticipanteBuscaNomeDto> mostraNome(@ApiParam(value = "Cpf do Participante", example = "45976389899", required = true) String cpf);
	
	@ApiOperation("Filtra os participantes")
	@ApiResponses({@ApiResponse(code = 200, message = "OK", response = ParticipanteBuscaDto.class)})
	List<ParticipanteBuscaDto> filtrarParticipantes(@ApiParam(value = "Cpf do Participante", example = "45976389899", required = true) String cpf, @ApiParam(value = "Nome Programa", example = "Turma I", required = true) String NomePrograma, @ApiParam(value = "Java", example = "Turma I", required = true) String nomeTurma);

	@ApiOperation("Exibe as informações do participante")
	@ApiResponses({@ApiResponse(code = 200, message = "OK", response = ParticipanteExibeDto.class)})
	ParticipanteExibeDto participanteExibe(@ApiParam(value = "Cpf", example = "50749052813", required = true)String cpf);

	@ApiOperation("Exibe as informações do candidato")
	@ApiResponses({@ApiResponse(code = 200, message = "OK", response = CandidatoCompletoDto.class)})
	 CandidatoCompletoDto candidatoExibe(@ApiParam(value = "id", example = "1", required = true) Long id);

	@ApiOperation("Exibe os processos seletivos")
	@ApiResponses({@ApiResponse(code = 200, message = "OK", response = NomeProcessoSeletivoDto.class)})
	NomeProcessoSeletivoDto exibeNomeProcesso(@ApiParam(value = "id", example = "1", required = true) Long id);
	
	//post
	@ApiOperation("Cadastro para novos participantes")
	@ApiResponses({@ApiResponse(code = 201, message = "CREATED", response = CadastroParticipanteForm.class)})
	void cadastraParticipante(CadastroParticipanteForm cadastroParticipanteForm) throws IOException;
	
	@ApiOperation("Busca por candidatos para serem cadastrados como participantes")
	@ApiResponses({@ApiResponse(code = 200, message = "OK", response = CandidatoDto.class)})
	List<CandidatoDto> buscarCandidatosAprovados();
	
	@ApiOperation("Atualiza o status do participante")
	@ApiResponses({@ApiResponse(code = 201, message = "CREATED", response = AtualizaStatusParticipanteForm.class)})
	 void atualizaStatusParticipante( AtualizaStatusParticipanteForm atualizaStatusParticipanteForm);

	@ApiOperation("Atualiza os dados do participante")
	@ApiResponses({@ApiResponse(code = 201, message = "CREATED", response = AtualizaParticipanteForm.class)})
	void atualizaParticipante( AtualizaParticipanteForm atualizaParticipanteForm ) throws IOException;

	@ApiOperation("Download TCE")
	@ApiResponses({@ApiResponse(code = 200, message = "OK", response = ByteArrayResource.class)})
	 ResponseEntity<ByteArrayResource> downloadTceDoCandidato(@ApiParam(value = "TCE", example = "1", required = true) String id);
	
	@ApiOperation("Download DISC candidato")
	@ApiResponses({@ApiResponse(code = 200, message = "OK", response = ByteArrayResource.class)})
	ResponseEntity<ByteArrayResource> downloadDiscDoCandidato(@ApiParam(value = "Disc candidato", example = "1", required = true) String id);
}




