package br.com.sis.rh.apiprogramaformacao.api.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "TB_INVESTIMENTO")
@Getter
@Setter
public class Investimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	@JoinColumn(name = "codigo_participante_fk", referencedColumnName = "cpf_participante", nullable = false)
	private Participante participante;
	@Column(name = "data_registro")
	private LocalDate dataRegistro;
}
