package br.com.sis.rh.apiprogramaformacao.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sis.rh.apiprogramaformacao.api.vo.Participante;

public interface ParticipanteRepository  extends JpaRepository <Participante, String> {
	
	List<Participante> findByStatus(Boolean status);
}
