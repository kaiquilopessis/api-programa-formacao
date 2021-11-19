package br.com.sis.rh.apiprogramaformacao.core.repository;

import br.com.sis.rh.apiprogramaformacao.api.model.Investimentos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestimentosRepository extends JpaRepository<Investimentos, Long> {

}
