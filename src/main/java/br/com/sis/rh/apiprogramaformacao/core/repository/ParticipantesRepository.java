package br.com.sis.rh.apiprogramaformacao.core.repository;


/**
 * Esta classe faz persistencia dos dados da Tabela Particiapnte contida na database programa de formacao
 */

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;

@Repository
public interface ParticipantesRepository extends JpaRepository <Participante, String>{

	 // busca o participante com o referio codigo do programa
	@Query("select p from TB_PARTICIPANTE p where codigo_programa_fk = ?1")
	List<Participante> listarParticipantes(Long codPrograma);
	
}
