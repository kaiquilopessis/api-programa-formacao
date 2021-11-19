package br.com.sis.rh.apiprogramaformacao.core.repository;

import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;
import br.com.sis.rh.apiprogramaformacao.api.model.Remuneracao_Instrutor;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CpfInstrutorNomeDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CpfParticipanteNomeDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FiltragemInstrutorDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvestimentoInstrutorRepository extends JpaRepository<Remuneracao_Instrutor, Integer> {

//    @Query(value = "SELECT i.cpf_instrutor , i.nome_instrutor, pro.nome as nomePrograma, p.nome_turma as nomeTurma, rei.qtd_hora, rei.vlr_hora, p.data_fim " +
//            "FROM TB_INSTRUTOR as i INNER JOIN TB_PROCESSO_SELETIVO as pro ON pro.cpf_instrutor_fk = i.cpf_instrutor " +
//            "INNER JOIN TB_REMUNERACAO_INSTRUTOR AS rei ON rei.codigo_instrutor_fk = i.cpf_instrutor " +
//            "INNER JOIN TB_PROGRAMA AS p ON p.processo_seletivo_fk = pro.id " +
//            "where pro.nome = ?1 and p.nome_turma = ?2 " +
//            "group by i.nome_instrutor, pro.nome, p.nome_turma, i.cpf_instrutor, rei.qtd_hora, rei.vlr_hora, p.data_fim ", nativeQuery = true)
//    List<FiltragemInstrutorDto> findByNomeFormacaoTurmaHora(String nomeFormacao, String nomeTurma);

    @Query(value = "SELECT new br.com.sis.rh.apiprogramaformacao.api.vo.dto.FiltragemInstrutorDto(i.cpfInstrutor, i.nomeInstrutor, pro.nome, p.nomeTurma, rei.quantidadeHora, rei.valorHora, p.dataFim)  " +
            "FROM Instrutor i INNER JOIN ProcessoSeletivo as pro ON pro.instrutor = i " +
            "INNER JOIN Remuneracao_Instrutor rei ON rei.instrutor = i " +
            "INNER JOIN Programa p ON p.processoSeletivo = pro " +
            "where pro.nome = ?1 and p.nomeTurma = ?2 " +
            "group by i.nomeInstrutor, pro.nome, p.nomeTurma, i.cpfInstrutor, rei.quantidadeHora, rei.valorHora, p.dataFim ")
    List<FiltragemInstrutorDto> findByNomeFormacaoTurmaHora(String nomeFormacao, String nomeTurma);


    @Query(value = "SELECT i.* FROM TB_INSTRUTOR i WHERE i.nome_instrutor = ?1 ", nativeQuery = true)
    Instrutor findByNome(String nome);

    @Query(value = "SELECT new br.com.sis.rh.apiprogramaformacao.api.vo.dto.CpfInstrutorNomeDto(i.cpfInstrutor, i.nomeInstrutor) " +
            "FROM Instrutor i INNER JOIN ProcessoSeletivo ps ON ps.instrutor = i " +
            "INNER JOIN Programa pr ON ps = pr.processoSeletivo " +
            "WHERE ps.nome = ?1 AND pr.nomeTurma = ?2 ")
    List<CpfInstrutorNomeDto> findByCpf(String nomeFormacao, String nomeTurma);
}