package br.com.sis.rh.apiprogramaformacao.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.core.repository.ProgramaRepository;
import br.com.sis.rh.apiprogramaformacao.core.service.ProgramaService;

@RestController
@RequestMapping("/api/programa")
public class ProgramaController {

	@Autowired
	private ProgramaRepository programaRepository;

	@GetMapping("/programa")
	public List<Programa> getNome() {
		return programaRepository.findAll();
	}
	
	@GetMapping("/{id}") 
	@PostMapping("/{nome}")
	public Programa savePrograma(@RequestBody Programa programa) {
		return programaRepository.save(programa);
	}
	
	
	
	@GetMapping("/{instrutor}")
	public List<Programa> getInstrutor(){
		
		return null;
	}

//	ProgramaForm programa = new ProgramaForm();
//	List<Programa> programaList = this.programaService.getProgramaList();
//	programaForm.addObject();
//	}
//	
//	
//	public List<Programa> listaProgramas(){
//		Programa programa = new Programa();
//		return Arrays.asList(programa);
//	}

//	@GetMapping
//	public ResponseEntity<List<ProgramaForm>> getPadrao(){
//		List<Programa> listaProgramas = programaService.todosProgramas();
//		List<ProgramaForm> listaForm = ProgramaForm.converterListaParaVo(listaProgramas);
//		return ResponseEntity.ok(listaForm);
//	}

}
