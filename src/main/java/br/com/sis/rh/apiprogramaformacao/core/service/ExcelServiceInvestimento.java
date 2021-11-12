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
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.InvestimentoProgFormacaoVo;

/**
 * 
 * @author dkalbiak
 *
 *         Esta Classe funciona com uma exportadora XLSX, formatação e afins
 */
@Service
public class ExcelServiceInvestimento {

	public ByteArrayInputStream excelInvestimentoProgFormacao(InvestimentoProgFormacaoVo investimentoProgFormacaoVo)
			throws IOException {

		try (Workbook workbook = new XSSFWorkbook()) {

			Sheet sheet = workbook.createSheet("Investimentos");

			Row row = sheet.createRow(0);

			CellStyle headCellStyle = workbook.createCellStyle();
			headCellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
			headCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

			Cell cell = row.createCell(0);
			cell.setCellValue("Investimento em total com participantes");
			cell.setCellStyle(headCellStyle);

			cell = row.createCell(1);
			cell.setCellValue("Investimento total com instrutores");
			cell.setCellStyle(headCellStyle);

			cell = row.createCell(2);
			cell.setCellValue("Investimento total com o programa");
			cell.setCellStyle(headCellStyle);

			cell = row.createCell(3);
			cell.setCellValue("Investimento total em participantes no periodo");
			cell.setCellStyle(headCellStyle);

			cell = row.createCell(4);
			cell.setCellValue("Investimento total em instrutores no periodo");
			cell.setCellStyle(headCellStyle);

			cell = row.createCell(5);
			cell.setCellValue("Investimento total do periodo");
			cell.setCellStyle(headCellStyle);

			Row dataRow = sheet.createRow(1);
			dataRow.createCell(0).setCellValue(investimentoProgFormacaoVo.getInvestParticipantes());
			dataRow.createCell(1).setCellValue(investimentoProgFormacaoVo.getInvestInstrutores());
			dataRow.createCell(2).setCellValue(investimentoProgFormacaoVo.getInvestTotal());
			dataRow.createCell(3).setCellValue(investimentoProgFormacaoVo.getInvestParticipantesPeriodoSelecionado());
			dataRow.createCell(4).setCellValue(investimentoProgFormacaoVo.getInvestInstrutoresPeriodoSelecionado());
			dataRow.createCell(5).setCellValue(investimentoProgFormacaoVo.getInvestTotalPeriodoSelecionado());

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