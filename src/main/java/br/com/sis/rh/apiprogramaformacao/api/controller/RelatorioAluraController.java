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

import br.com.sis.rh.apiprogramaformacao.api.vo.RelatorioAluraVo;
import br.com.sis.rh.apiprogramaformacao.core.service.AluraService;
import br.com.sis.rh.apiprogramaformacao.core.service.ExcelServiceAlura;
import br.com.sis.rh.apiprogramaformacao.core.service.PDFServiceAlura;

@RestController
@RequestMapping("/api/relatorio-alura")
@CrossOrigin
public class RelatorioAluraController {
	
	@Autowired
	private AluraService aluraService;
	
	@Autowired
	private ExcelServiceAlura excelServiceAlura;
	
	@GetMapping("/formacao={formacao}/turma={turma}/escopo={escopo}")
	public RelatorioAluraVo popular(@PathVariable String formacao, @PathVariable String turma, @PathVariable String escopo) {
		RelatorioAluraVo aluraVo = aluraService.popularCards(formacao, turma);
		return aluraVo;
	}
	
//	@GetMapping
//	public RelatorioAluraVo informacoesGeraisAcompanhamentoAlura() {
//		RelatorioAluraVo aluraVo = aluraService.popularCards();
//		return aluraVo;
//	}
	
	@GetMapping("/xlsx")
	public void downloadXLSX(HttpServletResponse response) throws IOException {
		RelatorioAluraVo aluraVo = aluraService.popularVo();
		
		response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=RelatorioAlura.xlsx");
        ByteArrayInputStream stream = excelServiceAlura.gerarRelatorioAlura(aluraVo);
        IOUtils.copy(stream, response.getOutputStream());
	}
	
	@GetMapping("/pdf")
    public void downloadPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=RelatorioAlura.pdf";
        response.setHeader(headerKey, headerValue);
         
        RelatorioAluraVo aluraVo = aluraService.popularVo();
         
        PDFServiceAlura exporter = new PDFServiceAlura(aluraVo);
        exporter.export(response);
         
    }
}
