package br.com.sis.rh.apiprogramaformacao.core.repository;

import br.com.sis.rh.apiprogramaformacao.api.model.ProcessoSeletivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProcessoSeletivoRepository extends JpaRepository<ProcessoSeletivo, Long> {

    @Query(value = "SELECT * FROM TB_PROCESSO_SELETIVO AS p WHERE p.nome = :nome", nativeQuery = true)
    ProcessoSeletivo findByNome(@Param("nome") String nome);

    @Query(value = "SELECT * FROM TB_PROCESSO_SELETIVO AS p WHERE p.status = 'EM_ANDAMENTO'", nativeQuery = true)
    List<ProcessoSeletivo> findTodosEmAndamento();
}
