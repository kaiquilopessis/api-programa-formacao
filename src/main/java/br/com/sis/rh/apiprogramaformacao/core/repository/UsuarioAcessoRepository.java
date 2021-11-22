package br.com.sis.rh.apiprogramaformacao.core.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sis.rh.apiprogramaformacao.api.model.UsuarioAcesso;

@Repository
public interface UsuarioAcessoRepository extends JpaRepository<UsuarioAcesso, String> {

    Optional<UsuarioAcesso> findByUsuarioAd(String email);
}
