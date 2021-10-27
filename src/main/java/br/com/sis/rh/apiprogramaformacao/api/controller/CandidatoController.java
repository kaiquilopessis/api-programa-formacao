package br.com.sis.rh.apiprogramaformacao.api.controller;

import br.com.sis.rh.apiprogramaformacao.api.model.Candidato;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CandidatoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ListaCandidatoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AtualizaCandidatoForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.CandidatoForm;
import br.com.sis.rh.apiprogramaformacao.core.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/candidato")
@CrossOrigin
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    @GetMapping("/lista")
    public List<ListaCandidatoDto> listaCandidato(){

        return candidatoService.listaTodosDeUmaVaga();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidatoDto> mostrarCandidato(@PathVariable Long id){
        return ResponseEntity.ok(new CandidatoDto(candidatoService.buscaPorId(id)));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CandidatoDto> atualizarCandidato(@PathVariable Long id, @RequestBody AtualizaCandidatoForm form){

        Candidato candidato = candidatoService.atualizaCandidato(id, form);

        return ResponseEntity.ok().body(new CandidatoDto(candidato));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CandidatoDto> inserirCandidato(@RequestBody CandidatoForm form, UriComponentsBuilder uriBuilder){

        Candidato candidato = candidatoService.criaCandidato(form);

        URI uri = uriBuilder.path("/api/candidato/{id}").buildAndExpand(candidato.getId()).toUri();

        return ResponseEntity.created(uri).body(new CandidatoDto(candidato));
    }
}
