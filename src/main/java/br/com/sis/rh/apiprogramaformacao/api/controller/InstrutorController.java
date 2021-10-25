package br.com.sis.rh.apiprogramaformacao.api.controller;


import br.com.sis.rh.apiprogramaformacao.api.model.Candidato;
import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CandidatoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.InstrutorDto;
import br.com.sis.rh.apiprogramaformacao.core.service.InstrutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/instrutor")
public class InstrutorController {

        @Autowired
        private InstrutorService instrutorService;

        @GetMapping
        public ResponseEntity<List<InstrutorDto>> getPadrao(){
            List<Instrutor> listaInstrutores = instrutorService.todosInstrutores();
            List<InstrutorDto> listaDto = InstrutorDto.converterListaParaDto(listaInstrutores);

            return ResponseEntity.ok(listaDto);
        }


        @GetMapping("/{cpf}")
        public ResponseEntity<InstrutorDto> getByCpf(@PathVariable String cpf){
            Instrutor instrutor = instrutorService.buscaPorCpf(cpf);
            InstrutorDto instrutorVo = InstrutorDto.converterParaVo(instrutor);

            return ResponseEntity.ok(instrutorVo);
        }


    @GetMapping("/nome/{nome}")
    public ResponseEntity<InstrutorDto> getByNome(@PathVariable String nome){
        Instrutor instrutor = (Instrutor) instrutorService.buscaPorNome(nome);
        InstrutorDto instrutorDto = InstrutorDto.converterParaDto(instrutor);

        return ResponseEntity.ok(instrutorDto);
    }

    @GetMapping("/programa/{programa}")
    public ResponseEntity<InstrutorDto> getByPrograma(@PathVariable String programa){
        Instrutor instrutor = (Instrutor) instrutorService.buscaPorPrograma(programa);
        InstrutorDto instrutorDto = InstrutorDto.converterParaDto(instrutor);

        return ResponseEntity.ok(instrutorDto);
    }

    @GetMapping("/turma/{turma}")
    public ResponseEntity<InstrutorDto> getByTurma(@PathVariable String turma){
        Instrutor instrutor = (Instrutor) instrutorService.buscaPorTurma(turma);
        InstrutorDto instrutorDto = CandidatoDto.converterParaDto(candidato);

        return ResponseEntity.ok(instrutorDto);
    }

    }
