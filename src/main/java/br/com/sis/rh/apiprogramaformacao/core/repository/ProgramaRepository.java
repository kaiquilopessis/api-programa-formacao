package br.com.sis.rh.apiprogramaformacao.core.repository;

import java.time.LocalDate;
import java.util.List;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.NomeProgramaCandidatoDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.TurmaModalDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.sis.rh.apiprogramaformacao.api.model.ProcessoSeletivo;
import br.com.sis.rh.apiprogramaformacao.api.model.Programa;

@Repository
public interface ProgramaRepository extends JpaRepository<Programa, Long> {

//    @Query(value = "SELECT * FROM TB_PROGRAMA WHERE status = 'PROCESSO_SELETIVO'", nativeQuery = true)
//    public List<Programa> findTodosProcessosSeletivos();

	@Query(value = "SELECT * FROM TB_PROGRAMA AS P WHERE p.status = 'PROCESSO_SELETIVO'", nativeQuery = true)
	public List<Programa> findAllOrdenado();
	@Query(value=" SELECT * FROM TB_PROGRAMA p JOIN TB_PROCESSO_SELETIVO ps ON ps.id = p.processo_seletivo_fk "
			+ "WHERE p.nome_turma = ?1 AND ps.id = ?2", nativeQuery= true)
	public Programa findByNomeTurmaIdProcesso(String nome, Long id);

	// Busca o dia de conclusão dos programas (tela de conclusão)
	@Query(value = "SELECT programa.dataFim FROM Programa programa "
			+ "JOIN ProcessoSeletivo processo ON processo = programa.processoSeletivo "
			+ "WHERE programa.nomeTurma = ?2 " + "AND processo.nome = ?1")
	LocalDate dataConclusao(String formacao, String turma);

	// Método que devolve a contagem total de formações com status EM_ANDAMENTO
	@Query(value = "SELECT COUNT(p) FROM Programa p WHERE status = 'EM_ANDAMENTO'")
	Integer totalFormacoes();

	@Query(value = "select p from Programa p " + "JOIN ProcessoSeletivo tps on tps = p.processoSeletivo "
			+ "where tps.nome = ?1 order by p.nomeTurma asc")
	List<Programa> buscarTurmasPeloNomePrograma(String nomePrograma);

	// busca nome do programa onde nome da turma for igual ao selecionado
	@Query(value = "select p.* from TB_PROGRAMA p JOIN TB_PROCESSO_SELETIVO ps ON ps.id = p.processo_seletivo_fk "
			+ "where ps.nome = ?1 and p.nome_turma = ?2", nativeQuery = true)
	Programa listarPrograma(String nomePrograma, String nomeTurma);

	// Buscar cpf do instrutor pelo nome e turma do programa
	@Query(value = "select ti.cpf_instrutor from TB_PROGRAMA tp "
			+ "JOIN TB_PROCESSO_SELETIVO TPS on TPS.id = tp.processo_seletivo_fk "
			+ "JOIN TB_INSTRUTOR TI on TI.cpf_instrutor = TPS.cpf_instrutor_fk "
			+ "where tps.nome = ?1 AND tp.nome_turma = ?2", nativeQuery = true)
	List<String> listarCPFbyNomeProgramaNomeTurma(String nomePrograma, String nomeTurma);

	@Query(value="SELECT NEW br.com.sis.rh.apiprogramaformacao.api.vo.dto.NomeProgramaCandidatoDto(ps.nome, ps.id)  " +
			"FROM Candidato c INNER JOIN ProcessoSeletivo ps "
			+ "ON c.processoSeletivo = ps where c.id = ?1")
	NomeProgramaCandidatoDto buscarProgramaPorCandidato(Long id);

    @Query(value = "SELECT NEW br.com.sis.rh.apiprogramaformacao.api.vo.dto.TurmaModalDto(p.nomeTurma, p.id)" +
			" FROM Programa p where p.id = ?1")
	TurmaModalDto buscarPeloId(Long id);
}