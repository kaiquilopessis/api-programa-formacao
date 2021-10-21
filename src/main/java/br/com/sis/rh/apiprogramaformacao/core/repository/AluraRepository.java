package br.com.sis.rh.apiprogramaformacao.core.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sis.rh.apiprogramaformacao.core.model.Alura;

public interface AluraRepository extends JpaRepository<Alura, Long> {
	
//	@Query(value = "select a.* from TB_ALURA a where id = ?1", nativeQuery = true)
//	Optional<Alura> buscarPorId(Long id);
//	
	@Query(value = "select * from TB_ALURA a "
			+ "where a.data_registro = (select max(data_registro) from TB_ALURA)",nativeQuery = true)
	List<Alura> buscarRegistroHoras();
}
