package br.com.sis.rh.apiprogramaformacao.api.controller;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FiltragemInstrutorDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.ParametrosFiltroInstrutorForm;
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

//    @GetMapping()
//    public List<FiltragemInstrutorDto> mostrarDados(){
//        return instrutorService.listagemFiltroInstrutorTodos();
//    }
//
//    @PostMapping()
//    public List<FiltragemInstrutorDto> mostrarFiltros(@RequestBody ParametrosFiltroInstrutorForm form){
//        return instrutorService.listagemFiltroInstrutor(form.getParametroNomeInstrutor(), form.getParametroNomeFormacao(), form.getParametroNomeTurma(), form.getParametroValorHora());
//    }


    }
