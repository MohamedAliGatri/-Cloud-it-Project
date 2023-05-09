package com.cloudit.project.controller;

import com.cloudit.project.OpenPDF.PDFGenerator;
import com.cloudit.project.Repository.EmployeRepo;
import com.cloudit.project.model.Employe;
import com.cloudit.project.service.EmployeServices;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.Document;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/employes/")
@CrossOrigin("*")
public class EmployeController {

    @Autowired
    private EmployeServices employeServices;
    @Autowired
    private EmployeRepo employeRepo;
    @GetMapping
    public List<Employe> getAllEmployes() {
        return employeServices.getAllEmployes();
    }

    @GetMapping("{id}")
    public Employe getEmployeById(@PathVariable Integer id) {
        return employeServices.getEmployeById(id);
    }
    @GetMapping("{id}/")
    public Employe getEmployeNumTEl(@PathVariable Double id) {
        return employeServices.getEmployeByNumTelEmp(id);
    }
    @GetMapping("abs")
    public List<Employe> getEmployeAbsences(){
        LocalDate localDate = LocalDate.now();
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return  employeServices.getAllEmployesAbsence(date);}
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employe addEmploye(@RequestBody Employe employe) {
        return employeServices.saveEmploye(employe);
    }
    @PutMapping("{id}")
    public Employe updateEmploye(@PathVariable Integer id, @RequestBody Employe employe) {
        employe.setMat_emp(id);
        return employeServices.updateEmploye(id,employe);
    }

    @DeleteMapping("{id}")
    public void deleteEmploye(@PathVariable Integer id) {
        employeServices.deleteEmploye(id);
    }

    @GetMapping("pdf/emp/{id}")
    public void generatePdf(HttpServletResponse response, @PathVariable Integer id) throws DocumentException, IOException {
        Employe employe = employeRepo.getById(id);
        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM");
        String currentDateTime = dateFormat.format(new Date());
        String headerkey = "Content-Disposition";
        String headervalue = "attachment; filename=" + employe.getNom_emp() + employe.getPrenom_emp() + currentDateTime + ".pdf";
        response.setHeader(headerkey, headervalue);
        PDFGenerator generator = new PDFGenerator();

        generator.setEmploye(employe);

        generator.generate(response);
    }

}