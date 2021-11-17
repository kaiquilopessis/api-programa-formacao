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
	@Query(value = "select c.nome as nomeParticipante, ps.nome as nomePrograma " +
			"from TB_PARTICIPANTE p " +
			"JOIN TB_CANDIDATO c on c.id = p.codigo_candidato_fk " +
			"JOIN TB_PROGRAMA prog on prog.id = p.codigo_programa_fk " +
			"JOIN TB_PROCESSO_SELETIVO ps on ps.id = c.processo_seletivo_fk " +
			"where status_efetivado = 'EFETIVADO'", nativeQuery = true)
	List<ParticipanteProgramaDto> findByStatusEfetivo(StatusEfetivo status_efetivado);
	
	// Método que devolve uma lista somente os participantes com status ATIVO
	@Query(value = "select c.nome as nomeParticipante, ps.nome as nomePrograma " +
			"from TB_PARTICIPANTE p " +
			"JOIN TB_CANDIDATO c on c.id = p.codigo_candidato_fk " +
			"JOIN TB_PROGRAMA prog on prog.id = p.codigo_programa_fk " +
			"JOIN TB_PROCESSO_SELETIVO ps on ps.id = c.processo_seletivo_fk " +
			"where p.status_ativo = 'ATIVO'", nativeQuery = true)
	List<ParticipanteProgramaDto> findByStatusAtivo(StatusAtivo status_ativo);
	
	// Método que devolve a contagem total de participantes com status ATIVO
	@Query(value = "SELECT COUNT(p) FROM TB_PARTICIPANTE p WHERE status_ativo = 'ATIVO'")
	Integer totalParticipantesAtivos();
	
	// Método que devolve a contagem total de participantes com status EFETIVADO
	@Query(value = "SELECT COUNT(p) FROM TB_PARTICIPANTE p WHERE status_efetivado = 'EFETIVADO'")
	Integer totalEfetivados();

	// Busca os participantes ativos no programa e na turma(tela de conclusão)
	@Query(value = "select count(*) from TB_PARTICIPANTE p JOIN TB_PROGRAMA prog ON p.codigo_programa_fk = prog.id where p.status_ativo = 'ATIVO' AND prog.nome = ?1 and prog.nome_turma = ?2",  nativeQuery = true)
	Integer listaParticipantesAtivos(String nome, String turma);

	// Busca os participantes efetivados no programa e na turma(tela de conclusão)
	@Query(value = "select count(*) from TB_PARTICIPANTE p JOIN TB_PROGRAMA prog ON p.codigo_programa_fk = prog.id where p.status_efetivado = 'EFETIVADO' AND prog.nome = ?1 and prog.nome_turma = ?2", nativeQuery = true)
	Integer listaParticipantesEfetivados(String nome, String turma);
	
	// busca o participante com o referio codigo do programa
	@Query("select p from TB_PARTICIPANTE p where codigo_programa_fk = ?1")
	List<Participante> listarParticipantes(Long codPrograma);

	Participante findByCpf(String cpf);
	
}
