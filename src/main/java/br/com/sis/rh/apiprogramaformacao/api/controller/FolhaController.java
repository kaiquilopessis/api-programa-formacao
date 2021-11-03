package br.com.sis.rh.apiprogramaformacao.api.controller;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FiltragemFolhaDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.ParametrosFiltroFolhaForm;
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

    @GetMapping()
    public List<FiltragemFolhaDto> mostrarDados(){
        return participanteService.listagemFiltroFolhaTodos();
    }

    @PostMapping()
    public List<FiltragemFolhaDto> mostrarFiltros(@RequestBody ParametrosFiltroFolhaForm form){
        return participanteService.listagemFiltroFolha(form.getParametroNomeParticipante(), form.getParametroNomeFormacao(), form.getParametroNomeTurma(), form.getParametroBolsaAux());
    }

}
