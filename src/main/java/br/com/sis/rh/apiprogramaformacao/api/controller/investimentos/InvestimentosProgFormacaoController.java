package br.com.sis.rh.apiprogramaformacao.api.controller.investimentos;

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

import br.com.sis.rh.apiprogramaformacao.api.openApi.InvestimentosProgFormacaoControllerOpenApi;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.InvestimentoProgFormacaoVo;
import br.com.sis.rh.apiprogramaformacao.core.service.investimentos.InvestimentoFiltroPeriodoService;
import br.com.sis.rh.apiprogramaformacao.core.service.investimentos.InvestimentosProgFormacaoService;
import br.com.sis.rh.apiprogramaformacao.core.service.relatorios.ExcelServiceInvestimento;
import br.com.sis.rh.apiprogramaformacao.core.service.relatorios.PDFServiceInvestimento;
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
@RequestMapping("/api/investimentos")
@CrossOrigin
public class InvestimentosProgFormacaoController implements InvestimentosProgFormacaoControllerOpenApi {

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
	@Override
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
	@Override
	@GetMapping("/investimentoPeriodoSelecionado/{nomePrograma}/{nomeTurma}/{dataInicio}/{dataFim}")
	public InvestimentoProgFormacaoVo investDoPeriodoPrograma(@PathVariable String nomePrograma, @PathVariable String nomeTurma, @PathVariable String dataInicio,
			@PathVariable String dataFim) throws ParseException {
		
		LocalDate dataFormatadaInicio = dataFormat.dataFormatada(dataInicio);
		LocalDate dataFormatadaFim = dataFormat.dataFormatada(dataFim);

		InvestimentoProgFormacaoVo investimentoPrograma = service.popularCards(dataFormatadaInicio, dataFormatadaFim,
				nomePrograma, nomeTurma);

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
	 * @throws ParseException 
	 */
	@Override
	@GetMapping("/{nomePrograma}/{nomeTurma}/{dataInicio}/{dataFim}/pdf")
	public void downloadPDF(HttpServletResponse response, @PathVariable String nomePrograma, @PathVariable String nomeTurma, @PathVariable String dataInicio,
			@PathVariable String dataFim) throws DocumentException, IOException, ParseException {
		response.setContentType("application/pdf");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Investimento.pdf";
		response.setHeader(headerKey, headerValue);

		InvestimentoProgFormacaoVo investimentoProgFormacaoVo = investService.popularCardsSuperiores(nomePrograma,
				nomeTurma);
		
		LocalDate dataFormatadaInicio = dataFormat.dataFormatada(dataInicio);
		LocalDate dataFormatadaFim = dataFormat.dataFormatada(dataFim);
		
		InvestimentoProgFormacaoVo investimento = service.popularCards(dataFormatadaInicio, dataFormatadaFim, nomePrograma, nomeTurma);
		
		investimentoProgFormacaoVo.setInvestParticipantesPeriodoSelecionado(investimento.getInvestParticipantesPeriodoSelecionado());
		investimentoProgFormacaoVo.setInvestInstrutoresPeriodoSelecionado(investimento.getInvestInstrutoresPeriodoSelecionado());
		investimentoProgFormacaoVo.setInvestTotalPeriodoSelecionado(investimento.getInvestTotalPeriodoSelecionado());

		PDFServiceInvestimento exporter = new PDFServiceInvestimento(investimentoProgFormacaoVo);
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
	 * @throws ParseException 
	 */
	@Override
	@GetMapping("/{nomePrograma}/{nomeTurma}/{dataInicio}/{dataFim}/xlsx")
	public void downloadXLSX(HttpServletResponse response, @PathVariable String nomePrograma, @PathVariable String nomeTurma, @PathVariable String dataInicio,
			@PathVariable String dataFim) throws IOException, ParseException {
		InvestimentoProgFormacaoVo investimentoProgFormacaoVo = investService.popularCardsSuperiores(nomePrograma,
				nomeTurma);
		
		LocalDate dataFormatadaInicio = dataFormat.dataFormatada(dataInicio);
		LocalDate dataFormatadaFim = dataFormat.dataFormatada(dataFim);
		
		InvestimentoProgFormacaoVo investimento = service.popularCards(dataFormatadaInicio, dataFormatadaFim, nomePrograma, nomeTurma);
		
		investimentoProgFormacaoVo.setInvestParticipantesPeriodoSelecionado(investimento.getInvestParticipantesPeriodoSelecionado());
		investimentoProgFormacaoVo.setInvestInstrutoresPeriodoSelecionado(investimento.getInvestInstrutoresPeriodoSelecionado());
		investimentoProgFormacaoVo.setInvestTotalPeriodoSelecionado(investimento.getInvestTotalPeriodoSelecionado());

		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=Investimentos.xlsx");
		ByteArrayInputStream stream = excel.excelInvestimentoProgFormacao(investimentoProgFormacaoVo);
		IOUtils.copy(stream, response.getOutputStream());
	}

}
