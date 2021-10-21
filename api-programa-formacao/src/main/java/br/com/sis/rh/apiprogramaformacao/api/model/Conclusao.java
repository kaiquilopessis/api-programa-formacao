package br.com.sis.rh.apiprogramaformacao.api.model;

import java.math.BigDecimal;
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
import javax.persistence.Table;

import br.com.sis.rh.apiprogramaformacao.core.enums.ResultadoConclusao;
import br.com.sis.rh.apiprogramaformacao.core.enums.StatusConclusao;

@Entity
@Table(name = "TB_CONCLUSAO")
public class Conclusao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//TODO Perguntar Guilherme Cargo Efetivado na tabela.

	@JoinColumn(name = "CODIGO_PARTICIPANTE")
	private Long codigoParticipante;

	@Column(name = "data_alteracao")
	private LocalDate dataAlteracao;

	@Column(name = "valor_salario_atual")
	private RemuneracaoPrograma cargo;


	@Column(name = "comprovante_rematricula") @Lob
	//private String comprovanteRematricula;
	private byte[] comprovanteRematricula;

	@Column(name = "resultado") @Enumerated(EnumType.STRING)
	private ResultadoConclusao resultado;

	@Column(name = "status_progresso") @Enumerated(EnumType.STRING)
	private StatusConclusao statusProgresso;

	@Column(name = "observacao")
	private String observacao;

	public Conclusao() {

	}
	
	public Conclusao(Long id, Long codigoParticipante, LocalDate dataAlteracao, RemuneracaoPrograma cargo,
			byte[] comprovanteRematricula, ResultadoConclusao resultado, StatusConclusao statusProgresso,
			String observacao) {
		this.id = id;
		this.codigoParticipante = codigoParticipante;
		this.dataAlteracao = dataAlteracao;
		this.cargo = cargo;
		this.comprovanteRematricula = comprovanteRematricula;
		this.resultado = resultado;
		this.statusProgresso = statusProgresso;
		this.observacao = observacao;
	}

	public ResultadoConclusao getResultado() {
		return resultado;
	}

	public void setResultado(ResultadoConclusao resultado) {
		this.resultado = resultado;
	}

	public StatusConclusao getStatusProgresso() {
		return statusProgresso;
	}

	public void setStatusProgresso(StatusConclusao statusProgresso) {
		this.statusProgresso = statusProgresso;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodigoParticipante() {
		return codigoParticipante;
	}

	public void setCodigoParticipante(Long codigoParticipante) {
		this.codigoParticipante = codigoParticipante;
	}

	public LocalDate getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(LocalDate dataAltarecao) {
		this.dataAlteracao = dataAltarecao;
	}
	
	public RemuneracaoPrograma getCargo() {
		return cargo;
	}

	public void setCargo(RemuneracaoPrograma cargo) {
		this.cargo = cargo;
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
