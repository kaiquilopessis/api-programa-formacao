package br.com.sis.rh.apiprogramaformacao.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.ApiAluraDto;

@Entity
@Table(name = "tb_alura_compare")
public class AluraCompare {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String email;
	private Integer cargaHoraria;
	private Integer idCurso;

	public AluraCompare() {
	}

	public AluraCompare(Integer id, String email, Integer cargaHoraria, Integer idCurso) {
		this.id = id;
		this.email = email;
		this.cargaHoraria = cargaHoraria;
		this.idCurso = idCurso;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Integer getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}
	
	public static AluraCompare converter(ApiAluraDto apiAluraDto) {
		AluraCompare aluraCompare = new AluraCompare();
		aluraCompare.setIdCurso(apiAluraDto.getIdCurso());
		aluraCompare.setCargaHoraria(apiAluraDto.getCargaHoraria());
		aluraCompare.setEmail(apiAluraDto.getEmail());

		return aluraCompare;

	}
	
//	@Override
//	public boolean equals(Object obj) {
//		
//		return super.equals(obj);
//	}
	
	

}
