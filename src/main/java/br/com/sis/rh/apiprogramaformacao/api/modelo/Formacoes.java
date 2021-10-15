package br.com.sis.rh.apiprogramaformacao.api.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.sis.rh.apiprogramaformacao.core.enums.StatusFormacao;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeFormacao() {
		return nomeFormacao;
	}

	public void setNomeFormacao(String nomeFormacao) {
		this.nomeFormacao = nomeFormacao;
	}
	
	public StatusFormacao getStatusFormacao() {
		return statusFormacao;
	}

}
