package br.com.sis.rh.apiprogramaformacao.api.controller;

/**
 * Esta Classe é referente a tela de relatorios investimento
 * Esta classe é responsavel por processar as requisições e gerar respostas
 */

import java.text.ParseException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.sis.rh.apiprogramaformacao.api.vo.InvestimentoProgFormacaoVo;
import br.com.sis.rh.apiprogramaformacao.core.service.InvestimentosProgFormacaoService;
import br.com.sis.rh.apiprogramaformacao.core.service.ServiceFiltroPeriodo;
import br.com.sis.rh.apiprogramaformacao.core.util.DataFormaterUtil;

@RestController
@RequestMapping("/investimentos")
@CrossOrigin
public class InvestimentosProgFormacaoController {

	// Injeções de dependencias

	@Autowired
	private InvestimentosProgFormacaoService investService;
	@Autowired
	private ServiceFiltroPeriodo service;
	@Autowired
	private DataFormaterUtil dataFormat;

	// Respostas dos cards superiores contidos na pagina "Antes do filtro de data"
	@GetMapping("/investimentosPrograma")
	public InvestimentoProgFormacaoVo investimentosPrograma() {

		InvestimentoProgFormacaoVo investParticipantes = investService.popularCardsSuperiores("Java", "Turma I");

		return investParticipantes;

	}

	// Respostas dos cards inferiores, metodo usado para retornar os valores após
	// realizar a seleção das datas
	@GetMapping("/investimentoPeriodoSelecionado/{dataInicio}/{dataFim}")
	public InvestimentoProgFormacaoVo investDoPeriodoPrograma(@PathVariable String dataInicio,
			@PathVariable String dataFim, String nomePrograma, String nomeTurma) throws ParseException {
		LocalDate dataFormatadaInicio = dataFormat.dataFormatada(dataInicio);
		LocalDate dataFormatadaFim = dataFormat.dataFormatada(dataFim);

		InvestimentoProgFormacaoVo investimentoPrograma = service.popularCards(dataFormatadaInicio, dataFormatadaFim,
				"Java", "Turma I");

		return investimentoPrograma;
	}

}
