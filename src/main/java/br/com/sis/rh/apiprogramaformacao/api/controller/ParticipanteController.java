package br.com.sis.rh.apiprogramaformacao.api.controller;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ParticipanteDto;
import br.com.sis.rh.apiprogramaformacao.core.service.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/participante")
public class ParticipanteController {

    @Autowired
    private ParticipanteService participanteService;

    @GetMapping("/{id}")
    public ResponseEntity<ParticipanteDto> mostrarParticipante(@PathVariable String cpf) {
        return ResponseEntity.ok(new ParticipanteDto(participanteService.buscaPorCpf(cpf)));

    }
}
