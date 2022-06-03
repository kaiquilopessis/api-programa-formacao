package br.com.sis.rh.apiprogramaformacao.api.controller.investimentos;

import br.com.sis.rh.apiprogramaformacao.api.openApi.FolhaContollerOpenApi;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CpfParticipanteNomeDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FiltragemFolhaDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.FolhaForm;
import br.com.sis.rh.apiprogramaformacao.core.service.informacoesgerais.ParticipanteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/investimento-folha")
@CrossOrigin
public class FolhaController implements FolhaContollerOpenApi {

    @Autowired
    private ParticipanteService participanteService;


    @Override
    @GetMapping("/{nomePrograma}/{nomeTurma}") //indicar que será um parametro dinamico (flexivel)
    public List<FiltragemFolhaDto> mostrarFiltros(@PathVariable String nomePrograma, @PathVariable String nomeTurma){
        return participanteService.listagemFiltroFolha(nomePrograma, nomeTurma);
    }

    @Override
    @PostMapping
    public void salvarInvestimentos(@RequestBody FolhaForm folhaForm){
        participanteService.cadastrar(folhaForm);
    }

    @Override
    @GetMapping("/participantes/{nomePrograma}/{nomeTurma}") //indicar que será um parametro dinamico (flexivel)
    public List<CpfParticipanteNomeDto> mostrarParticipantes(@PathVariable String nomePrograma, @PathVariable String nomeTurma){
        return participanteService.listagemParticipantes(nomePrograma, nomeTurma);
    }


}
