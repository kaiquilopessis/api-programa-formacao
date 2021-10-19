package br.com.sis.rh.apiprogramaformacao.core.repository;


import br.com.sis.rh.apiprogramaformacao.api.model.RemuneracaoPrograma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemuneracaoProgramaRepository extends JpaRepository<RemuneracaoPrograma, Long> {
}
