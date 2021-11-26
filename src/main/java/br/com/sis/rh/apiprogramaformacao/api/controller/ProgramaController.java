package br.com.sis.rh.apiprogramaformacao.api.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ProcessoSeletivoVo;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ProgramaBuscaVo;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ProgramaCompletoVo;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.ProgramaCadastroForm;
import br.com.sis.rh.apiprogramaformacao.core.repository.InstrutorRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ProcessoSeletivoRepository;
import br.com.sis.rh.apiprogramaformacao.core.service.ProcessoSeletivoService;
import br.com.sis.rh.apiprogramaformacao.core.service.ProgramaService;

@RestController
@RequestMapping("/api/programa")
public class ProgramaController {

	@Autowired
	private ProgramaService programaService;

	@Autowired
	private ProcessoSeletivoService processoSeletivoService;

	@Autowired
	private ProcessoSeletivoRepository processoSeletivoRepository;

	@Autowired
	private InstrutorRepository instrutorRepository;

	@GetMapping
	public List<ProgramaBuscaVo> getPadrao(){
		return  programaService.getProgramaList();
	}
	
	@GetMapping("/processo-seletivo/finalizados")
	public List<ProcessoSeletivoVo> getProcesso(){
		return processoSeletivoService.listarProcesso();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProgramaCompletoVo> getProgramaById(@PathVariable long id){
		Programa programa  = programaService.getProgramaPorId(id);
		ProgramaCompletoVo programaVo = ProgramaCompletoVo.converter(programa);

		return ResponseEntity.ok(programaVo);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity cadastra(@RequestBody @Valid ProgramaCadastroForm programaCadastroForm){
		try{
			Programa programa = programaCadastroForm.converter(instrutorRepository);
			programaService.salva(programa);

			return ResponseEntity.ok().body("Cadastro concluído com sucesso!");
		}
		catch (Exception e){
			return ResponseEntity.badRequest().body(e);
		}
	}

	@PutMapping("/altera-status/{id}")
	public ResponseEntity alteraStatus(@PathVariable Long id){
		try {
			Programa programa = programaService.getProgramaPorId(id);
			if (programa.getStatus().equals("EM_ANDAMENTO")) {
				programa.setStatus("ENCERRADO");
			}
			else {
				programa.setStatus("EM_ANDAMENTO");
			}

			programaService.salva(programa);
			return ResponseEntity.ok().build();
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body(e);
		}
	}

}
