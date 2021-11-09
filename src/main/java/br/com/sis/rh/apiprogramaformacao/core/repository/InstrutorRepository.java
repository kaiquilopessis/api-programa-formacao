package br.com.sis.rh.apiprogramaformacao.core.repository;

import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FiltragemInstrutorDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface InstrutorRepository extends JpaRepository<FiltragemInstrutorDto, String> {

    @Query(value = "SELECT ins.nome_instrutor, pro.nome AS nome_programa, pro.nome_turma, pro.vlr_hora_instrutor " +
            "FROM TB_INSTRUTOR AS ins INNER JOIN TB_PROGRAMA AS pro ON pro.cpf_instrutor = ins.cpf_instrutor " , nativeQuery = true )
    List<FiltragemInstrutorDto> findByNomeFormacaoTurmaHoraTodos();
}
