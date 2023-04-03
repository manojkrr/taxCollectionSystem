package com.tax.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class ViewController {

    @GetMapping
    public String index(Model model) {
        model.addAttribute("message", "File Your Taxes");
        return "index";
    }
}
