package services;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import models.Activite;
import models.Excursion;

public class PDFGenerator {

    public static void generateActivitePDF(List<Activite> activites) throws FileNotFoundException, DocumentException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\DELL\\Desktop\\Activite PDF\\listaa2.pdf"));
        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, Font.BOLD);
        Paragraph para = new Paragraph("Liste des activites", font);
        para.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(para);
        document.add(new Paragraph("\n"));
        font = FontFactory.getFont(FontFactory.COURIER, 12, Font.NORMAL);
        float somme =0;
        for (Activite a : activites) {
            
            somme = somme + a.getPrixActivite();
            document.add(new Paragraph("Nom d'activite: " + a.getNomActivite(), font));
            document.add(new Paragraph("Type d'activite: " + a.getTypeActivite(), font));
            document.add(new Paragraph("Prix d'activite: " + a.getPrixActivite() + " Dinars", font));
           document.add(new Paragraph("----------------------------------------------------------- " ));

             document.add(new Paragraph("CAISSE(activite) "+somme ));
             

            
            
            document.add(new Paragraph("\n"));
        }
        document.close();
    }
    
    
    public static void generateExcursionPDF(List<Excursion> excursions) throws FileNotFoundException, DocumentException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\DELL\\Desktop\\Excursion pdf\\listaa2.pdf"));
        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, Font.BOLD);
        Paragraph para = new Paragraph("Liste des Excursions", font);
        para.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(para);
        document.add(new Paragraph("\n"));
        font = FontFactory.getFont(FontFactory.COURIER, 12, Font.NORMAL);
        for (Excursion a : excursions) {
            document.add(new Paragraph("Type de l'excursion: " + a.getTypeExcursion(), font));
            document.add(new Paragraph("Nb Personnes: " + a.getNbPersonnes(), font));
            document.add(new Paragraph("Prix Unitaire de l'excursion: " + a.getPrixUnitaire() + " DH", font));
            document.add(new Paragraph("\n"));
        }
        document.close();
    }
}