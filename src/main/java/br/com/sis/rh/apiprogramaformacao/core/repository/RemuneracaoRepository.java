package br.com.sis.rh.apiprogramaformacao.core.repository;


/**
 * Esta classe faz persistencia dos dados da Tabela Remuneração contida na database programa de formacao
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.sis.rh.apiprogramaformacao.api.model.Remuneracao;

@Repository
public interface RemuneracaoRepository extends JpaRepository<Remuneracao, Long>{

	// busca o custo total com os participantes do programa
	@Query(value = "SELECT id, sum(bolsa_aux), sum(beneficios), sum(beneficio_legislacao), sum(convenio), sum(hr_extra), "
			+ "sum(remun_exporadica), sum(remun_extra), sum(alura) FROM TB_REMUNERACAO where id=?1 group by id", nativeQuery = true)
	Remuneracao findBySalario(Long id);
	
	Remuneracao findByCargo(String cargo);
	
	
}
