package br.com.sis.rh.apiprogramaformacao.core.repository.acompanhamento;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sis.rh.apiprogramaformacao.api.model.acompanhamento.FeedBack;

public interface FeedBackRepository  extends JpaRepository<FeedBack, Long>{

	List<FeedBack> findAllByParticipanteCpf(String cpf);

}
