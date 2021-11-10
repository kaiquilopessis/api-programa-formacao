package br.com.sis.rh.apiprogramaformacao.core.repository;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FiltragemInstrutorDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InstrutorRepository extends JpaRepository<FiltragemInstrutorDto, String> {

    @Query(value = "select i.cpf_instrutor , i.nome_instrutor, p.nome, p.nome_turma " +
            "FROM TB_INSTRUTOR as i INNER JOIN TB_PROGRAMA as p ON p.cpf_Instrutor = i.cpf_instrutor " +
            "where p.nome = ?1 and p.nome_turma = ?2 " +
            "group by i.nome_instrutor, p.nome, p.nome_turma, i.cpf_instrutor " , nativeQuery = true)
    List<FiltragemInstrutorDto> findByNomeFormacaoTurmaHora(String nomeFormacao, String nomeTurma);

    @Query(value = "SELECT ri.vlr_hora * ri.qtd_hora FROM TB_REMUNERACAO_INSTRUTOR as ri " +
            "WHERE ri.codigo_instrutor_fk = ?1 ", nativeQuery = true )
    List<Double> FindBySalarioInstrutor(String cpfInstrutor);

}
