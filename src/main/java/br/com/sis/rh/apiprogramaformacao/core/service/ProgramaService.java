package br.com.sis.rh.apiprogramaformacao.core.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ListaProgramaDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ProgramaBuscaVo;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.AtualizaProcessoSeletivoForm;
import br.com.sis.rh.apiprogramaformacao.api.vo.form.ProcessoSeletivoForm;
import br.com.sis.rh.apiprogramaformacao.core.repository.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.core.repository.ProgramaRepository;

@Service
public class ProgramaService  {

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

	//Métodos criados pelo Gustavo Rosa

}
