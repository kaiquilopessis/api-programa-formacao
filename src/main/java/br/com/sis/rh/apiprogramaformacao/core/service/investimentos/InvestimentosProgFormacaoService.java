package br.com.sis.rh.apiprogramaformacao.core.service.investimentos;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
 *         superior da pagina
 */
@Service
public class InvestimentosProgFormacaoService {

	// injeções de dependências

	@Autowired
	private ProgramaRepository programaRepository;
	@Autowired
	private ParticipanteRepository participantesRepository;

	@Autowired
	private RemuneracaoInstrutorRepository remuneracaoInstrutorRepository;

	@Autowired
	private InvestimentosRepository investimentosRepository;

	/**
	 * Metodo chamado no controller para popular os cards superiores antes do filtro
	 * de data, contém a sequencia de valores a serem alocados na página
	 * investimetos
	 * 
	 * @param nomePrograma processa o nome do programa selecionado na tela
	 *                     Relatórios
	 * @param nomeTurma    processa o nome da turma selecionada na tela Relatórios
	 * @return gera como resposta os valores pertinentes aos investimentos do
	 *         programa de acordo com as seleções na tela de relatorios
	 */
	//
	public InvestimentoProgFormacaoVo popularCardsSuperiores(String nomePrograma, String nomeTurma) {
		String turmaFormatada = nomeTurma.replace("+", " ");

		InvestimentoProgFormacaoVo investimentoProgFormacaoVo = new InvestimentoProgFormacaoVo();
		investimentoProgFormacaoVo = investimentosParticipantes(nomePrograma, turmaFormatada,
				investimentoProgFormacaoVo);
		investimentoProgFormacaoVo = investimentoInstrutores(nomePrograma, turmaFormatada, investimentoProgFormacaoVo);
		investimentoProgFormacaoVo = investimentoTotal(investimentoProgFormacaoVo);

		investimentoProgFormacaoVo.setFormacao(nomePrograma);
		investimentoProgFormacaoVo.setTurma(turmaFormatada);

		return investimentoProgFormacaoVo;
	}

	/**
	 * Esta método processa os dados gerais e totais dos participantes de acordo com
	 * o programa e turma selecionados
	 * 
	 * @param nomePrograma        processa o nome do programa selecionado na tela
	 *                            Relatórios
	 * @param nomeTurma           processa o nome da turma selecionada na tela
	 *                            Relatórios
	 * @param investParticipantes instancia VO para retorno do investimento total
	 * @return gera como resposta o valor total do investimento com os participantes
	 *         de acordo com a seleção na tela de relatório
	 */

	public InvestimentoProgFormacaoVo investimentosParticipantes(String nomePrograma, String nomeTurma,
			InvestimentoProgFormacaoVo investParticipantes) {
		Programa programa = programaRepository.listarPrograma(nomePrograma, nomeTurma);
		List<Participante> participantes = participantesRepository.listarParticipantes(programa.getId());
		investParticipantes.setInvestParticipantes(BigDecimal.ZERO);

		participantes.forEach(participante -> {
			Integer somaSalario = investimentosRepository.buscarSalarioPeloCpf(participante.getCpf());
			investParticipantes.setInvestParticipantes(
					investParticipantes.getInvestParticipantes().add(new BigDecimal(somaSalario)));
		});
		return investParticipantes;
	}

	/**
	 * Este metodo processa os dados dos custos totais com instrutores de acordo com
	 * o programa e a turma selecionada
	 * 
	 * @param nomePrograma      processa o nome do programa selecionado na tela
	 *                          Relatórios
	 * @param nomeTurma         processa o nome da turma selecionada na tela
	 *                          Relatórios
	 * @param investInstrutores instancia VO para retorno do investimento total
	 * @return gera como resposta o valor total do investimento com os instrutores
	 *         de acordo com a seleção na tela de relatório
	 */
	public InvestimentoProgFormacaoVo investimentoInstrutores(String nomePrograma, String nomeTurma,
			InvestimentoProgFormacaoVo investInstrutores) {
		List<String> cpfInstrutores = programaRepository.listarCPFbyNomeProgramaNomeTurma(nomePrograma, nomeTurma);
		investInstrutores.setInvestInstrutores(BigDecimal.ZERO);
		cpfInstrutores.forEach(cpf -> {
			Double salarioInstrutores = remuneracaoInstrutorRepository.calcularSalarioInstrutores(cpf);
			investInstrutores.setInvestInstrutores(
					investInstrutores.getInvestInstrutores().add(new BigDecimal(salarioInstrutores)));
		});
		return investInstrutores;
	}

	/**
	 * Este método faz a soma dos investimentos dos participantes e instrutores
	 * 
	 * @param investTotal instancia VO para retorno do investimento total
	 * @return gera como resposta o custo total do programa e da turma selecionados
	 *         na tela Relatório
	 */
	public InvestimentoProgFormacaoVo investimentoTotal(InvestimentoProgFormacaoVo investTotal) {

		BigDecimal investTotal2 = investTotal.getInvestParticipantes().add(investTotal.getInvestInstrutores());
		investTotal.setInvestTotal(investTotal2);

		return investTotal;
	}
}