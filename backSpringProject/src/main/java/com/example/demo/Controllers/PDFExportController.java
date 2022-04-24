package com.example.demo.Controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Models.Abonnement;
import com.example.demo.Services.AbonnementService;
import com.example.demo.Services.PDFGeneratorService;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class PDFExportController {

	private final PDFGeneratorService pdfGeneratorService;
	@Autowired  
	AbonnementService abonService;

    public PDFExportController(PDFGeneratorService pdfGeneratorService) {
        this.pdfGeneratorService = pdfGeneratorService;
    }

    @GetMapping("/pdf/generate/{id}")
    public void generatePDF(HttpServletResponse response, @PathVariable Long id) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
        Abonnement abon = abonService.getAbonnement(id); 
        this.pdfGeneratorService.export(response,abon);
    }
}
