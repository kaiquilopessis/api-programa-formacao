package br.com.sis.rh.apiprogramaformacao.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sis.rh.apiprogramaformacao.api.model.Avaliacoes;

public interface AvaliacaoRepository extends JpaRepository<Avaliacoes, Long>  {

	@Query(value = "select * from TB_NOTAS_AVALIACOES av JOIN TB_AVALIACAO_DESEMPENHO ad ON " +
			"av.nota_comportamental_fk = ad.id where av.id = (select max(id) from TB_NOTAS_AVALIACOES " +
			"where codigo_participante_fk = av.codigo_participante_fk group by codigo_participante_fk)"
			, nativeQuery = true)
	List<Avaliacoes> buscarNotasMaisRecentes();
	
	@Query(value = "select top(1) count(codigo_participante_fk) from TB_NOTAS_AVALIACOES "
			+ "group by codigo_participante_fk having count(codigo_participante_fk) > 1 ", nativeQuery =  true)
	Integer buscaNumeroCiclo();
}
