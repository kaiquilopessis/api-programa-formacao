package br.com.sis.rh.apiprogramaformacao.core.service;

/**
 * Nesta classe contem as regras de negocios e servicos da aplicações referentes a pagina de relatorio de investimentos
 * Os métodos que compõem a classe, processam os dados dos três cards contidos na parte superior da pagina
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sis.rh.apiprogramaformacao.api.model.Conclusao;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.api.model.Remuneracao;
import br.com.sis.rh.apiprogramaformacao.api.vo.InvestimentoProgFormacaoVo;
import br.com.sis.rh.apiprogramaformacao.core.repository.ConclusaoRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ProgramaRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.RemuneracaoRepository;

@Service
public class InvestimentosProgFormacaoService {

	// injeções de dependências

	@Autowired
	private RemuneracaoRepository remuneracaoRepository;
	@Autowired
	private ProgramaRepository programaRepository;
	@Autowired
	private ParticipanteRepository participantesRepository;
	@Autowired
	private ConclusaoRepository conclusaoRepository;

	// Metodo chamado no controller para popular os cards, contém a sequencia de
	// valores a serem utilizados no vue.js
	public InvestimentoProgFormacaoVo popularCardsSuperiores(String nomePrograma, String nomeTurma) {

		InvestimentoProgFormacaoVo investimentoProgFormacaoVo = new InvestimentoProgFormacaoVo();

		investimentoProgFormacaoVo = investimentosParticipantes(nomePrograma, nomeTurma, investimentoProgFormacaoVo);

		investimentoProgFormacaoVo = investimentoInstrutores(nomePrograma, nomeTurma, investimentoProgFormacaoVo);

		investimentoProgFormacaoVo = investimentoTotal(investimentoProgFormacaoVo);

		return investimentoProgFormacaoVo;

	}

	// esta método processa os dados gerais e totais dos participantes de acordo com
	// o programa e turma selecionados
	public InvestimentoProgFormacaoVo investimentosParticipantes(String nomePrograma, String nomeTurma,
			InvestimentoProgFormacaoVo investParticipantes) {

		Programa programa = (Programa) programaRepository.listarProgramaSemData(nomePrograma, nomeTurma);
		List<Participante> participantes = participantesRepository.listarParticipantes(programa.getId());

		investParticipantes.setInvestParticipantes(0.0);
		participantes.forEach(participante -> {
			System.out.println(participante.getCpf());

			List<Conclusao> conclusoes = conclusaoRepository.listarConclusoes(participante.getCpf());
			System.out.println(conclusoes.size());

			conclusoes.forEach(conclusao -> {

				Remuneracao remuneracao = remuneracaoRepository
						.findBySalario(conclusao.getParticipante().getRemuneracao().getId());

				investParticipantes.setInvestParticipantes(investParticipantes.getInvestParticipantes()
						+ remuneracao.getBolsaAux() + remuneracao.getBeneficios() + remuneracao.getConvenio()
						+ remuneracao.getHoraExtra() + remuneracao.getBeneficioLegislacao()
						+ remuneracao.getRemuExporadica() + remuneracao.getAlura());

			});

		});

		return investParticipantes;
	}

	// este metodo processa os dados dos custos totais com instrutores de acordo com
	// o programa e a turma selecionada
	public InvestimentoProgFormacaoVo investimentoInstrutores(String nomePrograma, String nomeTurma,
			InvestimentoProgFormacaoVo investInstrutores) {

		List<Double> salarioInstrutores = programaRepository.calcularSalarioInstrutores(nomePrograma, nomeTurma);

		investInstrutores.setInvestInstrutores(0.0);

		salarioInstrutores.forEach(salario -> {
			investInstrutores.setInvestInstrutores(investInstrutores.getInvestInstrutores() + salario);
		});

		return investInstrutores;
	}

	// este método faz a soma dos investimentos dos participantes e instrutores,
	// gerento o total geral
	public InvestimentoProgFormacaoVo investimentoTotal(InvestimentoProgFormacaoVo investTotal) {

		double investTotal2 = investTotal.getInvestParticipantes() + investTotal.getInvestInstrutores();

		investTotal.setInvestTotal(investTotal2);

		return investTotal;

	}

}
