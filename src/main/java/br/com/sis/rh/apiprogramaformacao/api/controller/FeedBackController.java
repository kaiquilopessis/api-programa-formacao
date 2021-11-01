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

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FeedBackDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.FeedBackForm;
import br.com.sis.rh.apiprogramaformacao.core.service.FeedBackService;

@RestController
@RequestMapping("/feedback")
public class FeedBackController {

	@Autowired
	private FeedBackService feedBackService;

	@GetMapping("/{cpf}")
	public List<FeedBackDto> listarFeedBacks(@PathVariable String cpf) {
		return feedBackService.listar(cpf);
	}


	@PostMapping("/novo/{cpf}")
	public ResponseEntity<FeedBackDto> cadastrarFeed(@PathVariable String cpf, @RequestBody FeedBackForm feedBackForm,
			UriComponentsBuilder uriComponentsBuilder) {

		return feedBackService.cadastrar(cpf, feedBackForm, uriComponentsBuilder);

	}

	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<FeedBackDto> deletarFeed(@PathVariable Long id) {
		return feedBackService.deletar(id);
	}

}
