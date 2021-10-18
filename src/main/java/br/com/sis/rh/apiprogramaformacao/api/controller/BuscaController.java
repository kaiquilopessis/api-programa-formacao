package br.com.sis.rh.apiprogramaformacao.api.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sis.rh.apiprogramaformacao.api.model.Formacao;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.vo.FormacaoBuscaDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.ParticipanteBuscaDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.ParticipanteBuscaNomeDto;
import br.com.sis.rh.apiprogramaformacao.core.repository.FormacaoRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;

@RestController
@RequestMapping("/busca")
@CrossOrigin
public class BuscaController {
	
	
	@Autowired
	ParticipanteRepository participanteRepository;
	
	@Autowired
	FormacaoRepository formacaoRepository;
	
	
	//lista participantes na tabela - busca participantes
	@GetMapping("participantes/{statusPart}")
	public List<ParticipanteBuscaDto> listarPart(@PathVariable Boolean statusPart) {
		List<Participante> participantes = participanteRepository.findByStatus(statusPart);
		return ParticipanteBuscaDto.converter(participantes);
	}
	
	//lista formação no select - busca participantes
	@GetMapping("participantes/programa/{statusProg}")
	public List<FormacaoBuscaDto> listar(@PathVariable Boolean statusProg){
		List<Formacao> formacoes = formacaoRepository.findByStatus(statusProg);
		return FormacaoBuscaDto.converter(formacoes);
	}
	
}
