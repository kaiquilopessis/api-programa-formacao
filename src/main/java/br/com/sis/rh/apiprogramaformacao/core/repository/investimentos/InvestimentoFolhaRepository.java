package br.com.sis.rh.apiprogramaformacao.core.repository.investimentos;

import br.com.sis.rh.apiprogramaformacao.api.model.informacoesgerais.Participante;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CpfParticipanteNomeDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FiltragemFolhaDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvestimentoFolhaRepository extends JpaRepository<FiltragemFolhaDto, String> {
    
    @Query(value = "SELECT pa.cpf_participante ,ca.nome AS nome_participante, pro.nome AS nome_programa, pr.nome_turma, re.bolsa_aux, re.beneficios, " +
            "re.convenio, re.hr_extra, re.beneficio_legislacao, re.remun_esporadica, re.remun_extra, re.alura, pr.data_fim AS data_fim_programa, pr.data_inicio AS data_inicio_programa " +
            "FROM TB_PARTICIPANTE AS pa INNER JOIN TB_PROGRAMA AS pr ON pr.id = pa.codigo_programa_fk " +
            "INNER JOIN TB_CANDIDATO AS ca ON ca.id = pa.codigo_candidato_fk " +
            "INNER JOIN TB_PROCESSO_SELETIVO AS pro ON pro.id = pr.processo_seletivo_fk " +
            "INNER JOIN TB_REMUNERACAO AS re ON re.id = pa.FK_codigo_remun " +
            "WHERE 1=1 " +
            "AND pro.nome = ?1 AND pr.nome_turma = ?2 ", nativeQuery = true) //?1 significa pegar o primeiro parametro indicado
    List<FiltragemFolhaDto> findByNomeFormacaoTurmaBolsa(String nomeFormacao, String nomeTurma);

    @Query(value = "SELECT p.* FROM TB_PARTICIPANTE p JOIN TB_CANDIDATO c ON p.codigo_candidato_fk = c.id " +
            "WHERE c.nome = ?1 ", nativeQuery = true)
    Participante findByNome(String nome);

    @Query(value = "SELECT new br.com.sis.rh.apiprogramaformacao.api.vo.dto.CpfParticipanteNomeDto(pa.cpf, ca.nome) " +
            "FROM Participante pa INNER JOIN Programa  pr ON pr = pa.programa " +
            "INNER JOIN Candidato ca ON ca = pa.candidato " +
            "INNER JOIN ProcessoSeletivo  pro ON pro = pr.processoSeletivo " +
            "WHERE pro.nome = ?1 AND pr.nomeTurma = ?2 ")
    List<CpfParticipanteNomeDto> findByCpf(String nomeFormacao, String nomeTurma);

}
