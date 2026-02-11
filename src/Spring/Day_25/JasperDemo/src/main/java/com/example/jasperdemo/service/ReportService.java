package com.example.jasperdemo.service;

import com.example.jasperdemo.model.Employee;
import com.example.jasperdemo.repository.EmployeeRepo;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class ReportService {

    private EmployeeRepo employeeRepo;

    public ReportService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        List<Employee> employees = employeeRepo.findAll();
        // load file
        File file = ResourceUtils.getFile("classpath:employess.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdby", "shivam shukla");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if(reportFormat.equalsIgnoreCase("html")){
            JasperExportManager.exportReportToHtmlFile(jasperPrint, "D:\\practice_jasper_reports"+"\\employees.html");
        }
        if(reportFormat.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToPdfFile(jasperPrint, "D:\\practice_jasper_reports\\employees.pdf");

        }

        if (reportFormat.equalsIgnoreCase("excel")) {
            JRXlsxExporter exporter = new JRXlsxExporter();
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(
                    new SimpleOutputStreamExporterOutput(
                            "D:\\practice_jasper_reports\\employees1.xlsx"
                    )
            );

//            SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
//            configuration.setDetectCellType(true);
//            configuration.setCollapseRowSpan(false);
//            exporter.setConfiguration(configuration);

            exporter.exportReport();
        }

        if (reportFormat.equalsIgnoreCase("csv")) {
            JRCsvExporter exporter = new JRCsvExporter();
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(
                    new SimpleWriterExporterOutput(
                            "D:\\practice_jasper_reports\\employees.csv"
                    )
            );
            exporter.exportReport();
        }

        return "report generated in path->"+ "D:\\practice_jasper_reports";
    }
}
