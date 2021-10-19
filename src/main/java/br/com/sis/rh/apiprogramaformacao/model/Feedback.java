package br.com.sis.rh.apiprogramaformacao.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


	@Entity
	@Table(name = "TB_FEEDBACK")
	public class Feedback {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "participante", fetch = FetchType.LAZY)
		@Column(length = 12, name = "codigo_participante", nullable = false)
		private Participante codigoParticipante;
		
		@Column(name = "qnt_horas", nullable = false)
		private Integer qntHoras;
		
		@Column(name = "mes_avaliado", nullable = false)
		private Integer mes_avaliado;
		
		@Column(name = "semana_avaliada", nullable = false)
		private Integer semana_avaliada;
		
		@Column(name = "data_registro", nullable = false)
		private LocalDateTime data_registro;
		
		@Column(name = "hr_min_semana", nullable = false)
		private Integer hr_min_semana;
		
		public Feedback() {
			
		}	
	}
