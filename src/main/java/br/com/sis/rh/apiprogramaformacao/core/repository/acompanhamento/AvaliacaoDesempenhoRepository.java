package br.com.sis.rh.apiprogramaformacao.core.repository.acompanhamento;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sis.rh.apiprogramaformacao.api.model.acompanhamento.AvaliacaoDesempenho;

public interface AvaliacaoDesempenhoRepository extends JpaRepository<AvaliacaoDesempenho, Long> {

}
