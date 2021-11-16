package br.com.sis.rh.apiprogramaformacao.core.repository;

import br.com.sis.rh.apiprogramaformacao.api.model.ProcessoSeletivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessoSeletivoRepository extends JpaRepository<ProcessoSeletivo, Long> {

    ProcessoSeletivo findByNome(String nome);
}
