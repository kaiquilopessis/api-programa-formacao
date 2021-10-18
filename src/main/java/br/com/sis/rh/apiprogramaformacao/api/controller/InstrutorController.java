package br.com.sis.rh.apiprogramaformacao.api.controller;

import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;
import br.com.sis.rh.apiprogramaformacao.core.service.InstrutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/instrutor")
public class InstrutorController {

    @Autowired
    private InstrutorService instrutorService;

    @GetMapping
    public ResponseEntity<List<Instrutor>> getPadrao(){
        List<Instrutor> listaInstrutores = instrutorService.todosInstrutores();

        return ResponseEntity.ok(listaInstrutores);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Instrutor> getByCpf(@PathVariable String cpf){
        Instrutor instrutor = instrutorService.buscaPorCpf(cpf);

        return ResponseEntity.ok(instrutor);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Instrutor>> getByStatus(@PathVariable int status){
        List<Instrutor> listaInstrutoresPorStatus = instrutorService.buscaPorStatus(status);

        return ResponseEntity.ok(listaInstrutoresPorStatus);
    }



}
