package com.example.asyncpractice.controller;

import com.example.asyncpractice.service.ReportService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class ReportController {
    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    public String report(Model model) throws ExecutionException, InterruptedException {
        Integer result = reportService.generateReport().get(); // .get() waits for result
        return "report"; // imaginary jsp
    }
}
