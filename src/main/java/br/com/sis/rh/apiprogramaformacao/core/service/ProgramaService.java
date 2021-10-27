package br.com.sis.rh.apiprogramaformacao.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.core.repository.ProgramaRepository;

@Service
public class ProgramaService  {
	
	ProgramaRepository repository;
	
	
	public List<Programa> getProgramaList(){
		return repository.findAll();
	}
	
	public Programa getNome(Long id) {
		Optional<Programa> listaProgramas = repository.findById(id.toString());
		return listaProgramas.get();
	}
	
	public List<Programa> getTurma(String nomeTurma){
		List<Programa> listaTurma = repository.findByTurma(nomeTurma);
		return listaTurma;
	}
	
	


}
