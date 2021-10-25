package br.com.sis.rh.apiprogramaformacao.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirecionamentoService {

	@Autowired
	private FiltroConclusao filtroConclusao;
	
	public Integer Direcionar(String formacao, String turma, String escopo) {
		if(escopo.equals("alura")) {
			System.out.println("alura");
		}
		else if(escopo.equals("avaliacao")) {
			System.out.println("avaliação");
		}
		else if(escopo.equals("conclusao")) {
			System.out.println("formatou " + formacao);
			Integer total = filtroConclusao.listaParticipantesAtivosPorFormacao(formacao);
			return total;
		}
		else if(escopo.equals("investimento")){
			System.out.println("Investimentos");
		}
		return null;
	}
}
