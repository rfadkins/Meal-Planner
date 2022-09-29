package com.techelevator.controller;

import com.techelevator.business.IngredientService;
import com.techelevator.business.PDFMakerService;
import com.techelevator.business.PDFServlet;
import com.techelevator.model.Ingredient;
import com.techelevator.model.UserSavedRecipes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.util.List;

@RestController
public class PDFController {

    @Autowired
    IngredientService ingredientService;
    @Autowired
    PDFMakerService pdfMakerService;

    @GetMapping(value="/ingredients/print&7D", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> printIngredients(){

        List<Ingredient> ingredients = ingredientService.getAllIngredients();
        ByteArrayInputStream input = PDFMakerService.createPDF(ingredients);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition",
                "inline; filename=ingredients.pdf");

      return ResponseEntity
              .ok()
              .headers(headers)
              .contentType(MediaType.APPLICATION_PDF)
              .body(new InputStreamResource(input));
    }

}
