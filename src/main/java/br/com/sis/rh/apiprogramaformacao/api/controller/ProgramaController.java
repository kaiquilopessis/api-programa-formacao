package br.com.sis.rh.apiprogramaformacao.api.controller;

import java.util.List;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ProgramaBuscaVo;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ProgramaCompletoVo;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.ProgramaCadastroForm;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusFormacao;
import br.com.sis.rh.apiprogramaformacao.core.repository.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.core.service.ProgramaService;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/programa")
public class ProgramaController {

	@Autowired
	private ProgramaService programaService;

	@Autowired
	private InstrutorRepository instrutorRepository;

	@GetMapping
	public ResponseEntity<List<ProgramaBuscaVo>> getPadrao(){
		List<Programa> listaProgramas = programaService.getProgramaList();
		List<ProgramaBuscaVo> programaBuscaVos = ProgramaBuscaVo.converterParaLista(listaProgramas);

		return ResponseEntity.ok(programaBuscaVos);
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
				programa.setStatus(StatusFormacao.ENCERRADO);
			}
			else {
				programa.setStatus(StatusFormacao.EM_ANDAMENTO);
			}

			programaService.salva(programa);
			return ResponseEntity.ok().build();
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body(e);
		}
	}
}
