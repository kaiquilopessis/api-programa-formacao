package br.com.sis.rh.apiprogramaformacao.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sis.rh.apiprogramaformacao.api.model.RemuneracaoPrograma;

public interface RemuneracaoProgramaRepository extends JpaRepository<RemuneracaoPrograma, Long> {

	RemuneracaoPrograma findByCargo(String cargo);
}
