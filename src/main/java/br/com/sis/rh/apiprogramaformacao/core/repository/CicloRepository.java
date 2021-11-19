package br.com.sis.rh.apiprogramaformacao.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sis.rh.apiprogramaformacao.api.model.Ciclo;

public interface CicloRepository  extends JpaRepository<Ciclo, Long>{

	List<Ciclo> findAllByParticipanteCpf(String cpf);
	
}
