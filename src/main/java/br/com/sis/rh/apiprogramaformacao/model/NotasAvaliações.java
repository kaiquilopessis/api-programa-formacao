package br.com.sis.rh.apiprogramaformacao.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "TB_NOTAS_AVALIACOES")
public class NotasAvaliações {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@JoinColumn(name = "codigo_participante", nullable = false)
	private String codigo_participante;
	
	@Column(name = "nota_tecnica", length = 3)
	private BigDecimal nota_tecnica;
	
	@Column(name = "nota_comportamental", length = 3)
	private BigDecimal nota_comportamental;
	
	@Column(name = "nota_praticas_ageis", length = 3)
	private BigDecimal nota_praticas_ageis;
	
	@Column(name = "nota_liderança", length = 3)
	private BigDecimal nota_liderança;
	
	@Column(name = "nota_negocio", length = 3)
	private BigDecimal nota_negocio;
	
	
}
