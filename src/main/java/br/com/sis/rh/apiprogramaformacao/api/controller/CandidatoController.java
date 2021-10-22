package br.com.sis.rh.apiprogramaformacao.api.controller;

import br.com.sis.rh.apiprogramaformacao.api.model.Candidato;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CandidatoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ListaCandidatoDto;
import br.com.sis.rh.apiprogramaformacao.core.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.ArrayList;
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
   // @PutMapping("/{id}")
    //public ResponseEntity<CadidatoForm> atualizarCandidato(Path)
}
