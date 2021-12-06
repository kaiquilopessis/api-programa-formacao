package br.com.sis.rh.apiprogramaformacao.core.repository;

import br.com.sis.rh.apiprogramaformacao.api.model.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {

    @Query(value = "SELECT * FROM TB_CANDIDATO AS c WHERE c.processo_seletivo_fk = :idProcesso ", nativeQuery = true)
    List<Candidato> findCandidatosPorFormacao(@Param("idProcesso") Long id);

    List<Candidato> findAll();
    
    @Query(value = "SELECT * FROM TB_CANDIDATO AS c WHERE c.status = 'APROVADO_2_FASE'", nativeQuery = true)
    List<Candidato> findCandidatoPorStatus();

	


}
