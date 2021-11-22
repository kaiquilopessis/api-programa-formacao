package br.com.sis.rh.apiprogramaformacao.api.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.compress.utils.IOUtils;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.RelatorioAvaliacoesVo;
import br.com.sis.rh.apiprogramaformacao.core.service.AvaliacaoService;
import br.com.sis.rh.apiprogramaformacao.core.service.ExcelServiceAvaliacao;
import br.com.sis.rh.apiprogramaformacao.core.service.PDFServiceAvaliacao;


/**
 * Classe com os endpoints referente a tela
 * de relatórios das avaliações dos participantes
 */

@RestController
@RequestMapping("/api/relatorio-avaliacao")
@CrossOrigin
public class RelatorioAvaliacaoController {

	@Autowired
	private AvaliacaoService avaliacaoService;
	
	@Autowired
	private ExcelServiceAvaliacao excelService;
	
	/**
	 * Endpoint para popular os cards
	 * 
	 * @param formacao, nome do programa de formação
	 * @param turma, turma do programa de formação
	 * @param escopo, qual relatório foi selecionado
	 * (Alura, Avaliações, Conclusões ou Investimentos)
	 * @return aluraVo com os campos populados
	 */
	
	@GetMapping("/formacao={formacao}/turma={turma}/escopo={escopo}")
	public RelatorioAvaliacoesVo informacoesGeraisDasAvaliacoes(@PathVariable String formacao, @PathVariable String turma, @PathVariable String escopo) {
		return avaliacaoService.popularCards(formacao, turma);
	}
	
	/**
	 * Endpoint para fazer o download do relatório xlsx
	 * 
	 * @param response
	 * @param formacao, nome do programa de formação
	 * @param turma, turma do programa de formação
	 * @throws IOException
	 */
	
	@GetMapping("/formacao={formacao}/turma={turma}/xlsx")
	public void downloadXLSX(HttpServletResponse response, @PathVariable String formacao, @PathVariable String turma) throws IOException {
		RelatorioAvaliacoesVo avaliacaoVo = avaliacaoService.popularCards(formacao, turma);
		
		response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=RelatorioAvaliacao.xlsx");
        ByteArrayInputStream stream = excelService.gerarRelatorioAvaliacoes(avaliacaoVo);
        IOUtils.copy(stream, response.getOutputStream());
	}
	
	/**
	 * Endpoint para download do relatório pdf
	 * 
	 * @param response
	 * @param formacao, nome do programa de formação
	 * @param turma, turma do programa de formação
	 * @throws DocumentException
	 * @throws IOException
	 */
	
	@GetMapping("/formacao={formacao}/turma={turma}/pdf")
    public void downloadPDF(HttpServletResponse response, @PathVariable String formacao, @PathVariable String turma) throws DocumentException, IOException {
        response.setContentType("application/pdf");
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=RelatorioAvaliacao.pdf";
        response.setHeader(headerKey, headerValue);
         
        RelatorioAvaliacoesVo avaliacoesVo = avaliacaoService.popularCards(formacao, turma);
         
        PDFServiceAvaliacao exporter = new PDFServiceAvaliacao(avaliacoesVo);
        exporter.export(response);
    }
}
