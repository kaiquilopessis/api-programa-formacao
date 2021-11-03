package br.com.sis.rh.apiprogramaformacao.core.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ListaProgramaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.core.repository.ProgramaRepository;

@Service
public class ProgramaService  {

	@Autowired
	ProgramaRepository repository;

	public List<Programa> getProgramaList(){
		return repository.findAll();
	}

	public Programa getProgramaPorId(Long id) {
		Optional<Programa> programa = repository.findById(id);
		return programa.get();
	}

	public void salva(Programa programa) {
		repository.save(programa);
	}

	//Métodos criados pelo Gustavo Rosa
	public Programa buscarPorId(Long id) throws NoSuchElementException {
		Optional<Programa> optionalPrograma = repository.findById(id);
		return optionalPrograma.get();
	}

	public List<ListaProgramaDto> exibirTodasAsLinhas() throws NoSuchElementException {
		List<Programa> listPrograma = repository.findAll();
		return ListaProgramaDto.toListaProgramaDto(listPrograma);
	}
}
