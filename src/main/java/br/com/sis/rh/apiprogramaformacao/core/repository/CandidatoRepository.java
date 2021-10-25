package br.com.sis.rh.apiprogramaformacao.core.repository;

import br.com.sis.rh.apiprogramaformacao.api.model.Candidato;
import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
    List<Candidato> findByNome(String nome);

    List<Programa> findByPrograma(String nomePrograma);

    List<Programa> findByTurma(String nomeTurma);
}
