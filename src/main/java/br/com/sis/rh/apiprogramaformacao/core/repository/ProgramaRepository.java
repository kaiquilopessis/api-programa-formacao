package br.com.sis.rh.apiprogramaformacao.core.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sis.rh.apiprogramaformacao.api.model.Programa;

public interface ProgramaRepository extends JpaRepository<Programa, Long>{

	@Query(value = "select data_fim from TB_PROGRAMA where nome = ?1 and nome_turma = ?2", nativeQuery = true)
	LocalDate dataConclusao(String formacao, String turma);
}
