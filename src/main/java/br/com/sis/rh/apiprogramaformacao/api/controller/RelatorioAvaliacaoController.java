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

import br.com.sis.rh.apiprogramaformacao.api.vo.RelatorioAvaliacoesVo;
import br.com.sis.rh.apiprogramaformacao.core.service.AvaliacaoService;
import br.com.sis.rh.apiprogramaformacao.core.service.ExcelServiceAvaliacao;
import br.com.sis.rh.apiprogramaformacao.core.service.PDFServiceAvaliacao;

@RestController
@RequestMapping("/api/relatorio-avaliacao")
@CrossOrigin
public class RelatorioAvaliacaoController {

	@Autowired
	private AvaliacaoService avaliacaoService;
	
	@Autowired
	private ExcelServiceAvaliacao excelService;
	
	@GetMapping("/formacao={formacao}/turma={turma}/escopo={escopo}")
	public RelatorioAvaliacoesVo informacoesGeraisDasAvaliacoes(@PathVariable String formacao, @PathVariable String turma, @PathVariable String escopo) {
		RelatorioAvaliacoesVo avaliacoesVo = avaliacaoService.popularCards(formacao, turma);
		
		return avaliacoesVo;
	}
	
	@GetMapping("/xlsx")
	public void downloadXLSX(HttpServletResponse response) throws IOException {
		RelatorioAvaliacoesVo avaliacaoVo = avaliacaoService.popularVo();
		
		response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=RelatorioAvaliacao.xlsx");
        ByteArrayInputStream stream = excelService.gerarRelatorioAvaliacoes(avaliacaoVo);
        IOUtils.copy(stream, response.getOutputStream());
	}
	
	@GetMapping("/pdf")
    public void downloadPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=RelatorioAvaliacao.pdf";
        response.setHeader(headerKey, headerValue);
         
        RelatorioAvaliacoesVo avaliacoesVo = avaliacaoService.popularVo();
         
        PDFServiceAvaliacao exporter = new PDFServiceAvaliacao(avaliacoesVo);
        exporter.export(response);
         
    }
	
}
