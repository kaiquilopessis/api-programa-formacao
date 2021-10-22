package br.com.sis.rh.apiprogramaformacao.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusAtivo;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusEfetivo;

public interface ParticipanteRepository extends JpaRepository<Participante, Long> {
	
	// Método que devolve uma lista somente com os participantes com status EFETIVADO
	@Query(value = "SELECT p FROM Participante p WHERE status_efetivado = ?1")
	List<Participante> findByStatusEfetivo(StatusEfetivo status_efetivado);
	
	// Método que devolve uma lista somente os participantes com status ATIVO
	@Query(value = "SELECT p FROM Participante p WHERE status_ativo = ?1")
	List<Participante> findByStatusAtivo(StatusAtivo status_ativo);
	
	// Método que devolve a contagem total de participantes com status ATIVO
	@Query(value = "SELECT COUNT(p) FROM Participante p WHERE status_ativo = 'ATIVO'")
	Integer totalParticipantesAtivos();
	
	// Método que devolve a contagem total de participantes com status EFETIVADO
	@Query(value = "SELECT COUNT(p) FROM Participante p WHERE status_efetivado = 'EFETIVADO'")
	Integer totalEfetivados();
	
}
