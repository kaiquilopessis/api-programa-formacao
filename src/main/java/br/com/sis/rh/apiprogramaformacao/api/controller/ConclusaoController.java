package br.com.sis.rh.apiprogramaformacao.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sis.rh.apiprogramaformacao.api.vo.RelatorioConclusaoVO;
import br.com.sis.rh.apiprogramaformacao.core.service.ConclusaoService;

@RestController
@RequestMapping("/conclusoes")
@CrossOrigin
public class ConclusaoController {

	@Autowired
	private ConclusaoService conclusaoService;

	@GetMapping("/formacao={formacao}/turma={turma}/escopo={escopo}")
	public RelatorioConclusaoVO listaParticipantesAtivo(@PathVariable String formacao, @PathVariable String turma,
			@PathVariable String escopo) {
		RelatorioConclusaoVO conclusao = conclusaoService.popularCards(formacao, turma);
		
		return conclusao;
	}

	
	
}
