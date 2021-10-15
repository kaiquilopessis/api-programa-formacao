package br.com.sis.rh.apiprogramaformacao.api.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.sis.rh.apiprogramaformacao.core.enums.StatusAtivo;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusEfetivo;
import lombok.Getter;

@Entity
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Participante other = (Participante) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public String getNomeParticipante() {
		return nomeParticipante;
	}

	public String getProgramaFormacao() {
		return programaFormacao;
	}

	public Formacoes getFormacoes() {
		return formacoes;
	}

	public StatusEfetivo getEfetivo() {
		return efetivo;
	}

	public StatusAtivo getAtivo() {
		return ativo;
	}

}

