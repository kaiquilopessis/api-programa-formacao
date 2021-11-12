package br.com.sis.rh.apiprogramaformacao.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ParticipanteDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ProgramaDto;
import br.com.sis.rh.apiprogramaformacao.core.service.FiltroRelatorio;

/**
 * Classe Controller de relatórios
 * Esta classe está mapeada para buscar o total(int) de participantes ativos
 * e efetivados de todos os programas e as formações em andamento, assim como
 * a listagem desses itens.
 * @author psedassari
 */
@RestController
@RequestMapping("/api/relatorios")
@CrossOrigin
public class RelatoriosController {
	
	@Autowired
	private FiltroRelatorio filtroRelatorio;
	
	// Busca o número total de participantes ativos, efetivados e formações em andamento
	@RequestMapping
	public List<Integer> numeroTotalParaCadaFiltro() {
		return filtroRelatorio.numeroTotalParaCadaFiltro();	
	}
	
	@GetMapping("/participantesAtivos")
	public List<ParticipanteDto> listaParticipantesAtivos() {
		return filtroRelatorio.listaTotalParticipantesAtivos();
	}

	@GetMapping("/participantesEfetivados")
	public List<ParticipanteDto> listaParticipantesEfetivados() {
		return filtroRelatorio.listaTotalParticipantesEfetivados();
	}

	@GetMapping("/formacoesEmAndamento")
	public List<ProgramaDto> listaFormacoesEmAndamento() {
		return filtroRelatorio.listaTotalFormacoesEmAndamento();
	}
	
}
