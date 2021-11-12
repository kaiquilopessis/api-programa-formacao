package br.com.sis.rh.apiprogramaformacao.api.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 * 
 * @author dkalbiak
 *
 *         Esta classe faz a ligação com a Tabela conclusão contida na database
 *         programadeformacao
 */
@Entity(name = "TB_CONCLUSAO")
//Generates getters for all fields Lombok
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(LocalDate dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

}