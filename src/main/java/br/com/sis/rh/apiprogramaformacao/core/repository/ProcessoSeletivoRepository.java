package br.com.sis.rh.apiprogramaformacao.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.sis.rh.apiprogramaformacao.api.model.ProcessoSeletivo;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ProgramaDto;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusProcessoSeletivo;

public interface ProcessoSeletivoRepository extends JpaRepository<ProcessoSeletivo, Long> {

    @Query(value = "SELECT * FROM TB_PROCESSO_SELETIVO AS p WHERE p.nome = :nome", nativeQuery = true)
    ProcessoSeletivo findByNome(@Param("nome") String nome);

    @Query(value = "SELECT * FROM TB_PROCESSO_SELETIVO AS p WHERE p.status = 'EM_ANDAMENTO'", nativeQuery = true)
    List<ProcessoSeletivo> findTodosEmAndamento();
    
    @Query(value = "select new br.com.sis.rh.apiprogramaformacao.api.vo.dto.NomeProgramaEmAndamentoDto(ps.nome) " +
            "from ProcessoSeletivo ps where ps.status = 'EM_ANDAMENTO'")
    List<ProgramaDto> buscarFormacoesEmAndamento(StatusProcessoSeletivo statusEmAndamento);
}
