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

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.RelatorioAluraVo;
import br.com.sis.rh.apiprogramaformacao.core.service.AluraService;
import br.com.sis.rh.apiprogramaformacao.core.service.ExcelServiceAlura;
import br.com.sis.rh.apiprogramaformacao.core.service.PDFServiceAlura;

/**
 * Classe onde estão criados os endpoints referente
 * a tela de relatórios da Alura
 */

@RestController
@RequestMapping("/api/relatorio-alura")
@CrossOrigin
public class RelatorioAluraController {
	
	@Autowired
	private AluraService aluraService;
	
	@Autowired
	private ExcelServiceAlura excelServiceAlura;
	
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
	public RelatorioAluraVo popularCards(@PathVariable String formacao, @PathVariable String turma, @PathVariable String escopo) {
		RelatorioAluraVo aluraVo = aluraService.popularCards(formacao, turma);
		return aluraVo;
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
		RelatorioAluraVo aluraVo = aluraService.popularCards(formacao, turma);
		
		response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=RelatorioAlura.xlsx");
        ByteArrayInputStream stream = excelServiceAlura.gerarRelatorioAlura(aluraVo);
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
        String headerValue = "attachment; filename=RelatorioAlura.pdf";
        response.setHeader(headerKey, headerValue);
         
        RelatorioAluraVo aluraVo = aluraService.popularCards(formacao, turma);
         
        PDFServiceAlura exporter = new PDFServiceAlura(aluraVo);
        exporter.export(response);
         
    }
}
