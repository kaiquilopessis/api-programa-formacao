package br.com.sis.rh.apiprogramaformacao.api.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe/Entidade que representa a tabela TB_AVALIACOES da base de dados,
 * os métodos getter e setter estão implementados pelo Lombok utilizando
 * a anotação @Data
 */

@Entity(name = "TB_NOTAS_AVALIACOES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Avaliacoes {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nota_tecnica")
	private Double notaTecnica;
	@JoinColumn(name = "nota_comportamental_fk")
	@OneToOne(fetch = FetchType.LAZY)
	private AvaliacaoDesempenho avaliacaoDesempenho;
	@Column(name = "nota_praticas_ageis")
	private Double notaPraticasAgeis;
	@Column(name = "nota_lideranca")
	private Double notaLideranca;
	@Column(name = "nota_negocio")
	private Double notaNegocio;
	@ManyToOne
	@JoinColumn(name = "codigo_participante_fk")
	private Participante participante;

	
}
