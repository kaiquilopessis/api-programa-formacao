package br.com.sis.rh.apiprogramaformacao.api.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.sis.rh.apiprogramaformacao.core.enums.StatusAtivo;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusEfetivo;
import lombok.Getter;

@Entity
@Table(name = "Participante")
@Getter
public class Participante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeParticipante;
	private String programaFormacao;

	@OneToOne
	private Formacoes formacoes;

	@Enumerated(EnumType.STRING)
	private StatusEfetivo efetivo;

	@Enumerated(EnumType.STRING)
	private StatusAtivo ativo;

	public Participante() {
	}

	public Participante(Long id, String nomeParticipante, String programaFormacao, StatusEfetivo efetivo,
			StatusAtivo ativo, int tamanhoLista) {
		this.id = id;
		this.nomeParticipante = nomeParticipante;
		this.programaFormacao = programaFormacao;
		this.efetivo = efetivo;
		this.ativo = ativo;
	}

}
