package br.com.sis.rh.apiprogramaformacao.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sis.rh.apiprogramaformacao.api.vo.Avaliacoes;

public interface AvaliacoesRepository extends JpaRepository<Avaliacoes, Long> {

}
