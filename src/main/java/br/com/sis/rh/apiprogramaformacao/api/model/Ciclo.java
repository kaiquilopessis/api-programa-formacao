package br.com.sis.rh.apiprogramaformacao.api.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.com.sis.rh.apiprogramaformacao.core.enums.ResultadoCiclo;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusCiclo;

@Entity(name = "TB_CONCLUSAO")
public class Ciclo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "CODIGO_PARTICIPANTE_FK")
	private Participante participante;

	@Column(name = "DATA_ALTERACAO")
	private LocalDate dataAlteracao;

	@OneToOne
	@JoinColumn(name = "fk_codigo_remun")
	private Remuneracao cargoPrograma;

	@Column(name = "CARGO_EFETIVADO")
	private String cargoEfetivado;

	@Column(name = "COMPROVANTE_REMATRICULA")
	@Lob
	private byte[] comprovanteRematricula;

	@Column(name = "RESULTADO")
	@Enumerated(EnumType.STRING)
	private ResultadoCiclo resultado;

	@Column(name = "STATUS_PROGRESSO")
	@Enumerated(EnumType.STRING)
	private StatusCiclo statusProgresso;

	@Column(name = "OBSERVACAO")
	private String observacao;

	public Ciclo() {

	}

	// Progressive
	public Ciclo(Participante participante, LocalDate dataAlteracao, Remuneracao cargo, byte[] comprovanteRematricula,
			ResultadoCiclo resultado, StatusCiclo statusProgresso) {
		this.participante = participante;
		this.dataAlteracao = dataAlteracao;
		this.cargoPrograma = cargo;
		this.comprovanteRematricula = comprovanteRematricula;
		this.resultado = resultado;
		this.statusProgresso = statusProgresso;
	}

	// Final
	public Ciclo(Participante participante, LocalDate dataAlteracao, String cargo, byte[] comprovanteRematricula,
			ResultadoCiclo resultado, StatusCiclo statusProgresso, String observacao) {
		this.participante = participante;
		this.dataAlteracao = dataAlteracao;
		this.cargoEfetivado = cargo;
		this.comprovanteRematricula = comprovanteRematricula;
		this.resultado = resultado;
		this.statusProgresso = statusProgresso;
		this.observacao = observacao;
	}

	public ResultadoCiclo getResultado() {
		return resultado;
	}

	public void setResultado(ResultadoCiclo resultado) {
		this.resultado = resultado;
	}

	public StatusCiclo getStatusProgresso() {
		return statusProgresso;
	}

	public void setStatusProgresso(StatusCiclo statusProgresso) {
		this.statusProgresso = statusProgresso;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	public LocalDate getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(LocalDate dataAltarecao) {
		this.dataAlteracao = dataAltarecao;
	}

	public Remuneracao getCargoPrograma() {
		return cargoPrograma;
	}

	public void setCargoPrograma(Remuneracao cargoPrograma) {
		this.cargoPrograma = cargoPrograma;
	}

	public String getCargoEfetivado() {
		return cargoEfetivado;
	}

	public void setCargoEfetivado(String cargoEfetivado) {
		this.cargoEfetivado = cargoEfetivado;
	}

	public byte[] getComprovanteRematricula() {
		return comprovanteRematricula;
	}

	public void setComprovanteRematricula(byte[] comprovanteRematricula) {
		this.comprovanteRematricula = comprovanteRematricula;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}
