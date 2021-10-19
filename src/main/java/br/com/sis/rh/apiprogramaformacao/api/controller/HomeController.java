package br.com.sis.rh.apiprogramaformacao.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HomeController {

	@RequestMapping("/investimento-folha")
	public String InvestimentoFolha() {
		return "Página Investimento Folha";
	}
	
	@RequestMapping("/investimento-instrutor")
	public String InvestimentoInstrutor() {
		return "Página Investimento Instrutor";
	}
	
}
