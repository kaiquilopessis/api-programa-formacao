package br.com.sis.rh.apiprogramaformacao.core.repository;

import br.com.sis.rh.apiprogramaformacao.api.model.RemuneracaoPrograma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemuneraçãoProgramaRepository extends JpaRepository<RemuneracaoPrograma, Long> {
}
