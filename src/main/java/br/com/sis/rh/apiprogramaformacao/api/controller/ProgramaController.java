package br.com.sis.rh.apiprogramaformacao.api.controller;

import java.util.List;

import javax.transaction.Transactional;

import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;
import br.com.sis.rh.apiprogramaformacao.api.model.ProcessoSeletivo;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.*;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.ProgramaAtualizaForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
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

	@GetMapping("/buscarFormacaoPorId/{id}")
	public NomeTurmaCandidatoDto mostrarTurma(@PathVariable Long id) {return programaService.getTurmaPorId(id);}
	
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

	@PutMapping
	public void atualizarPrograma(@RequestBody ProgramaAtualizaForm programaAtualizaForm){
		programaService.atualizaPrograma(programaAtualizaForm);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity cadastra(@RequestBody ProgramaCadastroForm programaCadastroForm){
		System.out.println(programaCadastroForm.getInstrutor());
		Instrutor instrutor = instrutorRepository.findInstrutorByNome(programaCadastroForm.getInstrutor());
		ProcessoSeletivo processoSeletivo = processoSeletivoRepository.findByNome(programaCadastroForm.getNome());
		try{
			Programa programa = programaCadastroForm.converter(processoSeletivo, instrutor, programaCadastroForm);
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
	
	@GetMapping("buscar-processo")
	public List<ProcessoSeletivoVo> programasEmAndamento(){
		return processoSeletivoService.buscaProgramas();
	}

	@GetMapping("/buscar-programas-por-processo/{id}")
	public List<TurmaDto> buscarTurmasPeloProcesso(@PathVariable Long id) {
		return programaService.buscarTurmasbyProcesso(id);
	}

	@GetMapping("/buscar-programas-por-nome/{nome}")
	public List<TurmaDto> buscarProgramaPeloNome(@PathVariable String nome) {
		return programaService.buscarTurmasbyNomeProcesso(nome);
	}

}
