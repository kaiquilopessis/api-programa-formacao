package br.com.sis.rh.apiprogramaformacao.core.repository;

import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstrutorRepository extends JpaRepository<Instrutor, String> {
    List<Instrutor> findByStatus(String status);

    Instrutor findInstrutorByNome(String nome);

}
