package br.com.sis.rh.apiprogramaformacao.core.repository;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FiltragemInstrutorDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InstrutorRepository extends JpaRepository<FiltragemInstrutorDto, String> {

    @Query(value = "SELECT i.cpf_instrutor , i.nome_instrutor, pro.nome, p.nome_turma, rei.qtd_hora, rei.vlr_hora, p.data_fim " +
            "FROM TB_INSTRUTOR as i INNER JOIN TB_PROGRAMA as p ON p.cpf_Instrutor = i.cpf_instrutor " +
            "INNER JOIN TB_REMUNERACAO_INSTRUTOR AS rei ON rei.codigo_instrutor_fk = i.cpf_instrutor " +
            "INNER JOIN TB_PROCESSO_SELETIVO AS pro ON pro.cpf_instrutor_fk = i.cpf_instrutor" +
            "where pro.nome = ?1 and p.nome_turma = ?2 " +
            "group by i.nome_instrutor, pro.nome, p.nome_turma, i.cpf_instrutor, rei.qtd_hora, rei.vlr_hora, p.data_fim ", nativeQuery = true)
    List<FiltragemInstrutorDto> findByNomeFormacaoTurmaHora(String nomeFormacao, String nomeTurma);
}