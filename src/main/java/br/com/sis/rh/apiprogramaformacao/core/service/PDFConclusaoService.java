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

import br.com.sis.rh.apiprogramaformacao.api.vo.RelatorioConclusaoVO;

public class PDFConclusaoService {

private RelatorioConclusaoVO conclusaoVO;
	
	public PDFConclusaoService(RelatorioConclusaoVO conclusaoVO) {
		this.conclusaoVO = conclusaoVO;
	}
	
	private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(7);
        
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
                  
        cell.setPhrase(new Phrase("Participantes Ativos no Programa", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Participantes Efetivados no Programa", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Data de Conclusão do Programa", font));
        table.addCell(cell);    
    }
     
    private void writeTableData(PdfPTable table) {   
            table.addCell(String.valueOf(conclusaoVO.getParticipantesAtivos()));
            table.addCell(String.valueOf(conclusaoVO.getParticipantesEfetivados()));
            table.addCell(String.valueOf(conclusaoVO.getDataConclusao()));
    }
     
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLACK);
         
        Paragraph p = new Paragraph("RELATORIO - CONCLUSÃO", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
        
        document.add(p);
         
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {2.5f, 2.5f, 2.5f});
        table.setSpacingBefore(10);
        
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
         
    }

	
}
