package br.com.sis.rh.apiprogramaformacao.core.repository;

import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FiltragemInstrutorDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface InstrutorRepository extends JpaRepository<Instrutor, String> {

    @Query(value = "SELECT ins.nome_instrutor AS nome_instrutor, pro.nome AS nome_programa, pro.nome_turma AS nome_turma, pro.vlr_hora_instrutor " +
            "FROM TB_INSTRUTOR AS ins INNER JOIN TB_PROGRAMA AS pro ON pro.cpf_instrutor = ins.cpf_instrutor " +
            "INNER JOIN TB_REMUNERACAO AS re ON re.id = ins.cpf_instrutor " +
            "WHERE 1=1 " +
            "AND ins.nome_instrutor LIKE '%nomeInstrutor%' AND pro.nome LIKE '%nomeFormacao%' AND pro.nome_turma LIKE '%nomeTurma%' And pro.vlr_hora_instrutor LIKE '%ValorHoraInstrutor%' ", nativeQuery = true)
    List<FiltragemInstrutorDto> findByNomeFormacaoTurmaHora(String nomeInstrutor, String nomeFormacao, String nomeTurma, BigDecimal valorHora);

    @Query(value = "SELECT ca.nome AS nome_participante, pr.nome AS nome_programa, pr.nome_turma AS nome_turma, re.bolsa_aux " +
            "FROM TB_PARTICIPANTE AS pa INNER JOIN TB_PROGRAMA AS pr ON pr.id = pa.codigo_programa_fk " +
            "INNER JOIN TB_CANDIDATO AS ca ON ca.id = pa.codigo_candidato_fk " +
            "INNER JOIN TB_REMUNERACAO AS re ON re.id = FK_codigo_remun", nativeQuery = true )
    List<FiltragemInstrutorDto> findByNomeFormacaoTurmaHoraTodos();
}
