package br.com.sis.rh.apiprogramaformacao.core.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

import java.awt.Color;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import br.com.sis.rh.apiprogramaformacao.api.vo.dto.RelatorioAvaliacoesVo;

/**
 * Classe para gerar um arquivo PDF com os valores
 * do relatorio referente as notas das avaliaçoes
 * dos participantes
 */

public class PDFServiceAvaliacao {
	
	private RelatorioAvaliacoesVo avaliacaoVo;
	
	/**
	 * Construtor que recebe um Vo já populado para
	 * inserir em uma tabela
	 * 
	 * @param avaliacaoVo Vo populado com os valores a
	 * serem inseridos
	 */
	
	public PDFServiceAvaliacao(RelatorioAvaliacoesVo avaliacaoVo) {
		this.avaliacaoVo = avaliacaoVo;
	}
	
	/**
	 * Cria a primeira linha da tabela onde estará
	 * os títulos de cada coluna
	 * 
	 * @param table Objeto criado com o número de
	 * colunas que a tabela terá
	 */
	
	private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(7);
        
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
                  
        cell.setPhrase(new Phrase("Media Técnica", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Media Comportamental", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Media Práticas Ágeis", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Media Liderança", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Media Negócio", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Ultimo Registrado", font));
        table.addCell(cell);       
    }
     
	/**
	 * É criado uma nova linha da tabela, porém agora
	 * com os valores vindos do Vo
	 * 
	 * @param table table Objeto criado com o número de
	 * colunas que a tabela terá
	 */
	
    private void writeTableData(PdfPTable table) {   
            table.addCell(String.valueOf(avaliacaoVo.getNotaMediaAvaliacaoTecnica()));
            table.addCell(String.valueOf(avaliacaoVo.getNotaMediaAvaliacaoComportamental()));
            table.addCell(String.valueOf(avaliacaoVo.getNotaMediaAvaliacaoPraticasAgeis()));
            table.addCell(String.valueOf(avaliacaoVo.getNotaMediaAvaliacaoLideranca()));
            table.addCell(String.valueOf(avaliacaoVo.getNotaMediaAvaliacaoNegocio()));
            table.addCell(String.valueOf(avaliacaoVo.getUltimoCicloRegistrado()));
    }
     
    /**
     * Cria o documento pdf e adiciona a tabela criada no mesmo
     */
    
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
        table.setWidths(new float[] {2.5f, 2.5f, 2.5f, 2.5f, 2.5f, 2.4f});
        table.setSpacingBefore(10);
        
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
    }
}
