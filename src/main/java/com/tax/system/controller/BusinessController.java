package com.tax.system.controller;

import com.tax.system.entities.Business;
import com.tax.system.services.BusinessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/businesses")
@Slf4j
public class BusinessController {

    private final BusinessService businessService;

    @Autowired
    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @GetMapping
    public String list(Model model) {
        List<Business> businesses = businessService.getAllBusinesses();
        model.addAttribute("businesses", businesses);
        return "business/index";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable Long id, Model model) {
        Optional<Business> business = businessService.getBusinessById(id);
        if(business.isPresent()){
            model.addAttribute("business", business.get());
        } else {
            model.addAttribute("error","Business not found");
        }
        return "business/show";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        Business business = new Business();
        model.addAttribute("business", business);
        return "business/new";
    }

    @PostMapping
    public String create(Business business, BindingResult result) {
        if (result.hasErrors()) {
            return "new";
        }
        businessService.createBusiness(business);
        return "redirect:/businesses";
    }

    @GetMapping("/edit/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        Optional<Business> business = businessService.getBusinessById(id);
        if(business.isPresent()){
            model.addAttribute("business", business.get());
        } else {
            model.addAttribute("error","Business not found");
        }
        return "business/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable Long id, Business business, BindingResult result) {
        if (result.hasErrors()) {
            return "business/edit";
        }
        business.setId(id);
        businessService.updateBusiness(business);
        return "redirect:/businesses";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        businessService.deleteBusinessById(id);
        return "redirect:/businesses";
    }
}
