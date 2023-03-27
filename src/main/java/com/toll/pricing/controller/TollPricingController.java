package com.toll.pricing.controller;

import com.toll.pricing.domain.CostOfTrip;
import com.toll.pricing.service.TollPricingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/toll")
@Slf4j
public class TollPricingController {

    private final TollPricingService tollPricingService;

    @Autowired
    public TollPricingController(TollPricingService tollPricingService) {
        this.tollPricingService = tollPricingService;
    }

    @GetMapping("/entry/{entryLocationName}/exit/{exitLocationName}")
    @ResponseBody
    public CostOfTrip getTotalCostOfTrip(@PathVariable("entryLocationName") String entryLocationName,
                                         @PathVariable("exitLocationName") String exitLocationName) {
        log.info("Received Request to calculate Total Toll Charges from entry location={} to exit location={}", entryLocationName, exitLocationName);
        return tollPricingService.getCostOfTrip(entryLocationName, exitLocationName);
    }

}
