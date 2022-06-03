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

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.RelatorioAvaliacoesVo;

/**
 * Classe para gerar um arquivo XLSX com os valores do relatório referente as
 * notas das avaliaçoes dos participantes
 */

@Service
public class ExcelServiceAvaliacao {

	/**
	 * Pega os valores do Vo e insere nas linhas/colunas e monta o arquivo xlsx
	 * 
	 * @param avaliacaoVo recebe o Vo com todos os campos populados
	 */

	public ByteArrayInputStream gerarRelatorioAvaliacoes(RelatorioAvaliacoesVo avaliacaoVo) throws IOException {
		try (Workbook workbook = new XSSFWorkbook()) {
			Sheet sheet = workbook.createSheet("Alura");

			Row row = sheet.createRow(0);

			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
			headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

			// Criação das células da primeira linha, onde vão
			// os títulos das colunas
			Cell cell = row.createCell(0);
			cell.setCellValue("Nota média Avaliação Técnica");
			cell.setCellStyle(headerCellStyle);

			cell = row.createCell(1);
			cell.setCellValue("Nota média Avaliação Comportamental");
			cell.setCellStyle(headerCellStyle);

			cell = row.createCell(2);
			cell.setCellValue("Nota média Avaliação Práticas Ágeis");
			cell.setCellStyle(headerCellStyle);

			cell = row.createCell(3);
			cell.setCellValue("Nota média Avaliação Liderança");
			cell.setCellStyle(headerCellStyle);

			cell = row.createCell(4);
			cell.setCellValue("Nota média Avaliação Negocio");
			cell.setCellStyle(headerCellStyle);

			cell = row.createCell(5);
			cell.setCellValue("Último ciclo registrado");
			cell.setCellStyle(headerCellStyle);

			// Inserçao dos dados na segunda linha, pegando os
			// valores do Vo
			Row dataRow = sheet.createRow(1);
			dataRow.createCell(0).setCellValue(String.valueOf(avaliacaoVo.getNotaMediaAvaliacaoTecnica()));
			dataRow.createCell(1).setCellValue(String.valueOf(avaliacaoVo.getNotaMediaAvaliacaoComportamental()));
			dataRow.createCell(2).setCellValue(String.valueOf(avaliacaoVo.getNotaMediaAvaliacaoPraticasAgeis()));
			dataRow.createCell(3).setCellValue(String.valueOf(avaliacaoVo.getNotaMediaAvaliacaoLideranca()));
			dataRow.createCell(4).setCellValue(String.valueOf(avaliacaoVo.getNotaMediaAvaliacaoNegocio()));
			dataRow.createCell(5).setCellValue(String.valueOf(avaliacaoVo.getUltimoCicloRegistrado()));

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
