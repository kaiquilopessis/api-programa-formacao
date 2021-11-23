package br.com.sis.rh.apiprogramaformacao.core.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ParticipanteProgramaDto;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusAtivo;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusEfetivado;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusParticipante;

public interface ParticipanteRepository extends JpaRepository<Participante, String> {

	@Query(value = "SELECT * FROM TB_PARTICIPANTE " + "WHERE cpf_participante = ?1 ", nativeQuery = true)
	Optional<Participante> findById(StatusAtivo status);

	List<Participante> findByStatus(StatusAtivo status);

	Participante findByCpf(String cpf);

	// Busca os participantes ativos no programa e na turma(tela de conclusão)
	@Query(value = "select count(*) from TB_PARTICIPANTE p " + "JOIN TB_CANDIDATO TC ON TC.id = p.codigo_candidato_fk "
			+ "JOIN TB_PROGRAMA prog ON prog.id = p.codigo_programa_fk  "
			+ "JOIN TB_PROCESSO_SELETIVO processo ON processo.id = prog.processo_seletivo_fk " + "WHERE p.status_ativo = 'ATIVO' "
			+ "AND processo.nome = ?1 " + "AND prog.nome_turma = ?2", nativeQuery = true)
	Integer listaParticipantesAtivos(String nome, String turma);

	// Busca os participantes efetivados no programa e na turma(tela de conclusão)
	@Query(value = "SELECT count(*) FROM TB_PARTICIPANTE p " + "JOIN TB_CANDIDATO TC ON TC.id = p.codigo_candidato_fk "
			+ "JOIN TB_PROGRAMA prog ON p.codigo_programa_fk = prog.id "
			+ "JOIN TB_PROCESSO_SELETIVO processo ON processo.id = prog.processo_seletivo_fk "
			+ "WHERE p.status_efetivado = 'EFETIVADO' " + "AND processo.nome = ?1 " + "AND prog.nome_turma = ?2", nativeQuery = true)
	Integer listaParticipantesEfetivados(String nome, String turma);

	// Método que devolve a contagem total de participantes com status ATIVO
	@Query(value = "SELECT COUNT(*) FROM TB_PARTICIPANTE p WHERE p.status_ativo = 'ATIVO'", nativeQuery = true)
	Integer totalParticipantesAtivos();

	// Método que devolve a contagem total de participantes com status EFETIVADO
	@Query(value = "SELECT COUNT(*) FROM TB_PARTICIPANTE p WHERE p.status_efetivado = 'EFETIVADO'", nativeQuery = true)
	Integer totalEfetivados();

	// Método que devolve uma lista somente com os participantes com status
	// EFETIVADO
	@Query(value = "SELECT new br.com.sis.rh.apiprogramaformacao.api.vo.dto.ParticipanteProgramaDto(c.nome, tps.nome) "
			+ "FROM Participante p " + "JOIN Candidato c on c = p.candidato "
			+ "JOIN Programa tp on tp = p.programa " + "JOIN ProcessoSeletivo tps on tps = tp.processoSeletivo "
			+ "where p.statusEfetivado = 'EFETIVADO'")
	List<ParticipanteProgramaDto> findByStatusEfetivo( );

	// Busca o nome e o programa dos participantes com status ativo
	@Query(value = "SELECT new br.com.sis.rh.apiprogramaformacao.api.vo.dto.ParticipanteProgramaDto(c.nome, tps.nome) "
			+ "FROM Participante p " + "JOIN Candidato c on c = p.candidato "
			+ "JOIN Programa tp on tp = p.programa " + "JOIN ProcessoSeletivo tps on tps = tp.processoSeletivo "
			+ "where p.status = 'ATIVO'")
	List<ParticipanteProgramaDto> buscarParticipantesProgramaAtivos( );

	// busca o participante com o referio codigo do programa
		@Query(value = "select * from TB_PARTICIPANTE p JOIN TB_PROGRAMA pr ON pr.id = p.codigo_programa_fk " +
				"where pr.id = ?1", nativeQuery = true)
		List<Participante> listarParticipantes(Long codPrograma);
}
