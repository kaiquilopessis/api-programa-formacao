package br.com.sis.rh.apiprogramaformacao.api.controller;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FiltragemFolhaDto;
import br.com.sis.rh.apiprogramaformacao.core.service.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/investimento-folha")
@CrossOrigin
public class FolhaController {

    @Autowired
    private ParticipanteService participanteService;

//    @GetMapping()
//    public List<FiltragemFolhaDto> mostrarDados(){
//        return participanteService.listagemFiltroFolhaTodos();
//    }

    @GetMapping("/{nomePrograma}/{nomeTurma}") //indicar que será um parametro dinamico (flexivel)
    public List<FiltragemFolhaDto> mostrarFiltros(@PathVariable String nomePrograma, @PathVariable String nomeTurma){
        return participanteService.listagemFiltroFolha(nomePrograma, nomeTurma);
    }

}
