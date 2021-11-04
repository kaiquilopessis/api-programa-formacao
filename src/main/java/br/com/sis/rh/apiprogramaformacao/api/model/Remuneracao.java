package br.com.sis.rh.apiprogramaformacao.api.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

/**
 * 
 * @author dkalbiak
 * 
 *         Esta classe faz a ligação com a Tabela Remuneração contida na
 *         database programadeformacao
 */
@Entity(name = "TB_REMUNERACAO")
//Generates getters for all fields Lombok
@Data
public class Remuneracao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "bolsa_aux")
	private Double bolsaAux;

	@Column(name = "beneficios")
	private Double beneficios;

	@Column(name = "convenio")
	private Double convenio;

	@Column(name = "hr_extra")
	private Double horaExtra;

	@Column(name = "beneficio_legislacao")
	private Double beneficioLegislacao;

	@Column(name = "remun_exporadica")
	private Double remuExporadica;

	@Column(name = "remun_extra")
	private Double remuExtra;

	@Column(name = "alura")
	private Double alura;

	@OneToMany(fetch = FetchType.LAZY)
	private List<Participante> participante;
}