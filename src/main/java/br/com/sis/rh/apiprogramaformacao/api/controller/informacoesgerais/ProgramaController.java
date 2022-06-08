package br.com.sis.rh.apiprogramaformacao.api.controller.informacoesgerais;

import java.util.List;

import javax.transaction.Transactional;

import br.com.sis.rh.apiprogramaformacao.api.model.informacoesgerais.Instrutor;
import br.com.sis.rh.apiprogramaformacao.api.model.informacoesgerais.Programa;
import br.com.sis.rh.apiprogramaformacao.api.model.processoseletivo.ProcessoSeletivo;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.*;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.ProgramaAtualizaForm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import br.com.sis.rh.apiprogramaformacao.api.openApi.ProgramaControllerOpenApi;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.ProgramaCadastroForm;
import br.com.sis.rh.apiprogramaformacao.core.repository.informacoesgerais.InstrutorRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.processoseletivo.ProcessoSeletivoRepository;
import br.com.sis.rh.apiprogramaformacao.core.service.informacoesgerais.ProgramaService;
import br.com.sis.rh.apiprogramaformacao.core.service.permissoes.MatriculaService;
import br.com.sis.rh.apiprogramaformacao.core.service.processoseletivo.ProcessoSeletivoService;

@RestController
@RequestMapping("/api/programa")
public class ProgramaController implements ProgramaControllerOpenApi {

	private static final Logger LOGGER = LogManager.getLogger(MatriculaService.class);

	@Autowired
	private ProgramaService programaService;

	@Autowired
	private ProcessoSeletivoService processoSeletivoService;

	@Autowired
	private ProcessoSeletivoRepository processoSeletivoRepository;

	@Autowired
	private InstrutorRepository instrutorRepository;

	@Override
	@GetMapping
	public List<ProgramaBuscaVo> getPadrao() {
		return programaService.getProgramaList();
	}

	@Override
	@GetMapping("/buscarFormacaoPorId/{id}")
	public NomeTurmaCandidatoDto mostrarTurma(@PathVariable Long id) {
		return programaService.getTurmaPorId(id);
	}

	@Override
	@GetMapping("/processo-seletivo/finalizados")
	public List<ProcessoSeletivoVo> getProcesso() {
		return processoSeletivoService.listarProcesso();
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<ProgramaCompletoVo> getProgramaById(@PathVariable long id) {
		Programa programa = programaService.getProgramaPorId(id);
		ProgramaCompletoVo programaVo = ProgramaCompletoVo.converter(programa);

		return ResponseEntity.ok(programaVo);
	}

	@Override
	@PutMapping
	public void atualizarPrograma(@RequestBody ProgramaAtualizaForm programaAtualizaForm) {
		programaService.atualizaPrograma(programaAtualizaForm);
	}

	@Override
	@PostMapping
	@Transactional
	public ResponseEntity cadastra(@RequestBody ProgramaCadastroForm programaCadastroForm) {
		Instrutor instrutor = instrutorRepository.findInstrutorByNome(programaCadastroForm.getInstrutor());
		ProcessoSeletivo processoSeletivo = processoSeletivoRepository.findByNome(programaCadastroForm.getNome());
		
		if(processoSeletivo.isVinculadoPrograma()==true) {
			return ResponseEntity.badRequest().build();
		}
		
		try {
			Programa programa = programaCadastroForm.converter(processoSeletivo, instrutor, programaCadastroForm);
			programaService.salva(programa);
			LOGGER.info(SecurityContextHolder.getContext().getAuthentication().getName() + " cadastrou o programa: " + programa.getId() + " - " + programa.getNomeTurma());
			return ResponseEntity.ok().body("Cadastro concluído com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e);
		}
	}

	@Override
	@PutMapping("/altera-status/{id}")
	public ResponseEntity alteraStatus(@PathVariable Long id) {
		try {
			Programa programa = programaService.getProgramaPorId(id);
			if (programa.getStatus().equals("EM_ANDAMENTO")) {
				programa.setStatus("ENCERRADO");
				LOGGER.info(SecurityContextHolder.getContext().getAuthentication().getName() + " encerrou o programa: " + programa.getId() + " - " + programa.getNomeTurma());
			} else {
				programa.setStatus("EM_ANDAMENTO");
				LOGGER.info(SecurityContextHolder.getContext().getAuthentication().getName() + " habilitou o programa: " + programa.getId() + " - " + programa.getNomeTurma());
			}

			programaService.salva(programa);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e);
		}
	}

	@Override
	@GetMapping("buscar-processo")
	public List<ProcessoSeletivoVo> programasEmAndamento() {
		return processoSeletivoService.buscaProgramas();
	}

	@Override
	@GetMapping("/buscar-programas-por-processo/{id}")
	public List<TurmaDto> buscarTurmasPeloProcesso(@PathVariable Long id) {
		return programaService.buscarTurmasbyProcesso(id);
	}

	@Override
	@GetMapping("/buscar-programas-por-nome/{nome}")
	public List<TurmaDto> buscarProgramaPeloNome(@PathVariable String nome) {
		return programaService.buscarTurmasbyNomeProcesso(nome);
	}

}