package br.com.sis.rh.apiprogramaformacao.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sis.rh.apiprogramaformacao.api.model.Programa;

public interface FormacaoRepository  extends JpaRepository <Programa, Long> {
	
	List<Programa> findByStatus(String status);
}
