package br.com.sis.rh.apiprogramaformacao.api.controller.cargos;


import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.sis.rh.apiprogramaformacao.api.model.cargos.Remuneracao;
import br.com.sis.rh.apiprogramaformacao.api.openApi.RemuneracaoControllerOpenApi;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CargosDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ListaRemuneracaoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.RemuneracaoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AtualizaRemuneracaoForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.RemuneracaoForm;
import br.com.sis.rh.apiprogramaformacao.core.service.cargos.RemuneracaoService;

@RestController
@RequestMapping("/api/remuneracao")
@CrossOrigin
public class RemuneracaoController implements RemuneracaoControllerOpenApi {

    @Autowired
    private RemuneracaoService remuneracaoService;

    //Lista todos os cargos cadastrados
    @GetMapping("/lista")
    @Override
    public List<ListaRemuneracaoDto> listaRemuneracao(){
        return remuneracaoService.listaTodasRemuneracoes();
    }

    //Visualiza um cargo presente no banco de dados
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<RemuneracaoDto> exibeRemuneracao(@PathVariable long id){
        return ResponseEntity.ok(remuneracaoService.exibeRemuneracao(id));
    }

    //Cria um novo cargo
    @PostMapping
    @Override
    @Transactional
    public ResponseEntity<RemuneracaoDto> criaRemuneracao(@RequestBody RemuneracaoForm form, UriComponentsBuilder uriBuilder){

        Remuneracao remuneracao = remuneracaoService.cadastraRemuneracao(form);
        URI uri = uriBuilder.path("/api/remuneracao/{id}").buildAndExpand(remuneracao.getId()).toUri();

       return ResponseEntity.created(uri).body(new RemuneracaoDto(remuneracao));
    }

    @GetMapping("/cargos")
    @Override
    public List<CargosDto> mostrarCargos(){
        return remuneracaoService.buscarCargos();
    }

    //Edita um cargo
    @PutMapping("/{id}")
    @Override
    @Transactional
    public ResponseEntity<RemuneracaoDto> atualizarRemuneracao(@PathVariable Long id, @RequestBody AtualizaRemuneracaoForm form){
        Remuneracao remuneracao = remuneracaoService.atualizaRemuneracao(id, form);

        return ResponseEntity.ok().body(new RemuneracaoDto(remuneracao));
    }	
}
