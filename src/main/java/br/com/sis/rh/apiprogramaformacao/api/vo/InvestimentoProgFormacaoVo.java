package br.com.sis.rh.apiprogramaformacao.api.vo;

import lombok.Data;

/**
 * Nesta classe contém os objetos de valores da aplicação
 * faz ligação direta com a vue do front
 * 
 */

@Data
public class InvestimentoProgFormacaoVo {
	
	private Double investParticipantes;
	private Double investInstrutores;
	private Double investTotal;
	private Double investParticipantesPeriodoSelecionado;
	private Double investInstrutoresPeriodoSelecionado;
	private Double investTotalPeriodoSelecionado;
	
}
