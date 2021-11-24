package br.com.sis.rh.apiprogramaformacao.api.controller;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CpfParticipanteNomeDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FiltragemFolhaDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.FolhaForm;
import br.com.sis.rh.apiprogramaformacao.core.service.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/investimento-folha")
@CrossOrigin
public class FolhaController {

    @Autowired
    private ParticipanteService participanteService;



    @GetMapping("/{nomePrograma}/{nomeTurma}") //indicar que será um parametro dinamico (flexivel)
    public List<FiltragemFolhaDto> mostrarFiltros(@PathVariable String nomePrograma, @PathVariable String nomeTurma){
        return participanteService.listagemFiltroFolha(nomePrograma, nomeTurma);
    }

    @PostMapping
    public void salvarInvestimentos(@RequestBody FolhaForm folhaForm){
        System.out.println(folhaForm.getCpf());
        participanteService.cadastrar(folhaForm);
    }

    @GetMapping("/participantes/{nomePrograma}/{nomeTurma}") //indicar que será um parametro dinamico (flexivel)
    public List<CpfParticipanteNomeDto> mostrarParticipantes(@PathVariable String nomePrograma, @PathVariable String nomeTurma){
        return participanteService.listagemParticipantes(nomePrograma, nomeTurma);
    }


}
