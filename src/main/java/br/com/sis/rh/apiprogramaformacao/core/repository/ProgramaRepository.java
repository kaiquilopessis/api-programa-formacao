package br.com.sis.rh.apiprogramaformacao.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.sis.rh.apiprogramaformacao.api.model.Programa;

@Repository
public interface ProgramaRepository extends JpaRepository<Programa, Long> {

//    @Query(value = "SELECT * FROM TB_PROGRAMA WHERE status = 'PROCESSO_SELETIVO'", nativeQuery = true)
//    public List<Programa> findTodosProcessosSeletivos();

    @Query(value = "SELECT * FROM TB_PROGRAMA AS P WHERE p.status = 'PROCESSO_SELETIVO'", nativeQuery = true)
    public List<Programa> findAllOrdenado();
}
