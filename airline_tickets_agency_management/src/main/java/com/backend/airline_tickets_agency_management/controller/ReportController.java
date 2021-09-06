package com.backend.airline_tickets_agency_management.controller;

import com.backend.airline_tickets_agency_management.model.dto.report.IReportDto;
import com.backend.airline_tickets_agency_management.model.service.report.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("api/reports")
public class ReportController {
    @Autowired
    IReportService reportService;

    @GetMapping("/get-all")
    public ResponseEntity<List<IReportDto>> getAll() {
        List<IReportDto> reports = reportService.getAll();
        if (reports.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }
}
