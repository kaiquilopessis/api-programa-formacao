package br.com.sis.rh.apiprogramaformacao.core.repository.permissoes;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sis.rh.apiprogramaformacao.api.model.permissoes.Perfil;

public interface PerfilRepository extends JpaRepository <Perfil, Integer> {
    Perfil findByNome(String perfil);
}
