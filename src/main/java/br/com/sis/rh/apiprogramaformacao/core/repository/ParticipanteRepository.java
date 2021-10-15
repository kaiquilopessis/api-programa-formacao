package br.com.sis.rh.apiprogramaformacao.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusAtivo;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusEfetivo;

public interface ParticipanteRepository extends JpaRepository<Participante, Long> {

	List<Participante> findByEfetivo(StatusEfetivo efetivado);
	
	List<Participante> findByAtivo(StatusAtivo ativo);
	
	@Query("SELECT COUNT(ativo) FROM Participante WHERE ativo = 'ATIVO'")
	Integer totalParticipantesAtivos();
	
	@Query("SELECT COUNT(efetivo) FROM Participante WHERE efetivo = 'EFETIVADO'")
	Integer totalEfetivados();
	
}
