package br.com.sis.rh.apiprogramaformacao.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_INVESTIMENTO")
public class Investimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToMany
	@JoinColumn(name = "codigo_participante_fk", referencedColumnName = "cpf_participante", nullable = false)
	private Participante participante;
	@Column(name = "data_registro")
	private LocalDate dataRegistro;
}
