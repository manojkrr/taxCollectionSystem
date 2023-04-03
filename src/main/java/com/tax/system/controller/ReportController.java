package com.tax.system.controller;

import com.tax.system.entities.Report;
import com.tax.system.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public String listReports(Model model) {
        List<Report> reports = reportService.getAllReports();
        model.addAttribute("reports", reports);
        return "listReports";
    }

    @GetMapping("/add")
    public String showReportForm(Model model) {
        Report report = new Report();
        model.addAttribute("report", report);
        return "reportForm";
    }

    @PostMapping("/save")
    public String saveReport(@ModelAttribute("report") Report report) {
        reportService.saveReport(report);
        return "redirect:/report";
    }

    @GetMapping("/delete/{id}")
    public String deleteReport(@PathVariable(value = "id") Long id) {
        reportService.deleteReport(id);
        return "redirect:/report";
    }
}
