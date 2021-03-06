package br.com.sis.rh.apiprogramaformacao.core.service.investimentos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.sis.rh.apiprogramaformacao.api.model.informacoesgerais.Participante;
import br.com.sis.rh.apiprogramaformacao.api.model.informacoesgerais.Programa;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.InvestimentoProgFormacaoVo;
import br.com.sis.rh.apiprogramaformacao.core.repository.cargos.RemuneracaoInstrutorRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.informacoesgerais.ParticipanteRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.informacoesgerais.ProgramaRepository;
import br.com.sis.rh.apiprogramaformacao.core.repository.investimentos.InvestimentosRepository;

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
	private RemuneracaoInstrutorRepository remuneracaoInstrutorRepository;
	@Autowired
	private InvestimentosRepository investimentosRepository;

	// Metodo chamado no controller para popular os cards, contém a sequencia de
	// valores a serem utilizados no vue.js
	public InvestimentoProgFormacaoVo popularCards(LocalDate dataInicio, LocalDate dataFim, String nomePrograma,
			String nomeTurma) {
		String turmaFormatada = nomeTurma.replace("+", " ");
		InvestimentoProgFormacaoVo investimentoProgFormacaoVo = new InvestimentoProgFormacaoVo();

		investimentoProgFormacaoVo = investParticipantesPeriodo(dataInicio, dataFim, nomePrograma, turmaFormatada,
				investimentoProgFormacaoVo);

		investimentoProgFormacaoVo = investInstrutorPeriodo(dataInicio, dataFim, nomePrograma, turmaFormatada,
				investimentoProgFormacaoVo);

		investimentoProgFormacaoVo = investimentoTotalDoPeriodo(investimentoProgFormacaoVo);

		investimentoProgFormacaoVo.setFormacao(nomePrograma);
		investimentoProgFormacaoVo.setTurma(turmaFormatada);
		
		return investimentoProgFormacaoVo;
	}

	// esta método processa os dados gerais e totais dos participantes de acordo com
	// o programa, turma e data selecionados
	public InvestimentoProgFormacaoVo investParticipantesPeriodo(LocalDate dataInicio, LocalDate dataFim,
			String nomePrograma, String nomeTurma, InvestimentoProgFormacaoVo investimentoProgFormacaoVo) {

		Programa programa = (Programa) programaRepository.listarPrograma(nomePrograma, nomeTurma);
		List<Participante> participantes = participantesRepository.listarParticipantes(programa.getId());
		investimentoProgFormacaoVo.setInvestParticipantesPeriodoSelecionado(BigDecimal.ZERO);

		participantes.forEach(participante ->{
			Integer somaSalario = investimentosRepository.buscarSalarioPeloCpfData(participante.getCpf(),
					dataInicio, dataFim);
			investimentoProgFormacaoVo.setInvestParticipantesPeriodoSelecionado(investimentoProgFormacaoVo.
					getInvestParticipantesPeriodoSelecionado().add(new BigDecimal(somaSalario)));
		});
		return investimentoProgFormacaoVo;
	}

	// este metodo processa os dados dos custos totais com instrutores de acordo com
	// o programa, turma e data selecionada
	public InvestimentoProgFormacaoVo investInstrutorPeriodo(LocalDate dataInicio, LocalDate dataFim,
			String nomePrograma,String nomeTurma,InvestimentoProgFormacaoVo investimentoProgFormacaoVo) {

		List<String> cpfInstrutores = programaRepository.listarCPFbyNomeProgramaNomeTurma(nomePrograma, nomeTurma);
		investimentoProgFormacaoVo.setInvestInstrutoresPeriodoSelecionado(BigDecimal.ZERO);
		cpfInstrutores.forEach(cpf -> {
			Double salarioInstrutores = remuneracaoInstrutorRepository.calcularSalarioInstrutoresPeriodo
					(cpf, dataInicio, dataFim);
			investimentoProgFormacaoVo.setInvestInstrutoresPeriodoSelecionado(investimentoProgFormacaoVo.
					getInvestInstrutoresPeriodoSelecionado().add(new BigDecimal(salarioInstrutores)));
		});
		return investimentoProgFormacaoVo;
	}

	public InvestimentoProgFormacaoVo investimentoTotalDoPeriodo(InvestimentoProgFormacaoVo investTotal) {

		BigDecimal investTotal2 = investTotal.getInvestInstrutoresPeriodoSelecionado()
				.add(investTotal.getInvestParticipantesPeriodoSelecionado()) ;

		investTotal.setInvestTotalPeriodoSelecionado(investTotal2);

		return investTotal;
	}
}