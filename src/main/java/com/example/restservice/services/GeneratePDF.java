package com.example.restservice.services;

import com.example.restservice.models.OrderProductId;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.logging.Logger;

public class GeneratePDF {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(GeneratePDF.class);

    public static ByteArrayInputStream orderProductReport(List<OrderProductId> orderProducts) throws DocumentException {

        Document document = new Document();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(60);
        table.setWidths(new int[]{1,2,2});

        Font headFont = FontFactory.getFont(FontFactory.COURIER_BOLD);

        PdfPCell hcell;
        hcell = new PdfPCell(new Phrase("Id_order", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("Id_product", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        for(OrderProductId orderProductId : orderProducts){

            PdfPCell cell;

            cell = new PdfPCell(new Phrase(orderProductId.getIdOrder().toString()));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(orderProductId.getIdProduct().toString()));
            cell.setPaddingLeft(5);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell);


        }

        PdfWriter.getInstance(document, outputStream);
        document.open();
        document.add(table);
        document.close();

        return new ByteArrayInputStream(outputStream.toByteArray());
    }
}
