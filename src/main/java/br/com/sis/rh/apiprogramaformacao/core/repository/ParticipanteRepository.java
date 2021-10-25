package br.com.sis.rh.apiprogramaformacao.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.sis.rh.apiprogramaformacao.api.model.Programa;

@Repository
public interface ParticipanteRepository extends JpaRepository<Programa, Long>{

	@Query(value = "SELECT COUNT(*) FROM TB_PROGRAMA WHERE nome = :parametro", nativeQuery = true)
	Integer listaParticipantesJava(@Param("parametro") String parametro);	
}
