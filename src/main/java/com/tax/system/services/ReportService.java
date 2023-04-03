package com.tax.system.services;

import com.tax.system.entities.Report;
import com.tax.system.entities.TaxCollection;
import com.tax.system.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ReportService {

    List<Report> getAllReports();
    Report getReportById(Long id);
    void saveReport(Report report);
    void deleteReport(Long id);
}
