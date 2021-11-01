package br.com.sis.rh.apiprogramaformacao.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sis.rh.apiprogramaformacao.api.model.Conclusao;

public interface ConclusaoRepository  extends JpaRepository<Conclusao, Long>{

	List<Conclusao> findAllByParticipanteCpf(String cpf);
}
