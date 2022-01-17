package br.com.sis.rh.apiprogramaformacao.core.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;
import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.NomeTurmaCandidatoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ProgramaBuscaVo;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.TurmaDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.ProgramaAtualizaForm;
import br.com.sis.rh.apiprogramaformacao.core.repository.InstrutorRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ProgramaRepository;

@Service
public class ProgramaService  {

	private static final Logger LOGGER = LogManager.getLogger(MatriculaService.class);

	@Autowired
	ProgramaRepository repository;

	@Autowired
	InstrutorRepository instrutorRepository;

	public List<ProgramaBuscaVo> getProgramaList(){
		List<ProgramaBuscaVo> programaBuscaVos = ProgramaBuscaVo.converterParaLista(repository.findAll());
		return programaBuscaVos ;
	}
	
		
	public Programa getProgramaPorId(Long id) {
		Optional<Programa> programa = repository.findById(id);
		return programa.get();
	}

	public void salva(Programa programa) {
		repository.save(programa);
	}

	public void atualizaPrograma(ProgramaAtualizaForm programaAtualizaForm) {
		Instrutor instrutor = instrutorRepository.findInstrutorByNome(programaAtualizaForm.getInstrutor());
		Programa programa = repository.getById(programaAtualizaForm.getId());
		programa = ProgramaAtualizaForm.atualizar(programa, instrutor, programaAtualizaForm);
		repository.save(programa);
		LOGGER.info(SecurityContextHolder.getContext().getAuthentication().getName() + " atualizou o programa: " + programa.getId() + " - " + programa.getNomeTurma());
	}

	public List<TurmaDto> buscarTurmasbyProcesso(Long id) {
		List<Programa> programas = repository.findByIdProcesso(id);
		return TurmaDto.converter(programas);
	}

	public List<TurmaDto> buscarTurmasbyNomeProcesso(String nome) {
		List<Programa> programas = repository.findByNomeProcesso(nome);
		return TurmaDto.converter(programas);
	}

	public NomeTurmaCandidatoDto getTurmaPorId(Long id) {
		Programa programa = repository.getById(id);
		return new NomeTurmaCandidatoDto(programa);
	}
}
