package br.com.sis.rh.apiprogramaformacao.core.repository.processoseletivo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.sis.rh.apiprogramaformacao.api.model.processoseletivo.Candidato;

import java.util.List;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {

    @Query(value = "SELECT * FROM TB_CANDIDATO AS c WHERE c.processo_seletivo_fk = :idProcesso ", nativeQuery = true)
    List<Candidato> findCandidatosPorFormacao(@Param("idProcesso") Long id);

    List<Candidato> findAll();
    
    @Query(value = "select * from TB_CANDIDATO c where c.id NOT IN (select p.codigo_candidato_fk from TB_PARTICIPANTE p) "
    		+ "and c.status = 'APROVADO_2_FASE'", nativeQuery = true)
    List<Candidato> findCandidatoPorStatus();

	


}
