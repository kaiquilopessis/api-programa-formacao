package br.com.sis.rh.apiprogramaformacao.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sis.rh.apiprogramaformacao.api.model.Formacoes;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusFormacao;

public interface FormacoesRepository extends JpaRepository<Formacoes, Long> {
	
	List<Formacoes> findByStatusFormacao(StatusFormacao statusFormacao);
	
	@Query("SELECT COUNT(statusFormacao) FROM Formacoes WHERE statusFormacao = 'EM_ANDAMENTO'")
	Integer totalFormacoes();
	
}
