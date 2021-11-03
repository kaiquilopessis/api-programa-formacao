package br.com.sis.rh.apiprogramaformacao.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sis.rh.apiprogramaformacao.api.vo.RelatorioAvaliacoesVo;
import br.com.sis.rh.apiprogramaformacao.core.model.Avaliacoes;
import br.com.sis.rh.apiprogramaformacao.core.repository.AvaliacaoRepository;
import br.com.sis.rh.apiprogramaformacao.core.util.FormatadorDeNumeroDecimalUtil;

@Service
public class AvaliacaoService {
	
	@Autowired
	private AvaliacaoRepository avaliacaoRepository;
	
	@Autowired
	private FormatadorDeNumeroDecimalUtil formatador;
	
	public RelatorioAvaliacoesVo popularCards(String formacao, String turma) {
		RelatorioAvaliacoesVo avaliacaoVo = calcularMedia();
		avaliacaoVo.setUltimoCicloRegistrado(avaliacaoRepository.buscaNumeroCiclo());
		String formacaoFormatada = formacao.replace("+", " ");
		avaliacaoVo.setProgramaDeFormacao(formacaoFormatada);
		avaliacaoVo.setTurma(turma);
		avaliacaoVo = formatarNotas(avaliacaoVo);
		return avaliacaoVo;
	}
	
	public RelatorioAvaliacoesVo popularVo() {
		RelatorioAvaliacoesVo avaliacaoVo = calcularMedia();
		avaliacaoVo.setUltimoCicloRegistrado(avaliacaoRepository.buscaNumeroCiclo());
		avaliacaoVo = formatarNotas(avaliacaoVo);
		return avaliacaoVo;
	}
	
	public RelatorioAvaliacoesVo calcularMedia() {
		RelatorioAvaliacoesVo avaliacaoVo = new RelatorioAvaliacoesVo(0.0,0.0,0.0,0.0,0.0,0,"Java","Java 01");
		List<Avaliacoes> avaliacoes = avaliacaoRepository.buscarNotasMaisRecentes();
		
		avaliacoes.forEach(avaliacao -> {
			avaliacaoVo.setNotaMediaAvaliacaoTecnica(avaliacaoVo.getNotaMediaAvaliacaoTecnica() + avaliacao.getNota_tecnica());
			avaliacaoVo.setNotaMediaAvaliacaoComportamental(avaliacaoVo.getNotaMediaAvaliacaoComportamental() + avaliacao.getNota_comportamental());
			avaliacaoVo.setNotaMediaAvaliacaoLideranca(avaliacaoVo.getNotaMediaAvaliacaoLideranca() + avaliacao.getNota_lideranca());
			avaliacaoVo.setNotaMediaAvaliacaoNegocio(avaliacaoVo.getNotaMediaAvaliacaoNegocio() + avaliacao.getNota_negocio());
			avaliacaoVo.setNotaMediaAvaliacaoPraticasAgeis(avaliacaoVo.getNotaMediaAvaliacaoPraticasAgeis() + avaliacao.getNota_praticas_ageis());
		});
		avaliacaoVo.setNotaMediaAvaliacaoTecnica(avaliacaoVo.getNotaMediaAvaliacaoTecnica() / avaliacoes.size());
		avaliacaoVo.setNotaMediaAvaliacaoComportamental(avaliacaoVo.getNotaMediaAvaliacaoComportamental() / avaliacoes.size());
		avaliacaoVo.setNotaMediaAvaliacaoLideranca(avaliacaoVo.getNotaMediaAvaliacaoLideranca() / avaliacoes.size());
		avaliacaoVo.setNotaMediaAvaliacaoNegocio(avaliacaoVo.getNotaMediaAvaliacaoNegocio() / avaliacoes.size());
		avaliacaoVo.setNotaMediaAvaliacaoPraticasAgeis(avaliacaoVo.getNotaMediaAvaliacaoPraticasAgeis() / avaliacoes.size());
		
		return avaliacaoVo;
	}
	
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

