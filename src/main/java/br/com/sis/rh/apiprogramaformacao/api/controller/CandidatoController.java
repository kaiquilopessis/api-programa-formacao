package br.com.sis.rh.apiprogramaformacao.api.controller;

import br.com.sis.rh.apiprogramaformacao.api.model.Candidato;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CandidatoDto;
import br.com.sis.rh.apiprogramaformacao.core.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    @GetMapping
    public ResponseEntity<List<CandidatoDto>> getPadrao(){
        List<Candidato> listaCandidatos = candidatoService.todosCandidatos();
        List<CandidatoDto> listaDto = CandidatoDto.converterListaParaVo(listaCandidatos);

        return ResponseEntity.ok(listaDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidatoDto> getById(@PathVariable Long id){
        Candidato candidato = candidatoService.buscaPorId(id);
        CandidatoDto candidatoDto = CandidatoDto.converterParaDto(candidato);

        return ResponseEntity.ok(candidatoDto);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<CandidatoDto> getByNome(@PathVariable String nome){
        Candidato candidato = (Candidato) candidatoService.buscaPorNome(nome);
        CandidatoDto candidatoDto = CandidatoDto.converterParaDto(candidato);

        return ResponseEntity.ok(candidatoDto);
    }

    @GetMapping("/programa/{programa}")
    public ResponseEntity<CandidatoDto> getByPrograma(@PathVariable String programa){
        Candidato candidato = (Candidato) candidatoService.buscaPorPrograma(programa);
        CandidatoDto candidatoDto = CandidatoDto.converterParaDto(candidato);

        return ResponseEntity.ok(candidatoDto);
    }

    @GetMapping("/turma/{turma}")
    public ResponseEntity<CandidatoDto> getByTurma(@PathVariable String turma){
        Candidato candidato = (Candidato) candidatoService.buscaPorTurma(turma);
        CandidatoDto candidatoDto = CandidatoDto.converterParaDto(candidato);

        return ResponseEntity.ok(candidatoDto);
    }


}
