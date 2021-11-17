package br.com.sis.rh.apiprogramaformacao.api.controller;

<<<<<<<< HEAD:src/main/java/br/com/sis/rh/apiprogramaformacao/api/controller/CicloController.java
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CicloDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CicloFinalDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.RemuneracaoProgramaDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.CicloFinalForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.CicloProgressivoForm;
import br.com.sis.rh.apiprogramaformacao.core.service.CicloService;
========
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.RelatorioConclusaoVO;
import br.com.sis.rh.apiprogramaformacao.core.service.ConclusaoService;
import br.com.sis.rh.apiprogramaformacao.core.service.ExcelConclusaoService;
import br.com.sis.rh.apiprogramaformacao.core.service.PDFConclusaoService;
import org.apache.commons.compress.utils.IOUtils;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
>>>>>>>> 4122612e6506c48f1ada3c5cb2bff90981197aaf:src/main/java/br/com/sis/rh/apiprogramaformacao/api/controller/ConclusaoController.java

// url criado para (/conclusões)
@RestController
<<<<<<<< HEAD:src/main/java/br/com/sis/rh/apiprogramaformacao/api/controller/CicloController.java
@RequestMapping("/api/conclusao")
public class CicloController {
========
@RequestMapping("/api/conclusoes")
@CrossOrigin
public class ConclusaoController {
>>>>>>>> 4122612e6506c48f1ada3c5cb2bff90981197aaf:src/main/java/br/com/sis/rh/apiprogramaformacao/api/controller/ConclusaoController.java

	// Injetando a service de conclusão
	@Autowired
<<<<<<<< HEAD:src/main/java/br/com/sis/rh/apiprogramaformacao/api/controller/CicloController.java
	CicloService conclusaoService;

	@GetMapping("/{cpf}")
	public List<CicloDto> listaConclusoes (@PathVariable String cpf){
		return conclusaoService.listarConclusoes(cpf);
	}
========
	private ConclusaoService conclusaoService;
	
	@Autowired
	private ExcelConclusaoService excelConclusaoService;
>>>>>>>> 4122612e6506c48f1ada3c5cb2bff90981197aaf:src/main/java/br/com/sis/rh/apiprogramaformacao/api/controller/ConclusaoController.java

	// Buscando a url  com turma, formação e escopo para popular os cards
	@GetMapping("/formacao={formacao}/turma={turma}/escopo={escopo}")
	public RelatorioConclusaoVO listaParticipantesAtivo(@PathVariable String formacao, @PathVariable String turma,
			@PathVariable String escopo) {
		RelatorioConclusaoVO conclusao = conclusaoService.popularCards(formacao, turma);
		
		return conclusao;
	}
	
<<<<<<<< HEAD:src/main/java/br/com/sis/rh/apiprogramaformacao/api/controller/CicloController.java
	@GetMapping("/download/{id}")
	public ResponseEntity<ByteArrayResource> downloadComprovante(@PathVariable Long id) {
		return conclusaoService.download(id);
		
	}
	@PostMapping("/registrocicloprogressivo/{cpf}")
	public ResponseEntity<CicloDto> registroProgressivo (@PathVariable String cpf ,
			@ModelAttribute CicloProgressivoForm conclusaoProgressivaForm,
			UriComponentsBuilder uriComponentsBuilder){
		return conclusaoService.registrarCicloProgressivo(cpf, conclusaoProgressivaForm, uriComponentsBuilder);
	}

	@PostMapping("/registrociclofinal/{cpf}")
	public ResponseEntity<CicloFinalDto> registroFinal(@PathVariable String cpf, @ModelAttribute CicloFinalForm conclusaoFinalForm,
			UriComponentsBuilder uriComponentsBuilder){
		return conclusaoService.registrarCicloFinal(cpf, conclusaoFinalForm, uriComponentsBuilder);
========
	// Geração do pdf
	@GetMapping("/formacao={formacao}/turma={turma}/pdf")
	public void downloadPDF(HttpServletResponse response, @PathVariable String formacao, @PathVariable String turma)
			throws DocumentException, IOException {
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
	public void downloadXLSX(HttpServletResponse response, @PathVariable String formacao, @PathVariable String turma)
			throws IOException {
		RelatorioConclusaoVO conclusaoVo = conclusaoService.popularCards(formacao, turma);
		
		response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=RelatorioConclusão.xlsx");
        ByteArrayInputStream stream = excelConclusaoService.gerarExcelConclusao(conclusaoVo);
        IOUtils.copy(stream, response.getOutputStream());
>>>>>>>> 4122612e6506c48f1ada3c5cb2bff90981197aaf:src/main/java/br/com/sis/rh/apiprogramaformacao/api/controller/ConclusaoController.java
	}
}
