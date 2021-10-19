package br.com.sis.rh.apiprogramaformacao.api.controller;


import br.com.sis.rh.apiprogramaformacao.api.model.RemuneracaoPrograma;
import br.com.sis.rh.apiprogramaformacao.core.repository.RemuneracaoProgramaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/remuneracao")
public class RemuneracaoController {

    @Autowired
    RemuneracaoProgramaRepository repository;

    @GetMapping
    public ResponseEntity<List<RemuneracaoPrograma>> getPadrao(){
        List<RemuneracaoPrograma> remuneracoes = repository.findAll();

        return ResponseEntity.ok(remuneracoes);
    }

}
