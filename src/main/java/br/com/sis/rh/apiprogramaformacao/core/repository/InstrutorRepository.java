package br.com.sis.rh.apiprogramaformacao.core.repository;

import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.NomeInstrutorDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface InstrutorRepository extends JpaRepository<Instrutor, String> {

    @Query(value = "SELECT * FROM TB_INSTRUTOR " +
            "WHERE cpf_instrutor = ?1 ", nativeQuery = true)
    Optional<Instrutor> findById(String cpfInstrutor);

    List<Instrutor> findByStatus(String status);

    Instrutor findInstrutorByNome(String nome);

    @Query(value = "SELECT NEW br.com.sis.rh.apiprogramaformacao.api.vo.dto.NomeInstrutorDto(i.nome, i.cpfInstrutor) " +
            "FROM Instrutor i where i.status = 'ATIVO'")
    List<NomeInstrutorDto> listarInstrutoresAtivos();
}
