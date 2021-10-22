package br.com.sis.rh.apiprogramaformacao.core.repository;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ParticipanteRepository extends JpaRepository<Participante, String> {

    List<Participante> findById(Long id);

    Optional<Participante> findByCpf(String cpf);
}
