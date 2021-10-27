package br.com.sis.rh.apiprogramaformacao.core.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sis.rh.apiprogramaformacao.api.model.Alura;

public interface AluraRepository extends JpaRepository<Alura, Long> {
	
	List<Alura> findAllByParticipanteCpfParticipante(String cpf);
	
	Optional <Alura> findByParticipante(String cpf);

}
