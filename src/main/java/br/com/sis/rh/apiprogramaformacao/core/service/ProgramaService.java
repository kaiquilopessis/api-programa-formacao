package br.com.sis.rh.apiprogramaformacao.core.service;

import java.util.List;
import java.util.Optional;

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
}
