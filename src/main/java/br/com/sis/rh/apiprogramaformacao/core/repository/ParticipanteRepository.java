package br.com.sis.rh.apiprogramaformacao.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.sis.rh.apiprogramaformacao.api.model.Programa;

@Repository
public interface ParticipanteRepository extends JpaRepository<Programa, Long> {

	@Query(value = "SELECT COUNT(*) FROM TB_PROGRAMA WHERE nome = :parametro", nativeQuery = true)
	Integer listaParticipantesJava(@Param("parametro") String parametro);

	@Query(value = "select count(p) from TB_PARTICIPANTE P JOIN TB_PROGRAMA prog ON p.codigo_programa_fk = prog.id where p.status_ativo = 'ATIVO' AND prog.nome = ?1 and prog.nome_turma = ?2")
	Integer listaParticipantesAtivos(@Param("p") Integer p);

	@Query(value = "select count(p) from TB_PARTICIPANTE P JOIN TB_PROGRAMA prog ON p.codigo_programa_fk = prog.id where p.status_ativo = 'EFETIVADO' AND prog.nome = ?1 and prog.nome_turma = ?2")
	Integer listaParticipantesEfetivados();
}