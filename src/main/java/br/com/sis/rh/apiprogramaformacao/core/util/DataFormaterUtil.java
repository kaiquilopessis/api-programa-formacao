package br.com.sis.rh.apiprogramaformacao.core.util;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Esta classe funciona como uma formatadora de datas
 */


import org.springframework.stereotype.Service;

@Service
public class DataFormaterUtil {

	public LocalDate dataFormatada(String data) throws ParseException {

		LocalDate dataFormat = LocalDate.parse(data, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

		return dataFormat;

	}

}
