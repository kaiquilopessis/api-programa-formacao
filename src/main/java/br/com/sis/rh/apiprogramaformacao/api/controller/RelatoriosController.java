package br.com.sis.rh.apiprogramaformacao.api.controller;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ParticipanteProgramaDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ProgramaDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.TurmaDto;
import br.com.sis.rh.apiprogramaformacao.core.service.FiltroRelatorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
	public List<ParticipanteProgramaDto> listaParticipantesAtivos() {
		return filtroRelatorio.listaTotalParticipantesAtivos();
	}

	@GetMapping("/participantesEfetivados")
	public List<ParticipanteProgramaDto> listaParticipantesEfetivados() {
		return filtroRelatorio.listaTotalParticipantesEfetivados();
	}

	@GetMapping("/formacoesEmAndamento")
	public List<ProgramaDto> listaFormacoesEmAndamento() {
		return filtroRelatorio.listaTotalFormacoesEmAndamento();
	}

	@GetMapping("/formacoes")
	public List<ProgramaDto> buscarTodasFormacoes(){
		return filtroRelatorio.buscarTodasAsFormacoes();
	}

	@GetMapping("/turmas/{nomePrograma}")
	public List<TurmaDto> buscarTodasTurmas(@PathVariable String nomePrograma){
		return filtroRelatorio.buscarTodasAsTurmas(nomePrograma);
	}
	
}
