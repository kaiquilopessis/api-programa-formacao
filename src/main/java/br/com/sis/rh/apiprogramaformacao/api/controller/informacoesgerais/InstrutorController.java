package br.com.sis.rh.apiprogramaformacao.api.controller.informacoesgerais;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import br.com.sis.rh.apiprogramaformacao.core.service.informacoesgerais.InstrutorService;
import br.com.sis.rh.apiprogramaformacao.core.service.permissoes.MatriculaService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;
import br.com.sis.rh.apiprogramaformacao.api.openApi.InstrutorControllerOpenApi;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CpfInstrutorNomeDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FiltragemInstrutorDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.InstrutorVo;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AttInstrutorForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.InstrutorForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.InvestimentoInstrutorForm;


@RestController
@RequestMapping("/api/instrutor")
public class InstrutorController implements InstrutorControllerOpenApi{

	private static final Logger LOGGER = LogManager.getLogger(MatriculaService.class);

	@Autowired
	private InstrutorService instrutorService;

	//Criado por Letícia Angulo
	//Métodos utilizados pelas telas de CRUD de instrutor
	@Override
    @GetMapping
    public ResponseEntity<List<InstrutorVo>> getPadrao(){
        List<Instrutor> listaInstrutores = instrutorService.todosInstrutores();
        List<InstrutorVo> listaVo = InstrutorVo.converterListaParaVo(listaInstrutores);

        return ResponseEntity.ok(listaVo);
    }

	@Override
    @GetMapping("/{cpf}")
    public ResponseEntity<InstrutorVo> getByCpf(@PathVariable String cpf){
        Instrutor instrutor = instrutorService.buscaPorCpf(cpf);
        InstrutorVo instrutorVo = InstrutorVo.converterParaVo(instrutor);
        
        return ResponseEntity.ok(instrutorVo);
    }
	
	@Override
    @GetMapping("/status/{status}")
    public ResponseEntity<List<InstrutorVo>> getByStatus(@PathVariable String status){
        List<Instrutor> listaInstrutoresPorStatus = instrutorService.buscaPorStatus(status);
		List<InstrutorVo> listaInstrutoresPorStatusVo = InstrutorVo.converterListaParaVo(listaInstrutoresPorStatus);

        return ResponseEntity.ok(listaInstrutoresPorStatusVo);
    }

	@Override
    @PutMapping("/status/altera/{cpf}")
	@Transactional
    public ResponseEntity alteraStatus(@PathVariable String cpf){
    	try {
	    	Instrutor instrutor = instrutorService.buscaPorCpf(cpf);
	    	if (instrutor.getStatus().equals("ATIVO")) {
	    		instrutor.setStatus("INATIVO");
				LOGGER.info(SecurityContextHolder.getContext().getAuthentication().getName() + " desabilitou o instrutor: " + instrutor.getNome());
			}else {
	    		instrutor.setStatus("ATIVO");
				LOGGER.info(SecurityContextHolder.getContext().getAuthentication().getName() + " habilitou o instrutor: " + instrutor.getNome());
			}
	    	instrutorService.salva(instrutor);
			return ResponseEntity.ok().build();
    	} catch (Exception e) {
    		return ResponseEntity.badRequest().build();
    	}
    }

	@Override
	@PutMapping("/altera/{cpf}")
	@Transactional
	public ResponseEntity alterarInstrutor(@PathVariable String cpf, @RequestBody AttInstrutorForm attInstrutorForm){
		boolean altera = instrutorService.alteraInstrutor(attInstrutorForm, cpf);
		if(altera == true){
			LOGGER.info(SecurityContextHolder.getContext().getAuthentication().getName() + " alterou o instrutor: " + attInstrutorForm.getNome());
			return ResponseEntity.ok().build();
		}else{
			return ResponseEntity.badRequest().build();
		}
	}

	@Override
	@PostMapping
	@Transactional
	public ResponseEntity cadastro(@RequestBody @Valid InstrutorForm form) {
		try {
			Instrutor instrutor = form.converter();
			return instrutorService.salva(instrutor);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e);
		}
	}

	//Fim dos método utilizados nas telas de CRUD de instrutor

	//Criado por Marco Aguiar
	//Referente as telas de Inserção de remuneração por mês
	
	@Override
	@GetMapping("/buscar-instrutor/{nomePrograma}/{nomeTurma}")
	public List<FiltragemInstrutorDto> mostrarDados(@PathVariable String nomePrograma, @PathVariable String nomeTurma){
		return instrutorService.listagemFiltroInstrutor(nomePrograma, nomeTurma);
	}

	@Override
	@PostMapping("/salvar-invest")
	public ResponseEntity salvarInvestimentos(@RequestBody InvestimentoInstrutorForm investimentoInstrutorForm){
		return instrutorService.cadastrar(investimentoInstrutorForm);
	}
	
	@Override
	@GetMapping("/instrutores/{nomePrograma}/{nomeTurma}") //indicar que será um parametro dinamico (flexivel)
	public List<CpfInstrutorNomeDto> mostrarInstrutores(@PathVariable String nomePrograma, @PathVariable String nomeTurma){
		return instrutorService.listagemInstrutores(nomePrograma, nomeTurma);
	}

}
