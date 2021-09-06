package com.backend.airline_tickets_agency_management.model.service.report;

import com.backend.airline_tickets_agency_management.model.dto.report.IReportDto;
import com.backend.airline_tickets_agency_management.model.repository.report.IReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReportService implements IReportService{
    @Autowired
    IReportRepository reportRepository;
    @Override
    public List<IReportDto> getAll() {
        return reportRepository.getAll();
    }
}
