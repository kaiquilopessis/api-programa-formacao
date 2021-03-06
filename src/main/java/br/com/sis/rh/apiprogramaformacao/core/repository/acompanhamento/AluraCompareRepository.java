package br.com.sis.rh.apiprogramaformacao.core.repository.acompanhamento;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sis.rh.apiprogramaformacao.api.model.acompanhamento.AluraCompare;

public interface AluraCompareRepository extends JpaRepository<AluraCompare, Integer> {

	List<AluraCompare> findByEmail(String email);

}
