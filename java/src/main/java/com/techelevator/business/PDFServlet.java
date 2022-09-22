package com.techelevator.business;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.techelevator.model.User;
import com.techelevator.model.UserSavedIngredients;
import com.techelevator.repository.UserRepository;
import com.techelevator.repository.UserSavedIngredientsRepository;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PDFServlet extends HttpServlet {
    UserSavedIngredientsRepository userSavedIngredientsRepository;
    UserRepository userRepository;

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get the text that will be added to the PDF

        //List<Integer> intList = Arrays.asList(1, 2, 3);
        User user = userRepository.findByUsername(request.getUserPrincipal().getName());
        List<UserSavedIngredients> ingredientList = userSavedIngredientsRepository.findAllByUser(user);
        String result = ingredientList.stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining("\r\n", "{", "}"));

        System.out.println(result);
        String text = request.getParameter("text");

        if (text == null || text.trim().length() == 0) {
            text = "You didn't enter any text.";
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(baos));

        Document doc = new Document(pdfDoc);
//        doc.add(new Paragraph(String.format(
//                "You have submitted the following text using the %s method:",
//                request.getMethod())));
        doc.add(new Paragraph(result));
        doc.close();

        // setting some response headers
        response.setHeader("Expires", "0");
        response.setHeader("Cache-Control",
                "must-revalidate, post-check=0, pre-check=0");
        response.setHeader("Pragma", "public");

        // setting the content type
        response.setContentType("application/pdf");

        // the contentlength
        response.setContentLength(baos.size());

        // write ByteArrayOutputStream to the ServletOutputStream
        OutputStream os = response.getOutputStream();
        baos.writeTo(os);
        os.flush();
        os.close();
    }

    public void createPDF() {

    }
}
