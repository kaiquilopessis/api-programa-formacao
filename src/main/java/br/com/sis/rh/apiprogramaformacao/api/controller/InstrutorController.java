package br.com.sis.rh.apiprogramaformacao.api.controller;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FiltragemInstrutorDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.SalarioInstrutorDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.ParametrosFiltroInstrutorForm;
import br.com.sis.rh.apiprogramaformacao.core.service.InstrutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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

    @GetMapping("/buscar-salario/{nomePrograma}/{nomeTurma}")
    public List<Double> mostrarSalario(@PathVariable String nomePrograma, @PathVariable String nomeTurma){
        return instrutorService.listagemSalarioInstrutor(nomePrograma, nomeTurma);
    }

    }
