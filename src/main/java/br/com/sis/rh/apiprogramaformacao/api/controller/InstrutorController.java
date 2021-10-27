package br.com.sis.rh.apiprogramaformacao.api.controller;

import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.InstrutorForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.InstrutorVo;
import br.com.sis.rh.apiprogramaformacao.core.service.InstrutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/instrutor")
public class InstrutorController {

    @Autowired
    private InstrutorService instrutorService;

    @GetMapping
    public ResponseEntity<List<InstrutorVo>> getPadrao(){
        List<Instrutor> listaInstrutores = instrutorService.todosInstrutores();
        List<InstrutorVo> listaVo = InstrutorVo.converterListaParaVo(listaInstrutores);

        return ResponseEntity.ok(listaVo);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<InstrutorVo> getByCpf(@PathVariable String cpf){
        Instrutor instrutor = instrutorService.buscaPorCpf(cpf);
        InstrutorVo instrutorVo = InstrutorVo.converterParaVo(instrutor);

        return ResponseEntity.ok(instrutorVo);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Instrutor>> getByStatus(@PathVariable int status){
        List<Instrutor> listaInstrutoresPorStatus = instrutorService.buscaPorStatus(status);

        return ResponseEntity.ok(listaInstrutoresPorStatus);
    }

    @PostMapping
    @Transactional
    public String cadastro(@RequestBody @Valid InstrutorForm form){
        try {
            Instrutor instrutor = form.converter();
            instrutorService.salva(instrutor);

            return "SUCESSO";
        }
        catch (Exception e) {
            return "ERRO: " + e;
        }
    }



}
