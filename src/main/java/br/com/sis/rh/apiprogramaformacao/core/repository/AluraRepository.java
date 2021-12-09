package br.com.sis.rh.apiprogramaformacao.core.repository;

import java.util.List;
import java.util.Optional;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sis.rh.apiprogramaformacao.api.model.Alura;

public interface AluraRepository extends JpaRepository<Alura, Long> {

	List<Alura> findAllByParticipanteCpf(String cpf);

	Optional <Alura> findByParticipante(String cpf);
	
	@Query(value = "select * from TB_ALURA a JOIN TB_PARTICIPANTE TP on TP.cpf_participante = a.codigo_participante_fk " +
			"JOIN TB_PROGRAMA T on T.id = TP.codigo_programa_fk JOIN TB_PROCESSO_SELETIVO TPS on TPS.id = T.processo_seletivo_fk " +
			"where a.data_registro = (select max(data_registro) from TB_ALURA JOIN TB_PARTICIPANTE P on P.cpf_participante = TB_ALURA.codigo_participante_fk " +
			"JOIN TB_PROGRAMA TP on TP.id = P.codigo_programa_fk JOIN TB_PROCESSO_SELETIVO S on S.id = TP.processo_seletivo_fk " +
			"WHERE tp.nome_turma = ?1 AND S.nome = ?2) " +
			"AND t.nome_turma = ?1 and tps.nome = ?2",nativeQuery = true)
	List<Alura> buscarRegistroHoras(String nomeTurma, String nomePrograma);
	
	@Query(value = "select TOP(1) a.codigo_participante_fk from TB_ALURA a JOIN TB_PARTICIPANTE TP on TP.cpf_participante = a.codigo_participante_fk " +
			"JOIN TB_PROGRAMA T on T.id = TP.codigo_programa_fk JOIN TB_PROCESSO_SELETIVO TPS on TPS.id = T.processo_seletivo_fk " +
			"where a.data_registro = " +
			"        (select max(data_registro) from TB_ALURA JOIN TB_PARTICIPANTE TP1 on TP1.cpf_participante = TB_ALURA.codigo_participante_fk " +
			"        JOIN TB_PROGRAMA T1 on T1.id = TP1.codigo_programa_fk JOIN TB_PROCESSO_SELETIVO TPS1 on TPS1.id = T1.processo_seletivo_fk " +
			"        WHERE t1.nome_turma = ?1 AND TPS1.nome = ?2) " +
			"AND a.qtd_horas = " +
			"        (select max(qtd_horas) from TB_ALURA a JOIN TB_PARTICIPANTE TP2 on TP2.cpf_participante = a.codigo_participante_fk " +
			"        JOIN TB_PROGRAMA T2 on T2.id = TP2.codigo_programa_fk JOIN TB_PROCESSO_SELETIVO TPS2 on TPS2.id = T2.processo_seletivo_fk " +
			"        where a.data_registro = " +
			"            (select max(data_registro) from TB_ALURA JOIN TB_PARTICIPANTE TP3 on TP3.cpf_participante = TB_ALURA.codigo_participante_fk " +
			"            JOIN TB_PROGRAMA T3 on T3.id = TP3.codigo_programa_fk JOIN TB_PROCESSO_SELETIVO TPS3 on TPS3.id = T3.processo_seletivo_fk " +
			"            WHERE t3.nome_turma = ?1 AND TPS3.nome = ?2) " +
			"        AND T2.nome_turma = ?1 AND TPS2.nome = ?2) " +
			"AND t.nome_turma = ?1 AND tps.nome = ?2", nativeQuery = true)
	String buscarCpfMaiorHora(String nomeTurma, String nomePrograma);
	
	@Query(value = "select TOP(1) a.codigo_participante_fk from TB_ALURA a JOIN TB_PARTICIPANTE TP on TP.cpf_participante = a.codigo_participante_fk " +
			"JOIN TB_PROGRAMA T on T.id = TP.codigo_programa_fk JOIN TB_PROCESSO_SELETIVO TPS on TPS.id = T.processo_seletivo_fk " +
			"where a.data_registro = " +
			"        (select max(data_registro) from TB_ALURA JOIN TB_PARTICIPANTE TP1 on TP1.cpf_participante = TB_ALURA.codigo_participante_fk " +
			"        JOIN TB_PROGRAMA T1 on T1.id = TP1.codigo_programa_fk JOIN TB_PROCESSO_SELETIVO TPS1 on TPS1.id = T1.processo_seletivo_fk " +
			"        WHERE t1.nome_turma = ?1 AND TPS1.nome = ?2) " +
			"AND a.qtd_horas = " +
			"        (select min(qtd_horas) from TB_ALURA a JOIN TB_PARTICIPANTE TP2 on TP2.cpf_participante = a.codigo_participante_fk " +
			"        JOIN TB_PROGRAMA T2 on T2.id = TP2.codigo_programa_fk JOIN TB_PROCESSO_SELETIVO TPS2 on TPS2.id = T2.processo_seletivo_fk " +
			"        where a.data_registro = " +
			"            (select max(data_registro) from TB_ALURA JOIN TB_PARTICIPANTE TP3 on TP3.cpf_participante = TB_ALURA.codigo_participante_fk " +
			"            JOIN TB_PROGRAMA T3 on T3.id = TP3.codigo_programa_fk JOIN TB_PROCESSO_SELETIVO TPS3 on TPS3.id = T3.processo_seletivo_fk " +
			"            WHERE t3.nome_turma = ?1 AND TPS3.nome = ?2) " +
			"        AND T2.nome_turma = ?1 AND TPS2.nome = ?2) " +
			"AND t.nome_turma = ?1 AND tps.nome = ?2", nativeQuery = true)
	String buscarCpfMenorHora(String nomeTurma, String nomePrograma);

}
