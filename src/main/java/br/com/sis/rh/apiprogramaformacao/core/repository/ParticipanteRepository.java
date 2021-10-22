package br.com.sis.rh.apiprogramaformacao.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, String>  {
	
}
