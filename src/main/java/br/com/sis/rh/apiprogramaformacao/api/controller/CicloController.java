package br.com.sis.rh.apiprogramaformacao.api.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import br.com.sis.rh.apiprogramaformacao.api.vo.form.CicloProgressivaForm;
import br.com.sis.rh.apiprogramaformacao.core.service.ConclusaoService;

@RestController
@RequestMapping("/api/conclusao")
public class CicloController {

	@Autowired
	ConclusaoService conclusaoService;

	@GetMapping("/{cpf}")
	public List<CicloDto> listaConclusoes (@PathVariable String cpf){
		return conclusaoService.listarConclusoes(cpf);
	}

	@GetMapping
	public List<RemuneracaoProgramaDto> listarRemuneracao() {
		return conclusaoService.listarRemuneracao();
	}

	@PostMapping("/registrocicloprogressivo/{cpf}")
	public ResponseEntity<CicloDto> registroProgressivo (@PathVariable String cpf ,
			@ModelAttribute CicloProgressivaForm conclusaoProgressivaForm,
			UriComponentsBuilder uriComponentsBuilder) throws IOException{
		return conclusaoService.registrarCicloProgressivo(cpf, conclusaoProgressivaForm, uriComponentsBuilder);
	}

	@PostMapping("/registrociclofinal/{cpf}")
	public ResponseEntity<CicloFinalDto> registroFinal(@PathVariable String cpf, @ModelAttribute CicloFinalForm conclusaoFinalForm,
			UriComponentsBuilder uriComponentsBuilder) {
		return conclusaoService.registrarCicloFinal(cpf, conclusaoFinalForm, uriComponentsBuilder);
	}
}


