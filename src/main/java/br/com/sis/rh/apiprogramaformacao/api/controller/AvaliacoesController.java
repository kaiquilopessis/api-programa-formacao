package br.com.sis.rh.apiprogramaformacao.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sis.rh.apiprogramaformacao.api.vo.AvaliacoesDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.AvaliacoesForm;
import br.com.sis.rh.apiprogramaformacao.core.service.AvaliacoesService;

@RestController
@RequestMapping("/api/avaliacoes")
public class AvaliacoesController {

	@Autowired
	private AvaliacoesService avaliacoesService;

	@GetMapping("/{cpf}")
	public List<AvaliacoesDto> listarNotas(@PathVariable String cpf) {
		return avaliacoesService.listarNotas(cpf);

	}

	@PostMapping("/novo/{cpf}")
	public ResponseEntity<AvaliacoesDto> cadastrar(@PathVariable String cpf, @RequestBody AvaliacoesForm avaliacoesForm,
			UriComponentsBuilder uriComponentsBuilder) {
		return avaliacoesService.cadastrar(cpf, avaliacoesForm, uriComponentsBuilder);
	}

	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<AvaliacoesDto> deletar(@PathVariable Long id) {
		return avaliacoesService.deletar(id);
}
}