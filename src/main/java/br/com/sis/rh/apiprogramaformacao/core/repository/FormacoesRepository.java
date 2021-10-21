package br.com.sis.rh.apiprogramaformacao.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusFormacao;

public interface FormacoesRepository extends JpaRepository<Programa, Long> {
	
	@Query(value = "SELECT p FROM Programa p WHERE status = ?1 ")
	List<Programa> findByStatusFormacao(StatusFormacao status);
	
	@Query(value = "SELECT COUNT(p) FROM Programa p WHERE status = 'EM_ANDAMENTO'")
	Integer totalFormacoes();
	
}
