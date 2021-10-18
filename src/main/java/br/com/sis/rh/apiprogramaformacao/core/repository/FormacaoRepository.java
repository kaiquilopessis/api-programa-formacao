package br.com.sis.rh.apiprogramaformacao.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sis.rh.apiprogramaformacao.api.model.Formacao;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;

public interface FormacaoRepository  extends JpaRepository <Formacao, Long> {
	
	List<Formacao> findByStatus(Boolean status);
}
