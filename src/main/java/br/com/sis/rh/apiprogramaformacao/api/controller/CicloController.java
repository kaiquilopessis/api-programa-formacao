package br.com.sis.rh.apiprogramaformacao.api.controller;

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

@RestController
@RequestMapping("/api/ciclo")
public class CicloController {

	@Autowired
	CicloService conclusaoService;

	@GetMapping("/{cpf}")
	public List<CicloDto> listaConclusoes (@PathVariable String cpf){
		return conclusaoService.listarConclusoes(cpf);
	}

	@GetMapping
	public List<RemuneracaoProgramaDto> listarRemuneracao() {
		return conclusaoService.listarRemuneracao();
	}
	
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
	}
}


