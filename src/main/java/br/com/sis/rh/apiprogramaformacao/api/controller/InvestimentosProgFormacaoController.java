package br.com.sis.rh.apiprogramaformacao.api.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lowagie.text.DocumentException;
import br.com.sis.rh.apiprogramaformacao.api.vo.InvestimentoProgFormacaoVo;
import br.com.sis.rh.apiprogramaformacao.core.service.ExcelServiceInvestimento;
import br.com.sis.rh.apiprogramaformacao.core.service.InvestimentosProgFormacaoService;
import br.com.sis.rh.apiprogramaformacao.core.service.PDFServiceInvestimento;
import br.com.sis.rh.apiprogramaformacao.core.service.InvestimentoFiltroPeriodoService;
import br.com.sis.rh.apiprogramaformacao.core.util.DataFormaterUtil;

/**
 * 
 * @author dkalbiak
 *
 *         Esta classe é responsável pelo processamento das requisições e por
 *         gerar respostas da tela de investimentos
 *
 */
@RestController
@RequestMapping("/investimentos")
@CrossOrigin
public class InvestimentosProgFormacaoController {

	// Injeções de dependencias

	@Autowired
	private InvestimentosProgFormacaoService investService;
	@Autowired
	private InvestimentoFiltroPeriodoService service;
	@Autowired
	private DataFormaterUtil dataFormat;
	@Autowired
	private ExcelServiceInvestimento excel;

	/**
	 * Este método gera as respostas dos cards superiores contidos na pagina "Antes
	 * do filtro de data"
	 * 
	 * @param nomePrograma faz o processamento do nome do programa ao ser
	 *                     selecionado na tela Relatórios
	 * @param nomeTurma    faz o processamento do nome da turma ao ser selecionado
	 *                     na tela Relatórios
	 * @return retorna o total do investimento do programa de acordo com a seleceção
	 *         da tela Relatórios
	 */
	@GetMapping("/investimentosPrograma/{nomePrograma}/{nomeTurma}")
	public InvestimentoProgFormacaoVo investimentosPrograma(@PathVariable String nomePrograma,
			@PathVariable String nomeTurma) {

		InvestimentoProgFormacaoVo investParticipantes = investService.popularCardsSuperiores(nomePrograma, nomeTurma);

		return investParticipantes;
	}

	/**
	 * Este método gera as respostas dos cards inferiores, metodo usado para
	 * retornar os valores após a seleção de data
	 * 
	 * @param dataInicio   processa a data de inicio selecionada na tela
	 *                     investimentos
	 * @param dataFim      processa a data de fim selecionada na tela investimentos
	 * @param nomePrograma processa o nome do programa selecionado na tela
	 *                     Relatórios
	 * @param nomeTurma    processa o nome da turma selecionado na tela Relatórios
	 * @return gerada como resposta o investimento do periodo selecionado de acordo
	 *         com a turma e o programa selecionado
	 * @throws ParseException
	 */

	@GetMapping("/investimentoPeriodoSelecionado/{dataInicio}/{dataFim}")
	public InvestimentoProgFormacaoVo investDoPeriodoPrograma(@PathVariable String dataInicio,
			@PathVariable String dataFim, String nomePrograma, String nomeTurma) throws ParseException {
		
		LocalDate dataFormatadaInicio = dataFormat.dataFormatada(dataInicio);
		LocalDate dataFormatadaFim = dataFormat.dataFormatada(dataFim);

		InvestimentoProgFormacaoVo investimentoPrograma = service.popularCards(dataFormatadaInicio, dataFormatadaFim,
				"Turma II", "Turma I");

		return investimentoPrograma;
	}

	/**
	 * Esse método responsável por gerar o PDF da tela investimento
	 * 
	 * @param response
	 * @param nomePrograma processa o nome do programa selecionado na tela
	 *                     Relatórios
	 * @param nomeTurma    processa o nome da truma selecionada na tela Relatórios
	 * @throws DocumentException
	 * @throws IOException
	 */
	@GetMapping("/pdf")
	public void downloadPDF(HttpServletResponse response, @PathVariable String nomePrograma,
			@PathVariable String nomeTurma) throws DocumentException, IOException {
		response.setContentType("application/pdf");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=RelatorioAlura.pdf";
		response.setHeader(headerKey, headerValue);

		InvestimentoProgFormacaoVo investimentoSemFiltroData = investService.popularCardsSuperiores(nomePrograma,
				nomeTurma);

		PDFServiceInvestimento exporter = new PDFServiceInvestimento(investimentoSemFiltroData);
		exporter.export(response);

	}

	/**
	 * Esse método responsável por gerar o XLSX da tela investimento
	 * 
	 * @param response
	 * @param nomePrograma processa o nome do programa selecionado na tela
	 *                     Relatórios
	 * @param nomeTurma    processa o nome da truma selecionada na tela Relatórios
	 * @throws IOException
	 */
	@GetMapping("/xlsx")
	public void downloadXLSX(HttpServletResponse response, @PathVariable String nomePrograma,
			@PathVariable String nomeTurma) throws IOException {
		InvestimentoProgFormacaoVo investimentoProgFormacaoVo = investService.popularCardsSuperiores(nomePrograma,
				nomeTurma);

		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=Investimentos.xlsx");
		ByteArrayInputStream stream = excel.excelInvestimentoProgFormacao(investimentoProgFormacaoVo);
		IOUtils.copy(stream, response.getOutputStream());
	}

}
