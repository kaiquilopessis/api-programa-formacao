package br.com.sis.rh.apiprogramaformacao.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_REMUNERACAO_PROGRAMA")
public class RemuneracaoPrograma {
	
	@Id @Column(name = "ID") @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "CARGO")
	private String cargo;
	
	public RemuneracaoPrograma (String cargo) {
		this.cargo = cargo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
}
