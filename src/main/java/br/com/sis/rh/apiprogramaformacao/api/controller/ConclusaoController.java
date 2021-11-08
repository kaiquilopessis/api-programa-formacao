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

import br.com.sis.rh.apiprogramaformacao.api.vo.RelatorioConclusaoVO;
import br.com.sis.rh.apiprogramaformacao.core.service.ConclusaoService;
import br.com.sis.rh.apiprogramaformacao.core.service.ExcelConclusaoService;
import br.com.sis.rh.apiprogramaformacao.core.service.PDFConclusaoService;

// url criado para (/conclusões)
@RestController
@RequestMapping("/conclusoes")
@CrossOrigin
public class ConclusaoController {

	// Injetando a service de conclusão
	@Autowired
	private ConclusaoService conclusaoService;
	
	@Autowired
	private ExcelConclusaoService excelConclusaoService;

	// Buscando a url  com turma, formação e escopo para popular os cards
	@GetMapping("/formacao={formacao}/turma={turma}/escopo={escopo}")
	public RelatorioConclusaoVO listaParticipantesAtivo(@PathVariable String formacao, @PathVariable String turma,
			@PathVariable String escopo) {
		RelatorioConclusaoVO conclusao = conclusaoService.popularCards(formacao, turma);
		
		return conclusao;
	}
	
	// Geração do pdf
	@GetMapping("/formacao={formacao}/turma={turma}/pdf")
	public void downloadPDF(HttpServletResponse response, @PathVariable String formacao, @PathVariable String turma) throws DocumentException, IOException {
        response.setContentType("application/pdf");
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=RelatorioConclusão.pdf";
        response.setHeader(headerKey, headerValue);
         
        RelatorioConclusaoVO conclusaoVO = conclusaoService.popularCards(formacao, turma);
         
        PDFConclusaoService exporter = new PDFConclusaoService(conclusaoVO);
        exporter.export(response);
	}
	
	// Geração do xlsx
	@GetMapping("/formacao={formacao}/turma={turma}/xlsx")
	public void downloadXLSX(HttpServletResponse response, @PathVariable String formacao, @PathVariable String turma) throws IOException {
		RelatorioConclusaoVO conclusaoVo = conclusaoService.popularCards(formacao, turma);
		
		response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=RelatorioConclusão.xlsx");
        ByteArrayInputStream stream = excelConclusaoService.gerarExcelConclusao(conclusaoVo);
        IOUtils.copy(stream, response.getOutputStream());
	}
}
