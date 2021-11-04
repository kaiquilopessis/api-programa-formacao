package br.com.sis.rh.apiprogramaformacao.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sis.rh.apiprogramaformacao.api.model.Avaliacoes;
import br.com.sis.rh.apiprogramaformacao.api.vo.RelatorioAvaliacoesVo;
import br.com.sis.rh.apiprogramaformacao.core.repository.AvaliacaoRepository;
import br.com.sis.rh.apiprogramaformacao.core.util.FormatadorDeNumeroDecimalUtil;

/**
 * Classe onde estão as regras de negócio referente a tela de relatorios
 * das avaliaçoes dos participantes de determinado programa.
 */

@Service
public class AvaliacaoService {
	
	@Autowired
	private AvaliacaoRepository avaliacaoRepository;
	
	@Autowired
	private FormatadorDeNumeroDecimalUtil formatador;
	
	/**
	 * Executa outros métodos para popular o Vo
	 * para levar as informações para o front-end e popular
	 * os cards.
	 * 
	 * @param formacao nome do programa de formação
	 * @param turma nome da turma do programa de formação
	 * @return Vo com os campos de notas, ultimo
	 * ciclo registrado, nome do programa de formação e a
	 * turma populados
	 */
	
	public RelatorioAvaliacoesVo popularCards(String formacao, String turma) {
		RelatorioAvaliacoesVo avaliacaoVo = calcularMedia();
		avaliacaoVo.setUltimoCicloRegistrado(avaliacaoRepository.buscaNumeroCiclo());
		String formacaoFormatada = formacao.replace("+", " ");
		avaliacaoVo.setProgramaDeFormacao(formacaoFormatada);
		avaliacaoVo.setTurma(turma);
		avaliacaoVo = formatarNotas(avaliacaoVo);
		return avaliacaoVo;
	}
	
	/**
	 * Calcula a média das notas retornadas da base de dados
	 *
	 * @return Vo único com os campos de notas populados com
	 * as médias das notas dos participantes
	 */
	
	public RelatorioAvaliacoesVo calcularMedia() {
		RelatorioAvaliacoesVo avaliacaoVo = new RelatorioAvaliacoesVo(0.0,0.0,0.0,0.0,0.0,0,"Java","Java 01");
		List<Avaliacoes> avaliacoes = avaliacaoRepository.buscarNotasMaisRecentes();
		
		avaliacoes.forEach(avaliacao -> {
			avaliacaoVo.setNotaMediaAvaliacaoTecnica(avaliacaoVo.getNotaMediaAvaliacaoTecnica() + avaliacao.getNotaTecnica());
			avaliacaoVo.setNotaMediaAvaliacaoComportamental(avaliacaoVo.getNotaMediaAvaliacaoComportamental() + avaliacao.getNotaComportamental());
			avaliacaoVo.setNotaMediaAvaliacaoLideranca(avaliacaoVo.getNotaMediaAvaliacaoLideranca() + avaliacao.getNotaLideranca());
			avaliacaoVo.setNotaMediaAvaliacaoNegocio(avaliacaoVo.getNotaMediaAvaliacaoNegocio() + avaliacao.getNotaNegocio());
			avaliacaoVo.setNotaMediaAvaliacaoPraticasAgeis(avaliacaoVo.getNotaMediaAvaliacaoPraticasAgeis() + avaliacao.getNotaPraticasAgeis());
		});
		avaliacaoVo.setNotaMediaAvaliacaoTecnica(avaliacaoVo.getNotaMediaAvaliacaoTecnica() / avaliacoes.size());
		avaliacaoVo.setNotaMediaAvaliacaoComportamental(avaliacaoVo.getNotaMediaAvaliacaoComportamental() / avaliacoes.size());
		avaliacaoVo.setNotaMediaAvaliacaoLideranca(avaliacaoVo.getNotaMediaAvaliacaoLideranca() / avaliacoes.size());
		avaliacaoVo.setNotaMediaAvaliacaoNegocio(avaliacaoVo.getNotaMediaAvaliacaoNegocio() / avaliacoes.size());
		avaliacaoVo.setNotaMediaAvaliacaoPraticasAgeis(avaliacaoVo.getNotaMediaAvaliacaoPraticasAgeis() / avaliacoes.size());
		
		return avaliacaoVo;
	}
	
	/**
	 * Formata as notas para deixá-las com 2 casas decimais
	 * 
	 * @param avaliacaoVo populado e com as médias já calculadas
	 * @return O mesmo Vo já populado, porém com as notas já formatadas
	 */
	
	public RelatorioAvaliacoesVo formatarNotas(RelatorioAvaliacoesVo avaliacaoVo) {
		String notaTecnica = formatador.formatarDecimal(avaliacaoVo.getNotaMediaAvaliacaoTecnica());
		String notaAvaliacaoComp = formatador.formatarDecimal(avaliacaoVo.getNotaMediaAvaliacaoComportamental());
		String notaLideranca = formatador.formatarDecimal(avaliacaoVo.getNotaMediaAvaliacaoLideranca());
		String notaNegocio = formatador.formatarDecimal(avaliacaoVo.getNotaMediaAvaliacaoNegocio());
		String notaPraticasAg = formatador.formatarDecimal(avaliacaoVo.getNotaMediaAvaliacaoPraticasAgeis());
		
		String notaTecnicaFormatada = notaTecnica.replaceAll(",", ".");
		String notaComportamentalFormatada = notaAvaliacaoComp.replaceAll(",", ".");
		String notaLiderancaFormatada = notaLideranca.replaceAll(",", ".");
		String notaNegocioFormatada = notaNegocio.replaceAll(",", ".");
		String notaPraticasAgeisFormatada = notaPraticasAg.replaceAll(",", ".");
		
		avaliacaoVo.setNotaMediaAvaliacaoTecnica(Double.parseDouble(notaTecnicaFormatada));
		avaliacaoVo.setNotaMediaAvaliacaoComportamental(Double.parseDouble(notaComportamentalFormatada));
		avaliacaoVo.setNotaMediaAvaliacaoLideranca(Double.parseDouble(notaLiderancaFormatada));
		avaliacaoVo.setNotaMediaAvaliacaoNegocio(Double.parseDouble(notaNegocioFormatada));
		avaliacaoVo.setNotaMediaAvaliacaoPraticasAgeis(Double.parseDouble(notaPraticasAgeisFormatada));
		
		return avaliacaoVo;
	}

}

