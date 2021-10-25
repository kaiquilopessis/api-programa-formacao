package br.com.sis.rh.apiprogramaformacao.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sis.rh.apiprogramaformacao.api.model.Avaliacoes;

public interface AvaliacoesRepository extends JpaRepository<Avaliacoes, Long> {

	List<Avaliacoes>findAllByParticipanteCpfParticipante(String cpf);

}
