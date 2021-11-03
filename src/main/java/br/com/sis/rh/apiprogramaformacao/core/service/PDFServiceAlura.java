package br.com.sis.rh.apiprogramaformacao.core.service;

import java.awt.Color;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import br.com.sis.rh.apiprogramaformacao.api.vo.RelatorioAluraVo;

public class PDFServiceAlura {
	

	private RelatorioAluraVo aluraVo;
	
	public PDFServiceAlura(RelatorioAluraVo aluraVo) {
		this.aluraVo = aluraVo;
	}
	
	private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(7);
        
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
                  
        cell.setPhrase(new Phrase("Ultimo Registrado", font));
        table.addCell(cell); 
        
        cell.setPhrase(new Phrase("Média de horas", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Maior quantidade de horas", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Participante", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Menor quantidade de horas", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Participante", font));
        table.addCell(cell);
    }
     
    private void writeTableData(PdfPTable table) {   
            table.addCell(String.valueOf(aluraVo.getDataUltimoRegistro()));
            table.addCell(String.valueOf(aluraVo.getMediaDeHorasDosParticipantes()));
            table.addCell(String.valueOf(aluraVo.getMaiorQuantidadeDeHorasDosParticipantes()));
            table.addCell(String.valueOf(aluraVo.getNomeFuncionarioComMaiorQuantidadeHoras() + " - " + aluraVo.getCargoFuncionarioComMaiorQuantidadeHoras()));
            table.addCell(String.valueOf(aluraVo.getMenorQuantidadeDeHorasDosParticipantes()));
            table.addCell(String.valueOf(aluraVo.getNomeFuncionarioComMenorQuantidadeHoras() + " - " + aluraVo.getCargoFuncionarioComMenorQuantidadeHoras()));
    }
     
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLACK);
         
        Paragraph p = new Paragraph("Media das avaliações dos participantes", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
        
        document.add(p);
         
        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {2.5f, 2.8f, 2.5f, 2.5f, 2.5f, 2.4f});
        table.setSpacingBefore(10);
        
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
    }
}
