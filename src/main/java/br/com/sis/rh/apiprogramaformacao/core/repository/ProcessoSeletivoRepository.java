package br.com.sis.rh.apiprogramaformacao.core.repository;

import br.com.sis.rh.apiprogramaformacao.api.model.ProcessoSeletivo;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ProgramaDto;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusProcessoSeletivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProcessoSeletivoRepository extends JpaRepository<ProcessoSeletivo, Long> {

    @Query(value = "select new br.com.sis.rh.apiprogramaformacao.api.vo.dto.ProgramaDto(ps.nome) " +
            "from TB_PROCESSO_SELETIVO ps where ps.status = 'EM_ANDAMENTO'")
    List<ProgramaDto> buscarFormacoesEmAndamento(StatusProcessoSeletivo statusEmAndamento);
}
