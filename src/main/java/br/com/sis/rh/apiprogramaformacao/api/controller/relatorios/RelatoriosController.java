package br.com.sis.rh.apiprogramaformacao.api.controller.relatorios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sis.rh.apiprogramaformacao.api.openApi.RelatoriosControllerOpenApi;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.NomeProgramaEmAndamentoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ParticipanteProgramaDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.TurmaDto;
import br.com.sis.rh.apiprogramaformacao.core.service.relatorios.FiltroRelatorio;

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
public class RelatoriosController implements RelatoriosControllerOpenApi {
	
	@Autowired
	private FiltroRelatorio filtroRelatorio;
	
	// Busca o número total de participantes ativos, efetivados e formações em andamento
	@RequestMapping
	public List<Integer> numeroTotalParaCadaFiltro() {
		return filtroRelatorio.numeroTotalParaCadaFiltro();
	}
	
	@GetMapping("/participantesAtivos")
	@Override
	public List<ParticipanteProgramaDto> listaParticipantesAtivos() {
		return filtroRelatorio.listaTotalParticipantesAtivos();
	}

	@GetMapping("/participantesEfetivados")
	@Override
	public List<ParticipanteProgramaDto> listaParticipantesEfetivados() {
		return filtroRelatorio.listaTotalParticipantesEfetivados();
	}

	@GetMapping("/formacoesEmAndamento")
	@Override
	public List<NomeProgramaEmAndamentoDto> listaFormacoesEmAndamento() {
		return filtroRelatorio.listaTotalFormacoesEmAndamento();
	}

	@GetMapping("/formacoes")
	@Override
	public List<NomeProgramaEmAndamentoDto> buscarTodasFormacoes(){
		return filtroRelatorio.buscarTodasAsFormacoes();
	}

	@GetMapping("/turmas/{nomePrograma}")
	@Override
	public List<TurmaDto> buscarTodasTurmas(@PathVariable String nomePrograma){
		return filtroRelatorio.buscarTodasAsTurmas(nomePrograma);
	}

	
}
