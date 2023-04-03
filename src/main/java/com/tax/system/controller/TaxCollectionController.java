package com.tax.system.controller;

import com.tax.system.services.TaxCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/taxcollection")
public class TaxCollectionController {

    private final TaxCollectionService taxCollectionService;

    @Autowired
    public TaxCollectionController(TaxCollectionService taxCollectionService) {
        this.taxCollectionService = taxCollectionService;
    }

    @GetMapping
    public String showTaxCollectionForm(Model model) {
        model.addAttribute("taxRecord", new TaxRecord());
        return "taxcollection";
    }

    @PostMapping
    public String processTaxCollectionForm(TaxRecord taxRecord) {
        taxCollectionService.saveTaxRecord(taxRecord);
        return "redirect:/taxcollection";
    }
}
