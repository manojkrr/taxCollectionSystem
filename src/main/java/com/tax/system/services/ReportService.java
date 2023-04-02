package com.tax.system.services;

import com.tax.system.entities.Report;
import com.tax.system.entities.User;

import java.util.List;

public interface ReportService {

    Report saveReport(Report report);

    List<Report> getReportsByUser(User user);

    Report getReportByUserForTaxYear(User user, int taxYear);
}
