package br.com.sis.rh.apiprogramaformacao.core.repository;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FiltragemFolhaDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface FolhaDtoRepository extends JpaRepository<FiltragemFolhaDto, String> {

    @Query(value = "SELECT ca.nome AS nome_participante, pr.nome AS nome_programa, pr.nome_turma, re.bolsa_aux " +
            "FROM TB_PARTICIPANTE AS pa INNER JOIN TB_PROGRAMA AS pr ON pr.id = pa.codigo_programa_fk " +
            "INNER JOIN TB_CANDIDATO AS ca ON ca.id = pa.codigo_candidato_fk " +
            "INNER JOIN TB_REMUNERACAO AS re ON re.id = pa.FK_codigo_remun " +
            "WHERE 1=1 " +
            "AND ca.nome LIKE '%nomeParticipante%' AND pr.nome LIKE '%nomeFormacao%' AND pr.nome_turma LIKE '%nomeTurma%' And re.bolsa_aux LIKE '%bolsaAux%' ", nativeQuery = true)
    List<FiltragemFolhaDto> findByNomeFormacaoTurmaBolsa(String nomeParticipante, String nomeFormacao, String nomeTurma, BigDecimal bolsaAux);

    @Query(value = "SELECT ca.nome AS nome_participante, pr.nome AS nome_programa, pr.nome_turma, re.bolsa_aux " +
            "FROM TB_PARTICIPANTE AS pa INNER JOIN TB_PROGRAMA AS pr ON pr.id = pa.codigo_programa_fk " +
            "INNER JOIN TB_CANDIDATO AS ca ON ca.id = pa.codigo_candidato_fk " +
            "INNER JOIN TB_REMUNERACAO AS re ON re.id = pa.FK_codigo_remun", nativeQuery = true )
    List<FiltragemFolhaDto> findByNomeFormacaoTurmaBolsaTodos();


}
