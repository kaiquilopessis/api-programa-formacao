package br.com.sis.rh.apiprogramaformacao.api.controller;

import br.com.sis.rh.apiprogramaformacao.api.model.Candidato;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CandidatoController {
	
	@RequestMapping("/candidato")
	public String NomeCandidato() {
		Candidato candidato = new Candidato();
		return candidato.getNome();
	
    }
}