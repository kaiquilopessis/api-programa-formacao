package br.com.sis.rh.apiprogramaformacao.core.service.relatorios;

import java.awt.Color;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import br.com.sis.rh.apiprogramaformacao.api.vo.dto.InvestimentoProgFormacaoVo;

/**
 * 
 * @author dkalbiak
 *
 *         Esta classe funciona como uma exportadora PDF, formatação e afins
 */
public class PDFServiceInvestimento {

	private InvestimentoProgFormacaoVo investimentoProgFormacaoVo;

	public PDFServiceInvestimento(InvestimentoProgFormacaoVo investimentoProgFormacaoVo) {
		this.investimentoProgFormacaoVo = investimentoProgFormacaoVo;
	}

	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);

		cell.setPhrase(new Phrase("Investimento em total com participantes", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Investimento total com instrutores", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Investimento total com o programa", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Investimento total em participantes no periodo", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Investimento total em instrutores no periodo", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Investimento total do periodo", font));
		table.addCell(cell);
	}

	private void writeTableData(PdfPTable table) {
		table.addCell(String.valueOf(investimentoProgFormacaoVo.getInvestParticipantes()));
		table.addCell(String.valueOf(investimentoProgFormacaoVo.getInvestInstrutores()));
		table.addCell(String.valueOf(investimentoProgFormacaoVo.getInvestTotal()));
		table.addCell(String.valueOf(investimentoProgFormacaoVo.getInvestParticipantesPeriodoSelecionado()));
		table.addCell(String.valueOf(investimentoProgFormacaoVo.getInvestInstrutoresPeriodoSelecionado()));
		table.addCell(String.valueOf(investimentoProgFormacaoVo.getInvestTotalPeriodoSelecionado()));
	}

	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();

		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(20);
		font.setColor(Color.BLACK);

		Paragraph paragrafo = new Paragraph("Investimentos do Programa e Turma Selecionados", font);
		paragrafo.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(paragrafo);

		PdfPTable table = new PdfPTable(6);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 2.5f, 2.8f, 2.5f, 2.5f, 2.5f, 2.4f });
		table.setSpacingBefore(10);

		writeTableHeader(table);
		writeTableData(table);

		document.add(table);
		document.close();
	}
}