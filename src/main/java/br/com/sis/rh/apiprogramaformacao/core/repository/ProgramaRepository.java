package br.com.sis.rh.apiprogramaformacao.core.repository;

import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusFormacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProgramaRepository extends JpaRepository<Programa, Long> {
	
	// Método que devolve uma lista somente com as formações com status EM_ANDAMENTO
		@Query(value = "SELECT p FROM Programa p WHERE status = ?1 ")
		List<Programa> findByStatusFormacao(StatusFormacao status);
			
		// Método que devolve a contagem total de formações com status EM_ANDAMENTO
		@Query(value = "SELECT COUNT(p) FROM Programa p WHERE status = 'EM_ANDAMENTO'")
		Integer totalFormacoes();	

	//Busca o dia de conclusão dos programas (tela de conclusão)
	@Query(value = "SELECT programa.dataFim FROM TB_PROGRAMA programa " +
			"JOIN TB_PROCESSO_SELETIVO processo ON processo = programa.processoSeletivo " +
			"WHERE programa.nomeTurma = ?2 " +
			"AND processo.nomePrograma = ?1")
	LocalDate dataConclusao(String formacao, String turma);
	
	// busca nome do programa onde nome da turma for igual ao selecionado
	@Query(value = "select p.* from TB_PROGRAMA p JOIN TB_PROCESSO_SELETIVO ps ON ps.id = p.processo_seletivo_fk " +
			"where ps.nome = ?1 and p.nome_turma = ?2", nativeQuery = true)
	Programa listarPrograma(String nomePrograma, String nomeTurma);

	//Buscar cpf do instrutor pelo nome e turma do programa
	@Query(value = "select ti.cpf_instrutor from TB_PROGRAMA tp " +
			"JOIN TB_PROCESSO_SELETIVO TPS on TPS.id = tp.processo_seletivo_fk " +
			"JOIN TB_INSTRUTOR TI on TI.cpf_instrutor = TPS.cpf_instrutor_fk " +
			"where tps.nome = ?1 AND tp.nome_turma = ?2", nativeQuery = true)
	List<String> listarCPFbyNomeProgramaNomeTurma(String nomePrograma, String nomeTurma);

	@Query(value = "select p from TB_PROGRAMA p " +
			"JOIN TB_PROCESSO_SELETIVO tps on tps = p.processoSeletivo " +
			"where tps.nomePrograma = ?1 order by p.nomeTurma asc")
	List<Programa> buscarTurmasPeloNomePrograma(String nomePrograma);
}
