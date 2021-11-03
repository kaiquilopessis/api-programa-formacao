package br.com.sis.rh.apiprogramaformacao.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusAtivo;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusEfetivo;

public interface ParticipanteRepository extends JpaRepository<Participante, String> {
	
	// Método que devolve uma lista somente com os participantes com status EFETIVADO
	@Query(value = "SELECT p FROM TB_PARTICIPANTE p WHERE status_efetivado = ?1")
	List<Participante> findByStatusEfetivo(StatusEfetivo status_efetivado);
	
	// Método que devolve uma lista somente os participantes com status ATIVO
	@Query(value = "SELECT p FROM TB_PARTICIPANTE p WHERE status_ativo = ?1")
	List<Participante> findByStatusAtivo(StatusAtivo status_ativo);
	
	// Método que devolve a contagem total de participantes com status ATIVO
	@Query(value = "SELECT COUNT(p) FROM TB_PARTICIPANTE p WHERE status_ativo = 'ATIVO'")
	Integer totalParticipantesAtivos();
	
	// Método que devolve a contagem total de participantes com status EFETIVADO
	@Query(value = "SELECT COUNT(p) FROM TB_PARTICIPANTE p WHERE status_efetivado = 'EFETIVADO'")
	Integer totalEfetivados();

	@Query(value = "select count(*) from TB_PARTICIPANTE p JOIN TB_PROGRAMA prog ON p.codigo_programa_fk = prog.id where p.status_ativo = 'ATIVO' AND prog.nome = ?1 and prog.nome_turma = ?2",  nativeQuery = true)
	Integer listaParticipantesAtivos(String nome, String turma);

	@Query(value = "select count(*) from TB_PARTICIPANTE p JOIN TB_PROGRAMA prog ON p.codigo_programa_fk = prog.id where p.status_ativo = 'EFETIVADO' AND prog.nome = ?1 and prog.nome_turma = ?2", nativeQuery = true)
	Integer listaParticipantesEfetivados(String nome, String turma);
	
	// busca o participante com o referio codigo do programa
	@Query("select p from TB_PARTICIPANTE p where codigo_programa_fk = ?1")
	List<Participante> listarParticipantes(Long codPrograma);

	Participante findByCpf(String cpf);
	
}
