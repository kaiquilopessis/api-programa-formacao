package br.com.sis.rh.apiprogramaformacao.core.service;

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

import br.com.sis.rh.apiprogramaformacao.api.vo.RelatorioConclusaoVO;

@Service
public class ExcelConclusaoService {

	public ByteArrayInputStream gerarExcelConclusao(RelatorioConclusaoVO conclusaoVO) throws IOException {
		try(Workbook workbook = new XSSFWorkbook()){
			Sheet sheet = workbook.createSheet("Relatorio - Conclusão");
			
			Row row = sheet.createRow(0);
			
			CellStyle headerCellStyle = workbook.createCellStyle();
	        headerCellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
	        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
	        Cell cell = row.createCell(0);
	        cell.setCellValue("Participantes Ativos no Programa");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(1);
	        cell.setCellValue("Participantes Efetivados no Programa");
	        cell.setCellStyle(headerCellStyle);
	        
	        cell = row.createCell(2);
	        cell.setCellValue("Data Conclusão do Programa");
	        cell.setCellStyle(headerCellStyle);
	        
	        Row dataRow = sheet.createRow(1);
	        dataRow.createCell(0).setCellValue(conclusaoVO.getParticipantesAtivos());
	        dataRow.createCell(1).setCellValue(conclusaoVO.getParticipantesEfetivados());
	        dataRow.createCell(2).setCellValue(conclusaoVO.getDataConclusao());
	   
	        sheet.autoSizeColumn(0);
	        sheet.autoSizeColumn(1);
	        sheet.autoSizeColumn(2);
	        
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        workbook.write(outputStream);
	        return new ByteArrayInputStream(outputStream.toByteArray());
		}
	}
}
