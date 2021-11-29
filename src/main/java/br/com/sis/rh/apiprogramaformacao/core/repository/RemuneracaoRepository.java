package br.com.sis.rh.apiprogramaformacao.core.repository;

import br.com.sis.rh.apiprogramaformacao.api.model.Remuneracao;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CargoModalDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RemuneracaoRepository extends JpaRepository<Remuneracao, Long> {

    Remuneracao findByCargo(String cargo);

    @Query(value = "SELECT NEW br.com.sis.rh.apiprogramaformacao.api.vo.dto.CargoModalDto(r.cargo, r.id) " +
            "FROM Remuneracao r where r.id = ?1")
    CargoModalDto buscarPeloId(Long id);
}
