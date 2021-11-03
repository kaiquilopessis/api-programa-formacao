package br.com.sis.rh.apiprogramaformacao.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;
import br.com.sis.rh.apiprogramaformacao.core.service.DirecionamentoService;
import br.com.sis.rh.apiprogramaformacao.core.service.FiltroConclusao;

@RestController
@RequestMapping("/conclusoes")
@CrossOrigin
public class ConclusaoController {

	@Autowired
	private FiltroConclusao filtroConclusao;

	@Autowired
	private ParticipanteRepository participanteRepository;

	@Autowired
	private DirecionamentoService direcionamento;

	@GetMapping("/formacao={formacao}/turma={turma}/escopo={escopo}")
	public Integer listaParticipantesAtivo(@PathVariable String formacao, @PathVariable String turma,
			@PathVariable String escopo) {
		System.out.println("chamando service " + escopo + ".");
		Integer filtragem = direcionamento.Direcionar(formacao, turma, escopo);
		System.out.println(filtragem);
		return filtragem;
	}

	public Integer listaParticipantesEfetivados(@PathVariable String formacao, @PathVariable String turma) {
		return participanteRepository.listaParticipantesEfetivados();
	}

}
