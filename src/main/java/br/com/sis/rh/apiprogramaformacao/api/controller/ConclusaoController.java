package br.com.sis.rh.apiprogramaformacao.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sis.rh.apiprogramaformacao.api.vo.ConclusaoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.ConclusaoFinalForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.ConclusaoProgressivaForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.RemuneracaoProgramaDto;
import br.com.sis.rh.apiprogramaformacao.core.service.ConclusaoService;

@RestController
@RequestMapping("/conclusoes")
public class ConclusaoController {

	@Autowired
	ConclusaoService conclusaoService;
	
	@GetMapping("/{cpf}")
	public List<ConclusaoDto> listaConclusoes (@PathVariable String cpf){
		return conclusaoService.listarConclusoes(cpf);
	}
	
	@GetMapping
	public List<RemuneracaoProgramaDto> listarRemuneracao() {
		return conclusaoService.listarRemuneracao();
	}
	
	@PostMapping("/registrocicloprogressivo/{cpf}")
	public ResponseEntity<ConclusaoDto> registroProgressivo (@PathVariable String cpf ,
			@RequestBody ConclusaoProgressivaForm conclusaoProgressivaForm, 
			UriComponentsBuilder uriComponentsBuilder){
		return conclusaoService.registrarCicloProgressivo(cpf, conclusaoProgressivaForm, uriComponentsBuilder);
	}
	
	@PostMapping("/registrociclofinal/{cpf}")
	public ResponseEntity<ConclusaoDto> registroFinal(@PathVariable String cpf, @RequestBody ConclusaoFinalForm conclusaoFinalForm,
			UriComponentsBuilder uriComponentsBuilder) {
		return conclusaoService.registrarCicloFinal(cpf, conclusaoFinalForm, uriComponentsBuilder);
	}
}
	

