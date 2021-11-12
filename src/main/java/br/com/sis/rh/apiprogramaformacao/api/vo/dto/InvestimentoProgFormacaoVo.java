package br.com.sis.rh.apiprogramaformacao.api.vo.dto;

import lombok.Data;

/**
 * 
 * @author dkalbiak
 * 
 *         Nesta classe contém os objetos de valores da aplicação faz ligação
 *         com a vue do front preenchendo os valor dos cards na tela
 *         investimento
 * 
 */

//Generates getters for all fields Lombok

@Data
public class InvestimentoProgFormacaoVo {

	private Double investParticipantes;
	private Double investInstrutores;
	private Double investTotal;
	private Double investParticipantesPeriodoSelecionado;
	private Double investInstrutoresPeriodoSelecionado;
	private Double investTotalPeriodoSelecionado;

	private String formacao;
	private String turma;
	
}