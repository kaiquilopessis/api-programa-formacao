package br.com.sis.rh.apiprogramaformacao.api.controller;


import br.com.sis.rh.apiprogramaformacao.api.model.Remuneracao;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ListaRemuneracaoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.RemuneracaoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AtualizaRemuneracaoForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.RemuneracaoForm;
import br.com.sis.rh.apiprogramaformacao.core.service.RemuneracaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/remuneracao")
@CrossOrigin
public class RemuneracaoController {

    @Autowired
    private RemuneracaoService remuneracaoService;

    @GetMapping("/lista")
    public List<ListaRemuneracaoDto> listaRemuneracao(){
        return remuneracaoService.listaTodasRemuneracoes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RemuneracaoDto> exibeRemuneracao(@PathVariable long id){
        return ResponseEntity.ok(remuneracaoService.exibeRemuneracao(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<RemuneracaoDto> criaRemuneracao(@RequestBody RemuneracaoForm form, UriComponentsBuilder uriBuilder){

        Remuneracao remuneracao = remuneracaoService.cadastraRemuneracao(form);
        URI uri = uriBuilder.path("/api/remuneracao/{id}").buildAndExpand(remuneracao.getId()).toUri();

       return ResponseEntity.created(uri).body(new RemuneracaoDto(remuneracao));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<RemuneracaoDto> atualizarRemuneracao(@PathVariable Long id, @RequestBody AtualizaRemuneracaoForm form){
        Remuneracao remuneracao = remuneracaoService.atualizaRemuneracao(id, form);

        return ResponseEntity.ok().body(new RemuneracaoDto(remuneracao));
    }
}
