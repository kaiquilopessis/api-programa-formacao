package br.com.sis.rh.apiprogramaformacao.core.repository;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ParticipanteProgramaDto;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusAtivo;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusEfetivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ParticipanteRepository extends JpaRepository<Participante, String> {
	
	// Método que devolve uma lista somente com os participantes com status EFETIVADO
    @Query(value = "SELECT new br.com.sis.rh.apiprogramaformacao.api.vo.dto.ParticipanteProgramaDto(c.nomeCandidato, tps.nomePrograma) " +
            "FROM TB_PARTICIPANTE p " +
            "JOIN TB_CANDIDATO c on c = p.candidato " +
            "JOIN TB_PROGRAMA tp on tp = p.programa " +
            "JOIN TB_PROCESSO_SELETIVO tps on tps = tp.processoSeletivo " +
            "where p.statusEfetivado = ?1")
	List<ParticipanteProgramaDto> findByStatusEfetivo(StatusEfetivo status_efetivado);
	
	// Método que devolve a contagem total de participantes com status ATIVO
	@Query(value = "SELECT COUNT(p) FROM TB_PARTICIPANTE p WHERE p.statusAtivo = 'ATIVO'")
	Integer totalParticipantesAtivos();
	
	// Método que devolve a contagem total de participantes com status EFETIVADO
	@Query(value = "SELECT COUNT(p) FROM TB_PARTICIPANTE p WHERE p.statusEfetivado = 'EFETIVADO'")
	Integer totalEfetivados();

	// Busca os participantes ativos no programa e na turma(tela de conclusão)
	@Query(value = "select count(p) from TB_PARTICIPANTE p " +
			"JOIN TB_CANDIDATO TC ON TC = p.candidato " +
			"JOIN TB_PROGRAMA prog ON prog = p.programa  " +
			"JOIN TB_PROCESSO_SELETIVO processo ON processo = prog.processoSeletivo " +
			"WHERE p.statusAtivo = 'ATIVO' " +
			"AND processo.nomePrograma = ?1 " +
			"AND prog.nomeTurma = ?2")
	Integer listaParticipantesAtivos(String nome, String turma);

	// Busca os participantes efetivados no programa e na turma(tela de conclusão)
	@Query(value = "SELECT count(p) FROM TB_PARTICIPANTE p " +
			"JOIN TB_CANDIDATO TC ON TC = p.candidato " +
			"JOIN TB_PROGRAMA prog ON p.programa = prog " +
			"JOIN TB_PROCESSO_SELETIVO processo ON processo = prog.processoSeletivo " +
			"WHERE p.statusEfetivado = 'EFETIVADO' " +
			"AND processo.nomePrograma = ?1 " +
			"AND prog.nomeTurma = ?2")
	Integer listaParticipantesEfetivados(String nome, String turma);
	
	// busca o participante com o referio codigo do programa
	@Query(value = "select * from TB_PARTICIPANTE p JOIN TB_PROGRAMA pr ON pr.id = p.codigo_programa_fk " +
			"where pr.id = ?1", nativeQuery = true)
	List<Participante> listarParticipantes(Long codPrograma);

	Participante findByCpf(String cpf);

    //Busca o nome e o programa dos participantes com status ativo
    @Query(value = "SELECT new br.com.sis.rh.apiprogramaformacao.api.vo.dto.ParticipanteProgramaDto(c.nomeCandidato, tps.nomePrograma) " +
            "FROM TB_PARTICIPANTE p " +
            "JOIN TB_CANDIDATO c on c = p.candidato " +
            "JOIN TB_PROGRAMA tp on tp = p.programa " +
            "JOIN TB_PROCESSO_SELETIVO tps on tps = tp.processoSeletivo " +
            "where p.statusAtivo = ?1")
    List<ParticipanteProgramaDto> buscarParticipantesProgramaAtivos(StatusAtivo statusAtivo);
}
