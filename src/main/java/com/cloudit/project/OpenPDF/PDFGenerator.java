package com.cloudit.project.OpenPDF;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import com.cloudit.project.model.Employe;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.*;
import jakarta.servlet.http.HttpServletResponse;

import javax.swing.*;

public class PDFGenerator {
    private Employe employe ;
    public void generate(HttpServletResponse response) throws DocumentException, IOException {

        // Creating the Object of Document
        Document document = new Document(PageSize.A4);

        // Getting instance of PdfWriter
        PdfWriter.getInstance(document, response.getOutputStream());

        // Opening the created document to modify it
        document.open();

        // Creating font
        // Setting font style and size
        Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontTiltle.setSize(20);
Font fontMont = FontFactory.getFont((FontFactory.TIMES_ROMAN));
fontMont.setSize(15);
        // Creating paragraph
        Paragraph paragraph = new Paragraph("BULLETIN DE PAIE", fontTiltle);
        Paragraph paragraphtab = new Paragraph(" ", fontTiltle);
        // Aligning the paragraph in document
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        // Adding the created paragraph in document
        document.add(paragraph);

        DateFormat dateFormat = new SimpleDateFormat("MMMM YYYY");
        String currentDateTime = dateFormat.format(new Date());
        Paragraph paragraph2 = new Paragraph("MOIS :"+  currentDateTime,fontMont);
        paragraph2.setAlignment(Paragraph.ALIGN_RIGHT);
        document.add(paragraph2);


        // Creating a table of 3 columns
        PdfPTable table = new PdfPTable(2);
        PdfPTable table2 = new PdfPTable(3);
        PdfPTable table3 = new PdfPTable(3);
        PdfPTable table4 = new PdfPTable(2);

        // Setting width of table, its columns and spacing
        table.setWidthPercentage(100f);
        table.setWidths(new int[] { 3, 3 });
        table.setSpacingBefore(5);

        table2.setWidthPercentage(100f);
        table2.setWidths(new int[] { 3, 3 ,3});
        table2.setSpacingBefore(5);

        table3.setWidthPercentage(100f);
        table3.setWidths(new int[] { 3, 3 ,3});
        table3.setSpacingBefore(5);

        table4.setWidthPercentage(100f);
        table4.setWidths(new int[] { 3, 3});
        table4.setSpacingBefore(5);

        // Create Table Cells for table header
        PdfPCell cell = new PdfPCell();

        // Setting the background color and padding
        cell.setBackgroundColor(CMYKColor.BLUE);
        cell.setPadding(5);

        // Creating font
        // Setting font style and size
        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        font.setColor(CMYKColor.WHITE);

        // Adding headings in the created table cell/ header
        // Adding Cell to table
        cell.setPhrase(new Phrase("NOM ET PRENOM", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("QUALIFICATION", font));
        table.addCell(cell);

        table.addCell(employe.getNom_emp() +" "+ employe.getPrenom_emp());
        // Adding student name
        table.addCell(employe.getPoste().getDesgPoste());

        cell.setPhrase(new Phrase("NUMÉRO PIÈCE D'IDENTITÉ" ,font));
        table2.addCell(cell);
        cell.setPhrase(new Phrase("NUMÉRO SÉCURITÉ SOCIALE",font));
        table2.addCell(cell);
        cell.setPhrase(new Phrase("NUMÉRO CARTE BANCAIRE",font));
        table2.addCell(cell);
            DecimalFormat df = new DecimalFormat("#");

        table2.addCell(String.valueOf(df.format(employe.getPieceIdentite().getNum_pieceid())));
        table2.addCell(String.valueOf(df.format(employe.getNum_ss_emp())));
        table2.addCell(String.valueOf(df.format(employe.getNum_cb_emp())));

        cell.setPhrase(new Phrase("LIBELLE", font));
        table3.addCell(cell);
        cell.setPhrase(new Phrase("NBRE", font));
        table3.addCell(cell);
        cell.setPhrase(new Phrase("MONTANT", font));
        table3.addCell(cell);

        table3.addCell("SALAIRE DE BASE");
        table3.addCell("24");
        table3.addCell(String.valueOf(employe.getGrade().getSalaire_base()));

        table3.addCell("ABSENCE");
        table3.addCell(String.valueOf(employe.getAbsences().size()));
        table3.addCell((String.valueOf((employe.getGrade().getSalaire_base()/24)*employe.getAbsences().size())));

        cell.setPhrase(new Phrase("SIGNATURE", font));
        table4.addCell(cell);
        cell.setPhrase(new Phrase("NET A PAYER", font));
        table4.addCell(cell);
        table4.addCell("\n\n\n");
        table4.addCell(String.valueOf(((employe.getGrade().getSalaire_base())-((employe.getGrade().getSalaire_base()/24)*employe.getAbsences().size()))));


        // Adding the created table to document
            document.add(table);
            document.add(paragraphtab);
        document.add(table2);
            document.add(paragraphtab);

            document.add(table3);
        document.add(paragraphtab);

            document.add(table4);

        // Closing the document
        document.close();

    }


    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
}
