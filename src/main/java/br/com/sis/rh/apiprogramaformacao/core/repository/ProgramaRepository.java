package br.com.sis.rh.apiprogramaformacao.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sis.rh.apiprogramaformacao.api.model.Programa;

@Repository
public interface ProgramaRepository extends JpaRepository<Programa, Long> {
	
	public Programa findByNomeTurma(String nome);
}
