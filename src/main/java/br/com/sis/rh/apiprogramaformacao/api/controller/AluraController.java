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

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.AluraDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AluraForm;
import br.com.sis.rh.apiprogramaformacao.core.service.AluraService;

@RestController
@RequestMapping("/api/alura")
public class AluraController {

	// precisamos passar para o service os ifs de tratamento

	@Autowired
	private AluraService aluraService;

	@GetMapping("/{cpf}")
	public List<AluraDto> listaRegistros(@PathVariable String cpf) {
		return aluraService.listaRegistros(cpf);
	}

	@PostMapping("/novo/{cpf}")
	public ResponseEntity<AluraDto> cadastrar(@PathVariable String cpf, @RequestBody AluraForm aluraForm,
			UriComponentsBuilder uriComponentsBuilder) {
		return aluraService.cadastrar(cpf, aluraForm, uriComponentsBuilder);
	}

	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<AluraDto> deletar(@PathVariable Long id) {
		return aluraService.deletar(id);
	}
}
