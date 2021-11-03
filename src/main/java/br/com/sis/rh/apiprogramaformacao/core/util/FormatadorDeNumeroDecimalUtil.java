package br.com.sis.rh.apiprogramaformacao.core.util;

import java.text.DecimalFormat;

import org.springframework.stereotype.Service;

@Service
public class FormatadorDeNumeroDecimalUtil {

	private DecimalFormat formatter = new DecimalFormat("#,##.00");
	
	public String formatarDecimal(Double nota) {
		String notaFormatada = formatter.format(nota);
		return notaFormatada;
	}
}
