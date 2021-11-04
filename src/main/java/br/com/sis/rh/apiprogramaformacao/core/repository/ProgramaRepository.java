package br.com.sis.rh.apiprogramaformacao.core.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sis.rh.apiprogramaformacao.api.model.Programa;

public interface ProgramaRepository extends JpaRepository<Programa, Long>{

	//Busca o dia de conclusão dos programas (tela de conclusão)
	@Query(value = "select data_fim from TB_PROGRAMA where nome = ?1 and nome_turma = ?2", nativeQuery = true)
	LocalDate dataConclusao(String formacao, String turma);

	// busca o nome do programa com sua data 
	@Query("select p from TB_PROGRAMA p where data_inicio <= ?1 and data_fim >= ?2 and nome= ?3")
	Programa ListarPrograma(LocalDate dataInicio, LocalDate dataFim, String nomePrograma, String nomeTurma);
	
	// busca nome do programa onde nome da turma for igual ao selecionado
	@Query("select p from TB_PROGRAMA p where nome= ?1 and nome_turma= ?2")
	Programa listarProgramaSemData(String nomePrograma,String nomeTurma);
	
	// busca o valor do salario instutor de acordo com o programa selecionado
	@Query("select (vlr_hora_instrutor * qtd_hr_instrutor) from TB_PROGRAMA where nome= ?1")
	List<Double> calcularSalarioInstrutores(String nomePrograma, String nomeTurma);

}
