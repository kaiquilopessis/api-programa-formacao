package br.com.sis.rh.apiprogramaformacao.core.repository;

import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstrutorRepository extends JpaRepository<Instrutor, String> {

    List<Instrutor> findByStatus(int status);
}
