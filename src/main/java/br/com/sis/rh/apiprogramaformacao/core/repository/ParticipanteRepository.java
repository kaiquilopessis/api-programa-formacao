package br.com.sis.rh.apiprogramaformacao.core.repository;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ParticipanteRepository extends JpaRepository<Participante, String> {

    @Query(value = "SELECT * FROM TB_PARTICIPANTE " +
            "WHERE cpf_participante = ?1 ", nativeQuery = true)
    Optional<Participante> findById(String cpfParticipante);
}
