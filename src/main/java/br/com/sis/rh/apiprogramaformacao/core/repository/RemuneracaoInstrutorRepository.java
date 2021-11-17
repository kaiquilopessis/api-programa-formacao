package br.com.sis.rh.apiprogramaformacao.core.repository;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sis.rh.apiprogramaformacao.api.model.RemuneracaoInstrutor;

public interface RemuneracaoInstrutorRepository extends JpaRepository<RemuneracaoInstrutor, Long> {

	// busca o valor do salario instutor de acordo com o programa selecionado
	@Query(value = "select sum(vlr_hora * qtd_hora) from TB_REMUNERACAO_INSTRUTOR ri join TB_PROGRAMA p "
		+ "ON ri.codigo_instrutor_fk = p.cpf_Instrutor where nome = ?1 AND nome_turma = ?2", nativeQuery = true)
	Double calcularSalarioInstrutores(String nomePrograma, String nomeTurma);
		
	// busca o valor do salario instutor de acordo com o programa selecionado e com as datas selecionadas
	@Query(value = "select sum(vlr_hora * qtd_hora) from TB_REMUNERACAO_INSTRUTOR ri join TB_PROGRAMA p "
		+ "ON ri.codigo_instrutor_fk = p.cpf_Instrutor where nome = ?1 AND nome_turma = ?2 "
		+ "AND data_lancamento >= ?3 AND data_lancamento <= ?4", nativeQuery = true)
	BigDecimal calcularSalarioInstrutoresPeriodo(String nomePrograma, String nomeTurma, LocalDate dataInicio, LocalDate dataFim);
}
