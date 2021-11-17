package br.com.sis.rh.apiprogramaformacao.core.repository;

import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusFormacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ProgramaRepository extends JpaRepository<Programa, Long> {
	
	// Método que devolve uma lista somente com as formações com status EM_ANDAMENTO
	@Query(value = "SELECT p FROM TB_PROGRAMA p WHERE status = ?1 ")
	List<Programa> findByStatusFormacao(StatusFormacao status);
		
	// Método que devolve a contagem total de formações com status EM_ANDAMENTO
	@Query(value = "SELECT COUNT(p) FROM TB_PROGRAMA p WHERE status = 'EM_ANDAMENTO'")
	Integer totalFormacoes();	

	//Busca o dia de conclusão dos programas (tela de conclusão)
	@Query(value = "select data_fim from TB_PROGRAMA where nome = ?1 and nome_turma = ?2", nativeQuery = true)
	LocalDate dataConclusao(String formacao, String turma);

	// busca o nome do programa com sua data 
	@Query("select p from TB_PROGRAMA p where data_inicio <= ?1 and data_fim >= ?2 and nome= ?3")
	Programa ListarPrograma(LocalDate dataInicio, LocalDate dataFim, String nomePrograma);
	
	// busca nome do programa onde nome da turma for igual ao selecionado
	@Query("select p from TB_PROGRAMA p where nome= ?1 and nome_turma= ?2")
	Programa listarProgramaSemData(String nomePrograma,String nomeTurma);

}
