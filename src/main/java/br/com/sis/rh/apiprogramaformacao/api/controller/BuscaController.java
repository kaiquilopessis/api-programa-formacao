package br.com.sis.rh.apiprogramaformacao.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FormacaoBuscaDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ParticipanteBuscaDto;
import br.com.sis.rh.apiprogramaformacao.core.service.BuscaService;

@RestController
@RequestMapping("/busca")
public class BuscaController {
	
	@Autowired
	private BuscaService buscaService;
	
	//lista participantes na tabela - busca participantes
	@GetMapping("participantes/{statusPart}")
	public List<ParticipanteBuscaDto> listarPart(@PathVariable String statusPart) {
		return buscaService.buscaPorStatus(statusPart);
	}
	
	
	//lista formação no select - busca participantes
	@GetMapping("participantes/programa/{statusProg}")
	public List<FormacaoBuscaDto> listarForm(@PathVariable String statusProg){
		return buscaService.buscaPorStatusForm(statusProg);
	}
	
}
