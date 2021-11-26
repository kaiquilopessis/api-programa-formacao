package br.com.sis.rh.apiprogramaformacao.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FeedBackDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.FeedBackForm;
import br.com.sis.rh.apiprogramaformacao.core.service.FeedBackService;

@RestController
@RequestMapping("/api/feedback")
public class FeedBackController {
	/**
	 * Injeção da classe FeedbackService */
	@Autowired 
	private FeedBackService feedBackService;
	/**
	 * Endereço da APi para listar os feedBacks do participante selecionado de acordo com o CPF.*/
	@GetMapping("/{cpf}")
	public List<FeedBackDto> listarFeedBacks(@PathVariable String cpf) {
		return feedBackService.listar(cpf);
	}
	/** 
	 * Endereço da api para baixar o arquivo direto do banco*/
	@GetMapping("/download/{id}")
	public ResponseEntity<ByteArrayResource> downloadDisc(@PathVariable Long id) {
		return feedBackService.download(id);
		
	}
	
	/**
	 *  Endereço da API para salvar novo feedback , de acordo com o CPF.*/

	@PostMapping("/novo/{cpf}")
	public ResponseEntity<FeedBackDto> cadastrarFeed(@PathVariable String cpf, @ModelAttribute FeedBackForm feedBackForm,
			UriComponentsBuilder uriComponentsBuilder){
		return feedBackService.cadastrar(cpf, feedBackForm, uriComponentsBuilder);

	}
	/**
	 * Endereço da API para excluir o feedback, de acordo com o CPF*/
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<FeedBackDto> deletarFeed(@PathVariable Long id) {
		return feedBackService.deletar(id);
	}

}