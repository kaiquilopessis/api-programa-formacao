package br.com.sis.rh.apiprogramaformacao.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.model.conclusão;

public interface ParticipanteRepository extends JpaRepository<Participante, Long>{

}
