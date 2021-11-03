package br.com.sis.rh.apiprogramaformacao.core.repository;

/**
 * Esta classe faz persistencia dos dados da Tabela Conclusão contida na database programa de formacao
 */

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.sis.rh.apiprogramaformacao.api.model.Conclusao;

@Repository
public interface ConclusaoRepository extends JpaRepository<Conclusao, Long>{
	
	//busca o participante com o seu referido codigo
	@Query("select c from TB_CONCLUSAO c where codigo_participante_fk = ?1 ")
	List<Conclusao> listarConclusoes(String cpf);
}
