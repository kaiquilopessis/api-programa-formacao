package br.com.sis.rh.apiprogramaformacao.core.repository;

import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FiltragemInstrutorDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface InstrutorRepository extends JpaRepository<FiltragemInstrutorDto, String> {

    @Query(value = "SELECT ins.nome_instrutor AS nome_instrutor, pro.nome AS nome_programa, pro.nome_turma AS nome_turma, pro.vlr_hora_instrutor as valor_hora, ins.cpf_instrutor as cpf_instrutor " +
            "FROM TB_INSTRUTOR AS ins INNER JOIN TB_PROGRAMA AS pro ON pro.cpf_instrutor = ins.cpf_instrutor " +
            "WHERE 1=1 " +
            "AND ins.nome_instrutor LIKE '%nomeInstrutor%' AND pro.nome LIKE '%nomeFormacao%' AND pro.nome_turma LIKE '%nomeTurma%' And pro.vlr_hora_instrutor LIKE '%ValorHoraInstrutor%' ", nativeQuery = true)
    List<FiltragemInstrutorDto> findByNomeFormacaoTurmaHora(String nomeInstrutor, String nomeFormacao, String nomeTurma, BigDecimal valorHora);

    @Query(value = "SELECT ins.nome_instrutor, pro.nome AS nome_programa, pro.nome_turma, pro.vlr_hora_instrutor, ins.cpf_instrutor " +
            "FROM TB_INSTRUTOR AS ins INNER JOIN TB_PROGRAMA AS pro ON pro.cpf_instrutor = ins.cpf_instrutor " , nativeQuery = true )
    List<FiltragemInstrutorDto> findByNomeFormacaoTurmaHoraTodos();
}
