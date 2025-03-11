package com.createpdf;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfName;
import com.lowagie.text.pdf.PdfString;
import com.lowagie.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class CreatePDF {
    
    public static byte[] create(String content) {
        System.out.println("Creating PDF in memory");

        Document document = new Document();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        
        try {
            // Create PDF writer that writes to a ByteArrayOutputStream
            PdfWriter instance = PdfWriter.getInstance(document, byteArrayOutputStream);
            document.open();
            
            // Add metadata and content
            instance.getInfo().put(PdfName.CREATOR, new PdfString(Document.getVersion()));
            document.add(new Paragraph(content));
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
        
        // Return the byte array representing the PDF file
        return byteArrayOutputStream.toByteArray();
    }
}
