package br.com.sis.rh.apiprogramaformacao.core.repository.cargos;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sis.rh.apiprogramaformacao.api.model.cargos.RemuneracaoInstrutor;

public interface RemuneracaoInstrutorRepository extends JpaRepository<RemuneracaoInstrutor, Integer> {
	
	// busca o valor do salario instutor de acordo com o programa selecionado
		@Query(value = "select sum(tri.vlr_hora * tri.qtd_hora) FROM TB_REMUNERACAO_INSTRUTOR TRI " +
				"where tri.codigo_instrutor_fk = ?1", nativeQuery = true)
		Double calcularSalarioInstrutores(String cpfInstrutor);
			
		// busca o valor do salario instutor de acordo com o programa selecionado e com as datas selecionadas
		@Query(value = "select sum(vlr_hora * qtd_hora) FROM TB_REMUNERACAO_INSTRUTOR\n" +
				"where codigo_instrutor_fk = ?1 AND data_lancamento between ?2 AND ?3", nativeQuery = true)
		Double calcularSalarioInstrutoresPeriodo(String cpfInstrutor, LocalDate dataInicio, LocalDate dataFim);
}
