package br.com.sis.rh.apiprogramaformacao.core.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.sis.rh.apiprogramaformacao.api.model.Ciclo;
import br.com.sis.rh.apiprogramaformacao.api.model.Participante;
import br.com.sis.rh.apiprogramaformacao.api.model.Programa;
import br.com.sis.rh.apiprogramaformacao.api.model.Remuneracao;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.InvestimentoProgFormacaoVo;
import br.com.sis.rh.apiprogramaformacao.core.repository.CicloRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ParticipanteRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.ProgramaRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.RemuneracaoInstrutorRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.RemuneracaoRepository;

/**
 * 
 * @author dkalbiak
 *
 *         Nesta classe contem as regras de negocios e servicos da aplicações
 *         referentes a pagina de relatorio de investimentos Os métodos que
 *         compõem a classe, processam os dados dos três cards contidos na parte
 *         inferior da pagina após o filtro selecionado
 */
@org.springframework.stereotype.Service
public class InvestimentoFiltroPeriodoService {

	private Long mesAnterior;
	private Long mesPosterior;
	private Long diferencaMes;
	double totalSalarioInstrutor;

	// injeções de dependencias

	@Autowired
	private ProgramaRepository programaRepository;
	@Autowired
	private ParticipanteRepository participantesRepository;
	@Autowired
	private CicloRepository cicloRepository;
	@Autowired
	private RemuneracaoRepository remuneracaoRepository;
	@Autowired
	private RemuneracaoInstrutorRepository remuneracaoInstrutorRepository;

	// Metodo chamado no controller para popular os cards, contém a sequencia de
	// valores a serem utilizados no vue.js
	public InvestimentoProgFormacaoVo popularCards(LocalDate dataInicio, LocalDate dataFim, String nomePrograma,
			String nomeTurma) {
		String tumaFormatada = nomeTurma.replace("+", " ");
		InvestimentoProgFormacaoVo investimentoProgFormacaoVo = new InvestimentoProgFormacaoVo();
		investimentoProgFormacaoVo = investParticipantesPeriodo(dataInicio, dataFim, nomePrograma, tumaFormatada,
				investimentoProgFormacaoVo);

		investimentoProgFormacaoVo = investInstrutorPeriodo(dataInicio, dataFim, nomePrograma, tumaFormatada, investimentoProgFormacaoVo);
		investimentoProgFormacaoVo
				.setInvestTotalPeriodoSelecionado(investimentoProgFormacaoVo.getInvestInstrutoresPeriodoSelecionado()
						.add(investimentoProgFormacaoVo.getInvestParticipantesPeriodoSelecionado()) );

		investimentoProgFormacaoVo.setFormacao(nomePrograma);
		investimentoProgFormacaoVo.setTurma(tumaFormatada);
		
		return investimentoProgFormacaoVo;
	}

	// esta método processa os dados gerais e totais dos participantes de acordo com
	// o programa, turma e data selecionados
	public InvestimentoProgFormacaoVo investParticipantesPeriodo(LocalDate dataInicio, LocalDate dataFim,
			String nomePrograma, String nomeTurma, InvestimentoProgFormacaoVo investimentoProgFormacaoVo) {
		investimentoProgFormacaoVo.setInvestParticipantesPeriodoSelecionado(BigDecimal.ZERO);

		Programa programa = (Programa) programaRepository.listarProgramaSemData(nomePrograma, nomeTurma);
		List<Participante> participantes = (List<Participante>) participantesRepository
				.listarParticipantes(programa.getId());
		participantes.forEach(participante -> {

			System.out.println(participante.getCpf());
			List<Ciclo> conclusoes = cicloRepository.listarConclusoes(participante.getCpf());

			conclusoes.forEach(conclusao -> {
				System.out.println("Entrei no laço");

				Remuneracao remuneracao = remuneracaoRepository
						.findBySalario(conclusao.getParticipante().getRemuneracaoPrograma().getId());

				if (!participante.getCpf().equals(conclusao.getParticipante().getCpf())) {
					diferencaMes = dataInicio.until(dataFim, ChronoUnit.MONTHS);
					investimentoProgFormacaoVo.setInvestParticipantesPeriodoSelecionado(
							(remuneracao.getAlura().add(remuneracao.getBeneficioLegislacao()).add(remuneracao.getBeneficio())
									.add(remuneracao.getBolsa()).add(remuneracao.getConvenio()).add(remuneracao.getHoraExtra()) 
									.add(remuneracao.getRemunEsporadica()).add(remuneracao.getRemunExtra())).multiply(new BigDecimal(diferencaMes)) 
									.add(investimentoProgFormacaoVo.getInvestParticipantesPeriodoSelecionado()));
					System.out.println("Passei por aqui...");
				}

				if (dataInicio.isBefore(conclusao.getDataAlteracao())) {
					mesAnterior = conclusao.getDataAlteracao().until(dataInicio, ChronoUnit.MONTHS);
					System.out.println("mes anterior " + mesAnterior);
					investimentoProgFormacaoVo.setInvestParticipantesPeriodoSelecionado(
							(remuneracao.getAlura().add(remuneracao.getBeneficioLegislacao()).add(remuneracao.getBeneficio()) 
									.add(remuneracao.getBolsa()).add(remuneracao.getConvenio()).add(remuneracao.getHoraExtra()) 
									.add(remuneracao.getRemunEsporadica()).add(remuneracao.getRemunExtra())).multiply(new BigDecimal(mesAnterior)) 
									.add(investimentoProgFormacaoVo.getInvestParticipantesPeriodoSelecionado()));

				}
				if (dataFim.isAfter(conclusao.getDataAlteracao())) {
					mesPosterior = conclusao.getDataAlteracao().until(dataFim, ChronoUnit.MONTHS);
					System.out.println("mes posterior " + mesPosterior);
					investimentoProgFormacaoVo.setInvestParticipantesPeriodoSelecionado(
							(remuneracao.getAlura().add(remuneracao.getBeneficioLegislacao()).add(remuneracao.getBeneficio())
									.add(remuneracao.getBolsa()).add(remuneracao.getConvenio()).add(remuneracao.getHoraExtra()) 
									.add(remuneracao.getRemunEsporadica()).add(remuneracao.getRemunExtra())).multiply(new BigDecimal(mesPosterior)) 
									.add(investimentoProgFormacaoVo.getInvestParticipantesPeriodoSelecionado()));

				}

			});

		});

		return investimentoProgFormacaoVo;
	}

	// este metodo processa os dados dos custos totais com instrutores de acordo com
	// o programa, turma e data selecionada
	public InvestimentoProgFormacaoVo investInstrutorPeriodo(LocalDate dataInicio, LocalDate dataFim,
			String nomePrograma,String nomeTurma,InvestimentoProgFormacaoVo investimentoProgFormacaoVo) {

		BigDecimal salarioInstrutores = remuneracaoInstrutorRepository.calcularSalarioInstrutoresPeriodo(nomePrograma, nomeTurma, dataInicio, dataFim);
		investimentoProgFormacaoVo.setInvestInstrutoresPeriodoSelecionado(salarioInstrutores);

		return investimentoProgFormacaoVo;
	}

	public InvestimentoProgFormacaoVo investimentoTotalDoPeriodo(InvestimentoProgFormacaoVo investTotal) {

		BigDecimal investTotal2 = investTotal.getInvestInstrutoresPeriodoSelecionado()
				.add(investTotal.getInvestParticipantesPeriodoSelecionado()) ;

		investTotal.setInvestTotalPeriodoSelecionado(investTotal2);

		return investTotal;
	}
}