package br.com.sis.rh.apiprogramaformacao.api.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sis.rh.apiprogramaformacao.api.vo.RelatorioAvaliacoesVo;

@RestController
@RequestMapping("/api/relatorio-avaliacao")
@CrossOrigin
public class RelatorioAvaliacaoController {

	@GetMapping
	public RelatorioAvaliacoesVo informacoesGeraisDasAvaliacoes() {
		RelatorioAvaliacoesVo relatorioAvaliacoesVo = new RelatorioAvaliacoesVo(8.5, 7.5, 6.75, 9.5, 6.75, 3, "Ruby", "Ruby 01");
		
		return relatorioAvaliacoesVo;
	}
	
}
