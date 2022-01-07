package br.com.sis.rh.apiprogramaformacao.api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sis.rh.apiprogramaformacao.api.model.LoginAD;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.LoginADDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.PerfilDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.LoginADForm;
import br.com.sis.rh.apiprogramaformacao.core.service.MatriculaService;

@RestController
@RequestMapping(value = "/api/matricula")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @GetMapping
    public List<LoginADDto> listaMatriculas(){
        return matriculaService.buscarTodos();
    }

    @GetMapping("/perfis")
    public List<PerfilDto> getPerfis (){
        return matriculaService.getPerfis();
    }

    @PostMapping
    public ResponseEntity<LoginADDto> autorizaMatricula(@RequestBody LoginADForm form, UriComponentsBuilder uriBuilder){
        LoginAD matricula = matriculaService.criaMatricula(form);

        URI uri = uriBuilder.path("api/matricula/{matricula}").buildAndExpand(matricula.getMatricula()).toUri();
        return ResponseEntity.created(uri).body(new LoginADDto(matricula));
    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity<LoginADDto> deletarMatricula(@PathVariable String matricula){

        return matriculaService.deletaMatricula(matricula);
    }
}
