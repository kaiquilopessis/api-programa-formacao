package br.com.sis.rh.apiprogramaformacao.api.controller;

import br.com.sis.rh.apiprogramaformacao.api.model.Candidato;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CandidatoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ListaCandidatoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AtualizaCandidatoForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.CandidatoForm;
import br.com.sis.rh.apiprogramaformacao.core.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/candidato")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    //Lista todos os candidatos do banco de dados
    @GetMapping("/lista")
    public List<ListaCandidatoDto> listaCandidato(){

        return candidatoService.listaTodosDeUmaVaga();
    }

    //Mostra todos os dados unicos de um candidato
    @GetMapping("/{id}")
    public ResponseEntity<CandidatoDto> mostrarCandidato(@PathVariable Long id){
        return ResponseEntity.ok(new CandidatoDto(candidatoService.buscaPorId(id)));
    }

    //Mostra todos os candidatos que participam de um processo seletivo especifico
    @GetMapping("/lista-do-processo/{id}")
    public List<ListaCandidatoDto> mostraListaCandidatoEmProcesso(@PathVariable Long id){
        return candidatoService.buscaCandidadoPorFormacao(id);
    }

    //Realiza a edição de um candidato
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CandidatoDto> atualizarCandidato(@PathVariable Long id, @ModelAttribute AtualizaCandidatoForm form) throws IOException {

        Candidato candidato = candidatoService.atualizaCandidato(id, form);

        return ResponseEntity.ok().body(new CandidatoDto(candidato));
    }

    //Cria um novo candidato e já linka ele a um processo-seletivo
    @PostMapping
    @Transactional
    public ResponseEntity<CandidatoDto> inserirCandidato(@ModelAttribute CandidatoForm form, UriComponentsBuilder uriBuilder) throws IOException {

        Candidato candidato = candidatoService.criaCandidato(form);

        URI uri = uriBuilder.path("/api/candidato/{id}").buildAndExpand(candidato.getId()).toUri();

        return ResponseEntity.created(uri).body(new CandidatoDto(candidato));
    }

    //Faz o download  do curriculo de um usuario registrado no banco de dados
    @GetMapping("/download-curriculo/{id}")
    public ResponseEntity<ByteArrayResource> downloadCurriculo(@PathVariable Long id){
        return candidatoService.downloadCurriculo(id);
    }

    //Faz o donwload do disc de um usuario registrado previamente no banco de dados
    @GetMapping("/download-disc/{id}")
    public ResponseEntity<ByteArrayResource> downloadDisc(@PathVariable Long id){
        return candidatoService.downloadDisc(id);
    }
}
