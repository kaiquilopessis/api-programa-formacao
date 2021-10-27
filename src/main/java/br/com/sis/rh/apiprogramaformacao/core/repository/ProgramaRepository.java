package br.com.sis.rh.apiprogramaformacao.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sis.rh.apiprogramaformacao.api.model.Programa;

@Repository
public interface ProgramaRepository extends JpaRepository<Programa, String> {
	List<Programa> findByTurma(String turma);
	List<Programa> findByNome(String nome);
}
