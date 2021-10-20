package br.com.sis.rh.apiprogramaformacao.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sis.rh.apiprogramaformacao.api.model.Formacao;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.vo.FormacaoBuscaDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.ParticipanteBuscaDto;
import br.com.sis.rh.apiprogramaformacao.core.repository.FormacaoRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;
import br.com.sis.rh.apiprogramaformacao.core.service.BuscaService;

@RestController
@RequestMapping("/busca")
public class BuscaController {
	
	@Autowired
	private BuscaService buscaService;
	
	//lista participantes na tabela - busca participantes
	@GetMapping("participantes/{statusPart}")
	public List<ParticipanteBuscaDto> listarPart(@PathVariable Boolean statusPart) {
		List<Participante> participantes = buscaService.buscaPorStatus(statusPart);
		return ParticipanteBuscaDto.converter(participantes);
	}
	
	//lista formação no select - busca participantes
	@GetMapping("participantes/programa/{statusProg}")
	public List<FormacaoBuscaDto> listarForm(@PathVariable Boolean statusProg){
		List<Formacao> formacoes = buscaService.buscaPorStatusForm(statusProg);
		return FormacaoBuscaDto.converter(formacoes);
	}
	
}
