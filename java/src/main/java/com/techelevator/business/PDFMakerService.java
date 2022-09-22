package com.techelevator.business;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.techelevator.model.UserSavedRecipes;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

@Service
public class PDFMakerService {
    //UserOwnershipService userOwnershipService;


//
////    String json = mapper.writeValueAsString(userSavedRecipes);
////
////    List<String> recipe = mapper.convertValue(mapper.readTree(), List.class);
//
//
//    public String makeThePDF() {
//        UserSavedRecipes userSavedRecipes = userOwnershipService.getUserSavedRecipe(3L);
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            String json = mapper.writeValueAsString(userSavedRecipes);
//            String recipe = mapper.convertValue(mapper.readTree(json), String.class);
//            return recipe;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//
//    }
//
//    public InputStream convert(String input) throws FileNotFoundException {
//
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        PdfWriter writer = new PdfWriter(out);
//        PdfDocument pdf = new PdfDocument(writer);
//        Document document = new Document(pdf);
//        document.add(new Paragraph(makeThePDF().toString()));
//        document.close();
//
//        return new ByteArrayInputStream(out.toByteArray());
//    }

}
