package br.com.sis.rh.apiprogramaformacao.api.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.sis.rh.apiprogramaformacao.core.enums.StatusFormacao;
import lombok.Getter;

@Entity
@Table(name = "Formacoes")
@Getter
public class Formacoes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeFormacao;

	@OneToMany
	private List<Participante> participante;

	@Enumerated(EnumType.STRING)
	private StatusFormacao statusFormacao;

	public Formacoes() {
	}

	public Formacoes(Long id, String nomeFormacao, StatusFormacao statusFormacao) {
		this.id = id;
		this.nomeFormacao = nomeFormacao;
		this.statusFormacao = statusFormacao;
	}

}
