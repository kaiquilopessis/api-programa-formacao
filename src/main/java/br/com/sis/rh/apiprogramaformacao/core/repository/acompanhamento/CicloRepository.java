package br.com.sis.rh.apiprogramaformacao.core.repository.acompanhamento;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sis.rh.apiprogramaformacao.api.model.acompanhamento.Ciclo;

public interface CicloRepository  extends JpaRepository<Ciclo, Long>{

	List<Ciclo> findAllByParticipanteCpf(String cpf);
	
}
