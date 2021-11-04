package br.com.sis.rh.apiprogramaformacao.core.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class DataConfiguration {

	private DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public String dataFormatada(LocalDate dataFim) {
		String data = dataFim.format(formatar);
		return data;
	}
	
}
