package br.com.sis.rh.apiprogramaformacao.core.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class DataConfiguration {

	public LocalDate dataFormatada(String data) {
		LocalDate dataFormat = LocalDate.parse(data,DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		return dataFormat;
	}
	
//	public Alura converter(Participante participante) {
//		LocalDate data = LocalDate.parse(this.dataRegistro, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//		return new Alura(participante, qtdHoras, mesAvaliado, semanaAvaliada, data, hrMinSemana);
}
