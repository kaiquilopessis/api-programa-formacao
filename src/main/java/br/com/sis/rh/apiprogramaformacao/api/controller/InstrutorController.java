package br.com.sis.rh.apiprogramaformacao.api.controller;

import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CpfInstrutorNomeDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FiltragemInstrutorDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.InstrutorForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.InstrutorVo;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.InvestimentoInstrutorForm;
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
    public ResponseEntity<List<InstrutorVo>> getByStatus(@PathVariable String status){
        List<Instrutor> listaInstrutoresPorStatus = instrutorService.buscaPorStatus(status);
		List<InstrutorVo> listaInstrutoresPorStatusVo = InstrutorVo.converterListaParaVo(listaInstrutoresPorStatus);

        return ResponseEntity.ok(listaInstrutoresPorStatusVo);
    }


    @PutMapping("/status/altera/{cpf}")
	@Transactional
    public ResponseEntity alteraStatus(@PathVariable String cpf){
    	try {
	    	Instrutor instrutor = instrutorService.buscaPorCpf(cpf);
	    	if (instrutor.getStatus().equals("ATIVO")) {
	    		instrutor.setStatus("INATIVO");
	    	}else {
	    		instrutor.setStatus("ATIVO");
	    	}
	    	instrutorService.salva(instrutor);
	    	return ResponseEntity.ok().build();
    	} catch (Exception e) {
    		return ResponseEntity.badRequest().build();
    	}
    }

	@PostMapping
	@Transactional
	public ResponseEntity cadastro(@RequestBody @Valid InstrutorForm form) {
		try {
			Instrutor instrutor = form.converter();
			instrutorService.salva(instrutor);

			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e);
		}
	}

	@GetMapping("/buscar-instrutor/{nomePrograma}/{nomeTurma}")
	public List<FiltragemInstrutorDto> mostrarDados(@PathVariable String nomePrograma, @PathVariable String nomeTurma){
		return instrutorService.listagemFiltroInstrutor(nomePrograma, nomeTurma);
	}

	@PostMapping("/salvar-invest")
	public void salvarInvestimentos(@RequestBody InvestimentoInstrutorForm investimentoInstrutorForm){
		instrutorService.cadastrar(investimentoInstrutorForm);
	}

	@GetMapping("/instrutores/{nomePrograma}/{nomeTurma}") //indicar que será um parametro dinamico (flexivel)
	public List<CpfInstrutorNomeDto> mostrarInstrutores(@PathVariable String nomePrograma, @PathVariable String nomeTurma){
		return instrutorService.listagemInstrutores(nomePrograma, nomeTurma);
	}

}
