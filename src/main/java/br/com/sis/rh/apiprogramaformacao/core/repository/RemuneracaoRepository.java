package br.com.sis.rh.apiprogramaformacao.core.repository;

import br.com.sis.rh.apiprogramaformacao.api.model.Remuneracao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemuneracaoRepository extends JpaRepository<Remuneracao, Long> {

    Remuneracao findByCargo(String cargo);
}
