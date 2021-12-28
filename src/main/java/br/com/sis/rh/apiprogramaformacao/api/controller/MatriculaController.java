package br.com.sis.rh.apiprogramaformacao.api.controller;

import br.com.sis.rh.apiprogramaformacao.api.model.LoginAD;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CandidatoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.LoginADDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.LoginADForm;
import br.com.sis.rh.apiprogramaformacao.core.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/matricula")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @GetMapping
    private List<LoginADDto> listaMatriculas(){
        return matriculaService.buscarTodos();
    }

    @PostMapping
    private ResponseEntity<LoginADDto> autorizaMatricula(@RequestBody LoginADForm form, UriComponentsBuilder uriBuilder){
        LoginAD matricula = matriculaService.criaMatricula(form);

        URI uri = uriBuilder.path("api/matricula/{matricula}").buildAndExpand(matricula.getMatricula()).toUri();
        return ResponseEntity.created(uri).body(new LoginADDto(matricula));
    }
}
