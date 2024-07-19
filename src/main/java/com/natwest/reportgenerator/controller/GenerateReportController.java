package com.natwest.reportgenerator.controller;

import com.natwest.reportgenerator.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller Class for generating report
 */
@RestController
public class GenerateReportController {

    /**
     * Autowired reportService bean
     */
    @Autowired
    private ReportService reportService;

    /**
     * @param format
     * @return
     */
    @PostMapping("/generateReport/{format}")
    public ResponseEntity<String> generateReport(@PathVariable String format) {
        reportService.setFormat(format);
        boolean resp = reportService.generateOutputReport();
        if (resp)
            return new ResponseEntity<>("GENERATED", HttpStatus.CREATED);
        else
            return new ResponseEntity<>("CHECK FILE PROPERLY", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
