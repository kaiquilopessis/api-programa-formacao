package br.com.sis.rh.apiprogramaformacao.api.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Esta Classe é referente a tela de relatorios investimento
 * Esta classe é responsavel por processar as requisições e gerar respostas
 */

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
	@Autowired
	private ExcelServiceInvestimento excel;

	// Respostas dos cards superiores contidos na pagina "Antes do filtro de data"
	@GetMapping("/investimentosPrograma/{nomePrograma}/{nomeTurma}")
	public InvestimentoProgFormacaoVo investimentosPrograma(@PathVariable String nomePrograma,
			@PathVariable String nomeTurma) {

		InvestimentoProgFormacaoVo investParticipantes = investService.popularCardsSuperiores(nomePrograma, nomeTurma);

		return investParticipantes;

	}

	// Respostas dos cards inferiores, metodo usado para retornar os valores após
	// realizar a seleção das datas
	@GetMapping("/investimentoPeriodoSelecionado/{dataInicio}/{dataFim}")
	public InvestimentoProgFormacaoVo investDoPeriodoPrograma(@PathVariable String dataInicio,
			@PathVariable String dataFim, @PathVariable String nomePrograma, @PathVariable String nomeTurma)
			throws ParseException {

		LocalDate dataFormatadaInicio = dataFormat.dataFormatada(dataInicio);
		LocalDate dataFormatadaFim = dataFormat.dataFormatada(dataFim);

		InvestimentoProgFormacaoVo investimentoPrograma = service.popularCards(dataFormatadaInicio, dataFormatadaFim,
				"Turma II", "Turma I");

		return investimentoPrograma;
	}

	@GetMapping("/pdf")
	public void downloadPDF(HttpServletResponse response, @PathVariable String nomePrograma,
			@PathVariable String nomeTurma) throws DocumentException, IOException {
		response.setContentType("application/pdf");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=RelatorioAlura.pdf";
		response.setHeader(headerKey, headerValue);

		InvestimentoProgFormacaoVo investimentoSemFiltroData = investService.popularCardsSuperiores(nomePrograma,
				nomeTurma);

		PDFServiceInvestimento exporter = new PDFServiceInvestimento(
				investimentoSemFiltroData);
		exporter.export(response);

	}

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
