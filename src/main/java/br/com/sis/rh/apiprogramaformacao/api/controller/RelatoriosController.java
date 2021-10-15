package br.com.sis.rh.apiprogramaformacao.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sis.rh.apiprogramaformacao.api.vo.FormacoesDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.ParticipanteDto;
import br.com.sis.rh.apiprogramaformacao.core.service.FiltroRelatorio;

@RestController
@RequestMapping("/relatorios")
@CrossOrigin
public class RelatoriosController {
	
	@Autowired
	FiltroRelatorio filtroRelatorio = new FiltroRelatorio();
	
	@RequestMapping
	public List<Integer> numeroTotalParaCadaFiltro() {
		return filtroRelatorio.numeroTotalParaCadaFiltro();	
	}
	
	@GetMapping("/participantesAtivos")
	public List<ParticipanteDto> listaTotalParticipantesAtivos() {
		return filtroRelatorio.listaTotalParticipantesAtivos();
	}

	@GetMapping("/participantesEfetivados")
	public List<ParticipanteDto> listaEfetivados() {
		return filtroRelatorio.listaTotalParticipantesEfetivados();
	}

	@GetMapping("/formacoesEmAndamento")
	public List<FormacoesDto> listaFormacoes() {
		return filtroRelatorio.listaTotalFormacoesEmAndamento();
	}
}
