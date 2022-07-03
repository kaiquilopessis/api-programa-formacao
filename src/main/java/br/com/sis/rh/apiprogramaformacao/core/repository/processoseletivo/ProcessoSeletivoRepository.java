package br.com.sis.rh.apiprogramaformacao.core.repository.processoseletivo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.sis.rh.apiprogramaformacao.api.model.processoseletivo.ProcessoSeletivo;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.NomeProgramaEmAndamentoDto;

public interface ProcessoSeletivoRepository extends JpaRepository<ProcessoSeletivo, Long> {

	List<ProcessoSeletivo> findAllByStatusAndProcessoVinculado(String status, Integer vinculado);
	
	List<ProcessoSeletivo> findAllByStatus(String status);

	@Query(value = "SELECT * FROM TB_PROCESSO_SELETIVO AS p WHERE p.nome = :nome", nativeQuery = true)
	ProcessoSeletivo findByNome(@Param("nome") String nome);

	@Query(value = "SELECT * FROM TB_PROCESSO_SELETIVO AS p WHERE p.status = :status", nativeQuery = true)
	List<ProcessoSeletivo> findTodosEmAndamento(@Param("status") String status);

	@Query(value = "select new br.com.sis.rh.apiprogramaformacao.api.vo.dto.NomeProgramaEmAndamentoDto(ps.nome, p.nomeTurma)"
			+ " from Programa p join ProcessoSeletivo as ps on ps = p.processoSeletivo" 
			+ " where p.status = 'EM_ANDAMENTO'")
	List<NomeProgramaEmAndamentoDto> buscarFormacoesEmAndamento();

	@Query(value = "SELECT p.* FROM TB_PROCESSO_SELETIVO p JOIN TB_CANDIDATO c "
			+ "ON c.processo_seletivo_fk = p.id WHERE c.id = ?1", nativeQuery = true)
	ProcessoSeletivo findByIdCandidato(Long id);

}
