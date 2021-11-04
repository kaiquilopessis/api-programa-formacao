package br.com.sis.rh.apiprogramaformacao.api.model;

/**
 * Esta classe faz a ligação com a Tabela conclusão contida na database programadeformacao
 */

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;


// Info. da tabela de conclusão
@Entity(name = "TB_CONCLUSAO")
@Data
public class Conclusao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")

	private Long id;
	@Column(name = "data_alteracao")
	private LocalDate dataAlteracao;

	@ManyToOne
	@JoinColumn(name = "codigo_participante_fk")
	private Participante participante;

}
