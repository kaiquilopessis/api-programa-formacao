package br.com.sis.rh.apiprogramaformacao.api.controller;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CpfInstrutorNomeDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CpfParticipanteNomeDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FiltragemInstrutorDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.FolhaForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.InstrutorForm;
import br.com.sis.rh.apiprogramaformacao.core.service.InstrutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instrutor")
@CrossOrigin
public class InstrutorController {

    @Autowired
    private InstrutorService instrutorService;

    @GetMapping("/buscar-instrutor/{nomePrograma}/{nomeTurma}")
    public List<FiltragemInstrutorDto> mostrarDados(@PathVariable String nomePrograma, @PathVariable String nomeTurma){
        return instrutorService.listagemFiltroInstrutor(nomePrograma, nomeTurma);
    }

    @PostMapping
    public void salvarInvestimentos(@RequestBody InstrutorForm instrutorForm){
        System.out.println(instrutorForm.getCpf());
        instrutorService.cadastrar(instrutorForm);
    }

    @GetMapping("/instrutores/{nomePrograma}/{nomeTurma}") //indicar que será um parametro dinamico (flexivel)
    public List<CpfInstrutorNomeDto> mostrarInstrutores(@PathVariable String nomePrograma, @PathVariable String nomeTurma){
        return instrutorService.listagemInstrutores(nomePrograma, nomeTurma);
    }

    }
