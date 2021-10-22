package br.com.sis.rh.apiprogramaformacao.core.repository;

import br.com.sis.rh.apiprogramaformacao.api.model.UsuarioAcesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioAcessoRepository extends JpaRepository<UsuarioAcesso, String> {

    Optional<UsuarioAcesso> findByUsuarioAd(String email);
}
