package br.com.sis.rh.apiprogramaformacao.core.repository.investimentos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sis.rh.apiprogramaformacao.api.model.Instrutor;
import br.com.sis.rh.apiprogramaformacao.api.model.RemuneracaoInstrutor;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.CpfInstrutorNomeDto;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.FiltragemInstrutorDto;

public interface InvestimentoInstrutorRepository extends JpaRepository<RemuneracaoInstrutor, Integer> {

    @Query(value = "SELECT new br.com.sis.rh.apiprogramaformacao.api.vo.dto.FiltragemInstrutorDto(i.cpfInstrutor, i.nome, pro.nome, p.nomeTurma, rei.qtdHora, rei.valorHora, rei.dataLancamento, p.dataFim)  " +
            "FROM Instrutor i INNER JOIN ProcessoSeletivo as pro ON pro.instrutor = i " +
            "INNER JOIN RemuneracaoInstrutor rei ON rei.instrutor = i " +
            "INNER JOIN Programa p ON p.processoSeletivo = pro " +
            "where pro.nome = ?1 and p.nomeTurma = ?2 " +
            "group by i.nome, pro.nome, p.nomeTurma, i.cpfInstrutor, rei.qtdHora, rei.valorHora, rei.dataLancamento, p.dataFim ")
    List<FiltragemInstrutorDto> findByNomeFormacaoTurmaHora(String nomeFormacao, String nomeTurma);


    @Query(value = "SELECT i.* FROM TB_INSTRUTOR i WHERE i.nome_instrutor = ?1 ", nativeQuery = true)
    Instrutor findByNome(String nome);

    @Query(value = "SELECT new br.com.sis.rh.apiprogramaformacao.api.vo.dto.CpfInstrutorNomeDto(i.cpfInstrutor, i.nome) " +
            "FROM Instrutor i INNER JOIN ProcessoSeletivo ps ON ps.instrutor = i " +
            "INNER JOIN Programa pr ON ps = pr.processoSeletivo " +
            "WHERE ps.nome = ?1 AND pr.nomeTurma = ?2 ")
    List<CpfInstrutorNomeDto> findByCpf(String nomeFormacao, String nomeTurma);
}