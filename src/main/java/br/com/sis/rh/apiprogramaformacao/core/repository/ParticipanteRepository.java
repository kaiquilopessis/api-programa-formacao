package br.com.sis.rh.apiprogramaformacao.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.core.enums.Status_Ativo;
import br.com.sis.rh.apiprogramaformacao.core.enums.Status_Efetivo;

public interface ParticipanteRepository extends JpaRepository<Participante, Long> {
	
	@Query(value = "SELECT p FROM Participante p WHERE status_efetivado = ?1")
	List<Participante> findByStatusEfetivo(Status_Efetivo status_efetivado);
	
	@Query(value = "SELECT p FROM Participante p WHERE status_ativo = ?1")
	List<Participante> findByStatusAtivo(Status_Ativo status_ativo);
	
	@Query(value = "SELECT COUNT(p) FROM Participante p WHERE status_ativo = 'ATIVO'")
	Integer totalParticipantesAtivos();
	
	@Query(value = "SELECT COUNT(p) FROM Participante p WHERE status_efetivado = 'EFETIVADO'")
	Integer totalEfetivados();
	
}
