package br.com.sis.rh.apiprogramaformacao.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sis.rh.apiprogramaformacao.core.model.Alura;
import br.com.sis.rh.apiprogramaformacao.core.repository.AluraRepository;

@RestController
@RequestMapping("/api/relatorio-alura")
@CrossOrigin
public class RelatorioAluraController {
	
	@Autowired
	private AluraRepository aluraRepository;
	
	@GetMapping
	public Alura informacoesGeraisAcompanhamentoAlura() {
		List<Alura> aluraVo = aluraRepository.buscarRegistroHoras();
		Alura alura = aluraVo.get(0);
		System.out.println("ID: " + alura.getId() + ", Qtd Horas: " + alura.getQtdHoras());
		return alura;
	}
}
