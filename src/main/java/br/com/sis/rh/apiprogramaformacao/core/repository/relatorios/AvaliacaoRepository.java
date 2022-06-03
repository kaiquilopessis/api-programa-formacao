package br.com.sis.rh.apiprogramaformacao.core.repository.relatorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sis.rh.apiprogramaformacao.api.model.Avaliacoes;

public interface AvaliacaoRepository extends JpaRepository<Avaliacoes, Long>  {

	@Query(value = "select * from TB_NOTAS_AVALIACOES NA JOIN TB_AVALIACAO_DESEMPENHO AD ON " +
			"NA.nota_comportamental_fk = AD.id where NA.id = " +
			"        (select max(NA1.id) from TB_NOTAS_AVALIACOES NA1 JOIN TB_PARTICIPANTE TP on TP.cpf_participante = NA1.codigo_participante_fk " +
			"        JOIN TB_PROGRAMA P on P.id = TP.codigo_programa_fk JOIN TB_PROCESSO_SELETIVO TPS on TPS.id = P.processo_seletivo_fk " +
			"        where codigo_participante_fk = NA.codigo_participante_fk AND P.nome_turma = ?1 AND TPS.nome = ?2 " +
			"        group by codigo_participante_fk)"
			, nativeQuery = true)
	List<Avaliacoes> buscarNotasMaisRecentes(String nomeTurma, String nomePrograma);
	
	@Query(value = "select top(1) count(codigo_participante_fk) from TB_NOTAS_AVALIACOES JOIN TB_PARTICIPANTE TP on TP.cpf_participante = TB_NOTAS_AVALIACOES.codigo_participante_fk " +
			"JOIN TB_PROGRAMA T on T.id = TP.codigo_programa_fk JOIN TB_PROCESSO_SELETIVO TPS on TPS.id = T.processo_seletivo_fk " +
			"WHERE t.nome_turma = ?1 AND tps.nome = ?2 " +
			"group by codigo_participante_fk having count(codigo_participante_fk) > 1 ", nativeQuery =  true)
	Integer buscaNumeroCiclo(String nomeTurma, String nomePrograma);
	
	List<Avaliacoes>findAllByParticipanteCpf(String cpf);
}
