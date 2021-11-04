package br.com.sis.rh.apiprogramaformacao.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

/**
 * Classe/Entidade que representa a tabela TB_AVALIACOES da base de dados,
 * os métodos getter e setter estão implementados pelo Lombok utilizando
 * a anotação @Data
 */

@Entity(name = "TB_NOTAS_AVALIACOES")
@Data
public class Avaliacoes {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nota_tecnica")
	private Double notaTecnica;
	@Column(name = "nota_comportamental")
	private Double notaComportamental;
	@Column(name = "nota_praticas_ageis")
	private Double notaPraticasAgeis;
	@Column(name = "nota_lideranca")
	private Double notaLideranca;
	@Column(name = "nota_negocio")
	private Double notaNegocio;
	@ManyToOne
	@JoinColumn(name = "codigo_participante_fk")
	private Participante participante;
	
	public Avaliacoes() {}

	public Avaliacoes(Long id, Double nota_tecnica, Double nota_comportamental,
			Double nota_praticas_ageis, Double nota_lideranca, Double nota_negocio) {
		this.id = id;
		this.notaTecnica = nota_tecnica;
		this.notaComportamental = nota_comportamental;
		this.notaPraticasAgeis = nota_praticas_ageis;
		this.notaLideranca = nota_lideranca;
		this.notaNegocio = nota_negocio;
	}

	
}
