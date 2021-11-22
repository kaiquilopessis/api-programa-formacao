package br.com.sis.rh.apiprogramaformacao.core.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

/**
 * 
 * @author dkalbiak
 *
 *         Esta classe funciona como formatadora de datas para a tela
 *         investimetos
 */
@Service
public class FormatadorDataUtil {

	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public String formatarData(LocalDate data) {
		String dataFormatada = data.format(formatter);
		return dataFormatada;
	}
}