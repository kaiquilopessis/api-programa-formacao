package br.com.sis.rh.apiprogramaformacao.core.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
 *         superior da pagina
 */
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
	private CicloRepository cicloRepository;
	@Autowired
	private RemuneracaoInstrutorRepository remuneracaoInstrutorRepository;

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
		investimentoProgFormacaoVo = investimentosParticipantes(nomePrograma, turmaFormatada, investimentoProgFormacaoVo);
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
	 * @param nomePrograma        rocessa o nome do programa selecionado na tela
	 *                            Relatórios
	 * @param nomeTurma           processa o nome da turma selecionada na tela
	 *                            Relatórios
	 * @param investParticipantes instancia VO para retorno do investimento total
	 * @return gera como resposta o valor total do investimento com os participantes
	 *         de acordo com a seleção na tela de relatório
	 */

	public InvestimentoProgFormacaoVo investimentosParticipantes(String nomePrograma, String nomeTurma,
			InvestimentoProgFormacaoVo investParticipantes) {

		Programa programa = (Programa) programaRepository.listarProgramaSemData(nomePrograma, nomeTurma);
		List<Participante> participantes = participantesRepository.listarParticipantes(programa.getId());

		investParticipantes.setInvestParticipantes(BigDecimal.ZERO);
		participantes.forEach(participante -> {
			System.out.println(participante.getCpf());

			List<Ciclo> conclusoes = cicloRepository.listarConclusoes(participante.getCpf());
			System.out.println(conclusoes.size());

			conclusoes.forEach(conclusao -> {

				Remuneracao remuneracao = remuneracaoRepository
						.findBySalario(conclusao.getParticipante().getRemuneracaoPrograma().getId());

				investParticipantes.setInvestParticipantes(investParticipantes.getInvestParticipantes()
						.add(remuneracao.getBolsa()).add(remuneracao.getBeneficio()).add(remuneracao.getConvenio())
						.add(remuneracao.getHoraExtra()).add(remuneracao.getBeneficioLegislacao()) 
						.add(remuneracao.getRemunEsporadica()).add(remuneracao.getAlura()));
			});
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

		Double salarioInstrutores = remuneracaoInstrutorRepository.calcularSalarioInstrutores(nomePrograma, nomeTurma);
		investInstrutores.setInvestInstrutores(new BigDecimal(salarioInstrutores));
			
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