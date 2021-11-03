package br.com.sis.rh.apiprogramaformacao.core.service;

/**
 * Nesta classe contem as regras de negocios e servicos da aplicações referentes a pagina de relatorio de investimentos
 * Os métodos que compõem a classe, processam os dados dos três cards contidos na parte inferior da pagina após o filtro selecionado
 */

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.sis.rh.apiprogramaformacao.api.model.Conclusao;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.api.model.Remuneracao;
import br.com.sis.rh.apiprogramaformacao.api.vo.InvestimentoProgFormacaoVo;
import br.com.sis.rh.apiprogramaformacao.core.repository.ConclusaoRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipantesRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ProgramaRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.RemuneracaoRepository;

@org.springframework.stereotype.Service
public class ServiceFiltroPeriodo {

	private Long mesAnterior;
	private Long mesPosterior;
	private Long diferencaMes;
	double totalSalarioInstrutor;

	// injeções de dependencias

	@Autowired
	private ProgramaRepository programaRepository;
	@Autowired
	private ParticipantesRepository participantesRepository;
	@Autowired
	private ConclusaoRepository conclusaoRepository;
	@Autowired
	private RemuneracaoRepository remuneracaoRepository;

	// Metodo chamado no controller para popular os cards, contém a sequencia de
	// valores a serem utilizados no vue.js
	public InvestimentoProgFormacaoVo popularCards(LocalDate dataInicio, LocalDate dataFim, String nomePrograma,
			String nomeTurma) {
		InvestimentoProgFormacaoVo investimentoProgFormacaoVo = new InvestimentoProgFormacaoVo();
		investimentoProgFormacaoVo = investParticipantesPeriodo(dataInicio, dataFim, nomePrograma, nomeTurma,
				investimentoProgFormacaoVo);

		investimentoProgFormacaoVo = investInstrutorPeriodo(nomePrograma, nomeTurma, investimentoProgFormacaoVo);
		investimentoProgFormacaoVo
				.setInvestTotalPeriodoSelecionado(investimentoProgFormacaoVo.getInvestInstrutoresPeriodoSelecionado()
						+ investimentoProgFormacaoVo.getInvestParticipantesPeriodoSelecionado());

		return investimentoProgFormacaoVo;
	}

	// esta método processa os dados gerais e totais dos participantes de acordo com
	// o programa, turma e data selecionados
	public InvestimentoProgFormacaoVo investParticipantesPeriodo(LocalDate dataInicio, LocalDate dataFim,
			String nomePrograma, String nomeTurma, InvestimentoProgFormacaoVo investimentoProgFormacaoVo) {
		investimentoProgFormacaoVo.setInvestParticipantesPeriodoSelecionado(0.0);

		Programa programa = (Programa) programaRepository.ListarPrograma(dataInicio, dataFim, nomePrograma, nomeTurma);
		List<Participante> participantes = (List<Participante>) participantesRepository
				.listarParticipantes(programa.getId());
		participantes.forEach(participante -> {

			System.out.println(participante.getCpf());
			List<Conclusao> conclusoes = conclusaoRepository.listarConclusoes(participante.getCpf());

			conclusoes.forEach(conclusao -> {
				System.out.println("Entrei no laço");

				Remuneracao remuneracao = remuneracaoRepository
						.findBySalario(conclusao.getParticipante().getRemuneracao().getId());

				if (!participante.getCpf().equals(conclusao.getParticipante().getCpf())) {
					diferencaMes = dataInicio.until(dataFim, ChronoUnit.MONTHS);
					investimentoProgFormacaoVo.setInvestParticipantesPeriodoSelecionado(
							(remuneracao.getAlura() + remuneracao.getBeneficioLegislacao() + remuneracao.getBeneficios()
									+ remuneracao.getBolsaAux() + remuneracao.getConvenio() + remuneracao.getHoraExtra()
									+ remuneracao.getRemuExporadica() + remuneracao.getRemuExtra()) * diferencaMes
									+ investimentoProgFormacaoVo.getInvestParticipantesPeriodoSelecionado());
					System.out.println("Passei por aqui...");
				}

				if (dataInicio.isBefore(conclusao.getDataAlteracao())) {
					mesAnterior = conclusao.getDataAlteracao().until(dataInicio, ChronoUnit.MONTHS);
					System.out.println("mes anterior " + mesAnterior);
					investimentoProgFormacaoVo.setInvestParticipantesPeriodoSelecionado(
							(remuneracao.getAlura() + remuneracao.getBeneficioLegislacao() + remuneracao.getBeneficios()
									+ remuneracao.getBolsaAux() + remuneracao.getConvenio() + remuneracao.getHoraExtra()
									+ remuneracao.getRemuExporadica() + remuneracao.getRemuExtra()) * mesAnterior
									+ investimentoProgFormacaoVo.getInvestParticipantesPeriodoSelecionado());

				}
				if (dataFim.isAfter(conclusao.getDataAlteracao())) {
					mesPosterior = conclusao.getDataAlteracao().until(dataFim, ChronoUnit.MONTHS);
					System.out.println("mes posterior " + mesPosterior);
					investimentoProgFormacaoVo.setInvestParticipantesPeriodoSelecionado(
							(remuneracao.getAlura() + remuneracao.getBeneficioLegislacao() + remuneracao.getBeneficios()
									+ remuneracao.getBolsaAux() + remuneracao.getConvenio() + remuneracao.getHoraExtra()
									+ remuneracao.getRemuExporadica() + remuneracao.getRemuExtra()) * mesPosterior
									+ investimentoProgFormacaoVo.getInvestParticipantesPeriodoSelecionado());

				}

			});

		});

		return investimentoProgFormacaoVo;
	}

	// este metodo processa os dados dos custos totais com instrutores de acordo com
	// o programa, turma e data selecionada
	public InvestimentoProgFormacaoVo investInstrutorPeriodo(String nomePrograma, String nomeTurma,
			InvestimentoProgFormacaoVo investimentoProgFormacaoVo) {
		investimentoProgFormacaoVo.setInvestInstrutoresPeriodoSelecionado(0.0);

		List<Double> salarioInstrutores = programaRepository.calcularSalarioInstrutores(nomePrograma, nomeTurma);

		salarioInstrutores.forEach(salario -> {
			investimentoProgFormacaoVo.setInvestInstrutoresPeriodoSelecionado(
					investimentoProgFormacaoVo.getInvestInstrutoresPeriodoSelecionado() + salario);

		});

		return investimentoProgFormacaoVo;
	}

	public InvestimentoProgFormacaoVo investimentoTotalDoPeriodo(InvestimentoProgFormacaoVo investTotal) {

		double investTotal2 = investTotal.getInvestInstrutoresPeriodoSelecionado()
				+ investTotal.getInvestParticipantesPeriodoSelecionado();

		investTotal.setInvestTotalPeriodoSelecionado(investTotal2);

		return investTotal;

	}

}
