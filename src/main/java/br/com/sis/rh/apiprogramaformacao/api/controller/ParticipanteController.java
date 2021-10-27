package br.com.sis.rh.apiprogramaformacao.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.core.service.ParticipanteService;

@RestController
@RequestMapping("/api/participante")
public class ParticipanteController {
	
	@Autowired
    private ParticipanteService participanteService;

	@GetMapping
    public ResponseEntity<List<Participante>> getPadrao(){
        List<Participante> listaParticipante = participanteService.todosParticipantes();

        return ResponseEntity.ok(listaParticipante);
    }
}
