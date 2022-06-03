package br.com.sis.rh.apiprogramaformacao.core.service.relatorios;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.RelatorioAluraVo;

/**
 * Classe para gerar um arquivo XLSX com os valores do
 * relatório da plataforma Alura
 */

@Service
public class ExcelServiceAlura {
	
	/**
	 * Pega os valores do Vo e insere nas linhas/colunas
	 * e monta o arquivo xlsx
	 * 
	 * @param aluraVo recebe o Vo com todos os campos
	 * populados
	 */
	
	public ByteArrayInputStream gerarRelatorioAlura(RelatorioAluraVo aluraVo) throws IOException {
		try(Workbook workbook = new XSSFWorkbook()){
			Sheet sheet = workbook.createSheet("Alura");
			
			Row row = sheet.createRow(0);
			
			CellStyle headerCellStyle = workbook.createCellStyle();
	        headerCellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
	        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
	        //Criação das células da primeira linha, onde vão
	        //os títulos das colunas
	        Cell cell = row.createCell(0);
	        cell.setCellValue("Data do último registro");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(1);
	        cell.setCellValue("Media de horas");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(2);
	        cell.setCellValue("Maior quantidade de horas");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(3);
	        cell.setCellValue("Participante");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(4);
	        cell.setCellValue("Menor quantidade de horas");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(5);
	        cell.setCellValue("Participante");
	        cell.setCellStyle(headerCellStyle);
	        
	        //Inserçao dos dados na segunda linha, pegando os
	        //valores do Vo
	        Row dataRow = sheet.createRow(1);
	        dataRow.createCell(0).setCellValue(aluraVo.getDataUltimoRegistro());
	        dataRow.createCell(1).setCellValue(aluraVo.getMediaDeHorasDosParticipantes());
	        dataRow.createCell(2).setCellValue(aluraVo.getMaiorQuantidadeDeHorasDosParticipantes());
	        dataRow.createCell(3).setCellValue(aluraVo.getNomeFuncionarioComMaiorQuantidadeHoras() + " - " + aluraVo.getCargoFuncionarioComMaiorQuantidadeHoras());
	        dataRow.createCell(4).setCellValue(aluraVo.getMenorQuantidadeDeHorasDosParticipantes());
	        dataRow.createCell(5).setCellValue(aluraVo.getNomeFuncionarioComMenorQuantidadeHoras() + " - " + aluraVo.getCargoFuncionarioComMenorQuantidadeHoras());
	        
	        sheet.autoSizeColumn(0);
	        sheet.autoSizeColumn(1);
	        sheet.autoSizeColumn(2);
	        sheet.autoSizeColumn(3);
	        sheet.autoSizeColumn(4);
	        sheet.autoSizeColumn(5);
	        
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        workbook.write(outputStream);
	        return new ByteArrayInputStream(outputStream.toByteArray());
		}
	}
}
