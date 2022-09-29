package com.techelevator.business;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.styledxmlparser.jsoup.nodes.Element;
import com.techelevator.model.Ingredient;
import com.techelevator.model.UserSavedRecipes;
import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.Principal;
import java.util.List;

import static com.itextpdf.kernel.colors.ColorConstants.LIGHT_GRAY;
import static com.itextpdf.layout.properties.HorizontalAlignment.CENTER;
import static javax.swing.text.StyleConstants.Alignment;

@Service
public class PDFMakerService {
    @Autowired
    UserOwnershipService userOwnershipService;
    private static final Logger logger = LoggerFactory.getLogger(PDFMakerService.class);

    public static ByteArrayInputStream createPDF(List<Ingredient> ingredients) {

        ByteArrayOutputStream output = new ByteArrayOutputStream();



       try {
            Table pdfTable = new Table(2);
            Cell headerCellIng = new Cell(2, 1);
            Cell headerCellCat = new Cell(2, 1);

            headerCellIng.add(new Paragraph("Ingredient"));
            headerCellIng.setBackgroundColor(LIGHT_GRAY)
                    .setBorderBottom(new SolidBorder(ColorConstants.BLACK, 2))
                    .setWidth(300)
                    .setTextAlignment(TextAlignment.CENTER);

            headerCellCat.add(new Paragraph("Category"));
            headerCellCat.setBackgroundColor(LIGHT_GRAY)
                    .setBorderBottom(new SolidBorder(ColorConstants.BLACK, 2))
                    .setWidth(200)
                    .setTextAlignment(TextAlignment.CENTER);

            pdfTable.addHeaderCell(headerCellIng);
            pdfTable.addHeaderCell(headerCellCat);

            pdfTable.setHorizontalAlignment( CENTER);

            for (Ingredient ingredient : ingredients) {
                pdfTable.addCell(ingredient.getIngredientName());
                pdfTable.addCell(ingredient.getIngredientCategory());
            }

            String username = getLoggedInUser();
            Paragraph title = new Paragraph("Pantry Stock");
            title.setFontSize(25)
                .setTextAlignment(TextAlignment.CENTER);

            PdfWriter writer = new PdfWriter(output);
            Document document = new Document(new PdfDocument(writer));
            document.add(title);
            document.add(pdfTable);
            document.close();

       } catch (Exception e) {
           e.printStackTrace();
       }
        return new ByteArrayInputStream(output.toByteArray());
   }

   private static String getLoggedInUser() {
        String username = "";
       Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       if(principal instanceof UserDetails) {
           username = ((UserDetails)principal).getUsername();

       } else {
           username = principal.toString();
       }

       return username;
   }


}
