package br.com.sis.rh.apiprogramaformacao.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.sis.rh.apiprogramaformacao.api.model.ProcessoSeletivo;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.NomeProgramaEmAndamentoDto;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusProcessoSeletivo;

public interface ProcessoSeletivoRepository extends JpaRepository<ProcessoSeletivo, Long> {

	List<ProcessoSeletivo> findAllByStatus(String status);

	@Query(value = "SELECT * FROM TB_PROCESSO_SELETIVO AS p WHERE p.nome = :nome", nativeQuery = true)
	ProcessoSeletivo findByNome(@Param("nome") String nome);

	@Query(value = "SELECT * FROM TB_PROCESSO_SELETIVO ", nativeQuery = true)
	List<ProcessoSeletivo> findTodosEmAndamento();

	@Query(value = "select new br.com.sis.rh.apiprogramaformacao.api.vo.dto.NomeProgramaEmAndamentoDto(ps.nome) "
			+ "from ProcessoSeletivo ps where ps.status = 'EM_ANDAMENTO'")
	List<NomeProgramaEmAndamentoDto> buscarFormacoesEmAndamento();

	@Query(value = "SELECT p.* FROM TB_PROCESSO_SELETIVO p JOIN TB_CANDIDATO c "
			+ "ON c.processo_seletivo_fk = p.id WHERE c.id = ?1", nativeQuery = true)
	ProcessoSeletivo findByIdCandidato(Long id);

	

}
