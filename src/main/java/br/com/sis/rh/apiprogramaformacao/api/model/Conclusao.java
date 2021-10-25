package br.com.sis.rh.apiprogramaformacao.api.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "TB_PROGRAMA")
public class Conclusao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Integer codigo;

	public Conclusao(Integer codigo) {
		this.codigo = codigo;
	}

	public Conclusao() {
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

}
