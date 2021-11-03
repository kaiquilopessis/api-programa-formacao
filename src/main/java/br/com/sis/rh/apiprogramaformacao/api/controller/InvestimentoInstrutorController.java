package br.com.sis.rh.apiprogramaformacao.api.controller;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FiltragemInstrutorDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.ParametrosFiltroInstrutorForm;
import br.com.sis.rh.apiprogramaformacao.core.service.InvestimentoInstrutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/investimento-instrutor")
public class InvestimentoInstrutorController {

    @Autowired
    private InvestimentoInstrutorService investimentoInstrutorService;

    @GetMapping()
    public List<FiltragemInstrutorDto> mostrarDados(){
        return investimentoInstrutorService.listagemFiltroInstrutorTodos();
    }

    @PostMapping()
    public List<FiltragemInstrutorDto> mostrarFiltros(@RequestBody ParametrosFiltroInstrutorForm form){
        return investimentoInstrutorService.listagemFiltroInstrutor(form.getParametroNomeInstrutor(), form.getParametroNomeFormacao(), form.getParametroNomeTurma(), form.getParametroValorHora());
    }

}
