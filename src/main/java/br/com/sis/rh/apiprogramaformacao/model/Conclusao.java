package br.com.sis.rh.apiprogramaformacao.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table
public class Conclusao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@JoinColumn(name = "codigo_participante_fk", nullable = false)
	private String codigo_participante_fk;
	
	@Column(name = "reajuste_salario", nullable = false)
	private Integer reajuste_salario;
	
	@Column(name = "data_alteracao")
	private LocalDateTime data_alteracao;
	
	@Column(name = "valor_salario_atual", nullable = false)
	private BigDecimal valor_salario_atual;
	
	@Column(name = "comprovante_rematricula", length = 255, nullable = false)
	private String comprovante_rematricula;
	
}
