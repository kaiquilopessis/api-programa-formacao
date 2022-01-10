package br.com.sis.rh.apiprogramaformacao.api.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.openApi.ParticipanteControllerOpenApi;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CandidatoCompletoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CandidatoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.NomeProcessoSeletivoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ParticipanteBuscaDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ParticipanteBuscaNomeDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ParticipanteExibeDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AtualizaParticipanteForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AtualizaStatusParticipanteForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.CadastroParticipanteForm;
import br.com.sis.rh.apiprogramaformacao.core.service.CandidatoService;
import br.com.sis.rh.apiprogramaformacao.core.service.ParticipanteService;

@RestController
@RequestMapping("/api/participante")
public class ParticipanteController  implements ParticipanteControllerOpenApi{

	@Autowired
	private ParticipanteService participanteService;
	
	@Autowired
	private CandidatoService candidatoService;
	
	@Override
	@GetMapping
	public ResponseEntity<List<ParticipanteBuscaDto>> getPadrao() {
		List<Participante> listaParticipante = participanteService.todosParticipantes();
		List<ParticipanteBuscaDto> participanteBuscaVos = ParticipanteBuscaDto.converter(listaParticipante);

		return ResponseEntity.ok(participanteBuscaVos);
	}

	/* lista participantes na tabela - busca participantes */

	@Override
	@GetMapping("/ativos")
	public List<ParticipanteBuscaDto> listarPart() {
		return participanteService.buscaPorStatus();
	}
	
	@Override
	@GetMapping("/{cpf}")
	public ResponseEntity<ParticipanteBuscaNomeDto> mostraNome(@PathVariable String cpf) {
		return participanteService.buscaPorId(cpf);
	}

	@Override
	@GetMapping("{nome}/{nomePrograma}/{nomeTurma}")
	public List<ParticipanteBuscaDto> filtrarParticipantes(@PathVariable String nome,
															@PathVariable String nomePrograma,
															@PathVariable String nomeTurma) {
		return participanteService.filtrarParticipantes(nome, nomePrograma, nomeTurma);

	}


	@Override
	@GetMapping("/completo/{cpf}")
	public ParticipanteExibeDto participanteExibe(@PathVariable String cpf) {
		return new ParticipanteExibeDto(participanteService.participanteCpf(cpf));
	}

	@Override
	@GetMapping("/candidato/{id}")
	public CandidatoCompletoDto candidatoExibe(@PathVariable Long id){
		return new CandidatoCompletoDto(candidatoService.candidatoId(id));
	}

	@GetMapping("/nomePrograma/{id}")
	public NomeProcessoSeletivoDto exibeNomeProcesso(@PathVariable Long id){
		return new NomeProcessoSeletivoDto(candidatoService.buscarNomePrograma(id));
	}

//	@PutMapping("/{cpf}")
//	@Transactional
//	public ResponseEntity<ParticipanteExibeDto> atualizaParticipante(@PathVariable String cpf,
//			@RequestBody AtualizaParticipanteForm form) {
//		Participante participante = participanteService.atualizaParticipante(cpf, form);
//		return ResponseEntity.ok().body(new ParticipanteExibeDto(participante));
//	}

	@PostMapping("/salvarParticipante")
	public void cadastraParticipante(@ModelAttribute CadastroParticipanteForm cadastroParticipanteForm) throws IOException{
		participanteService.cadastrarParticipante(cadastroParticipanteForm);
	}

	@GetMapping("/status")
	public List<CandidatoDto> buscarCandidatosAprovados() {
		return candidatoService.buscaCandidatoAprovado();
	}
	
	@PutMapping("/atualizaStatus")
	public void atualizaStatusParticipante(@RequestBody AtualizaStatusParticipanteForm atualizaStatusParticipanteForm) {
		participanteService.atualizarStatus(atualizaStatusParticipanteForm);
	}
	
	@PutMapping("/atualizaParticipante")
	public void atualizaParticipante(@ModelAttribute AtualizaParticipanteForm atualizaParticipanteForm ) throws IOException {
		participanteService.atualizarParticipante(atualizaParticipanteForm);
	}
	
	 /* Endereço da api para baixar o arquivo direto do banco*/
   	@GetMapping("/downloadTce/{id}")
   	public ResponseEntity<ByteArrayResource> downloadTceDoCandidato(@PathVariable String id) {
   		return participanteService.downloadTce(id);
   		
   	}
   	
 	@GetMapping("/downloadDisc/{id}")
   	public ResponseEntity<ByteArrayResource> downloadDiscDoCandidato(@PathVariable String id) {
   		return participanteService.downloadDisc(id);
   		
   	}
}
