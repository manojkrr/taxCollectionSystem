package com.tax.system.services.impl;

import com.tax.system.entities.Business;
import com.tax.system.repositories.BusinessRepository;
import com.tax.system.services.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private BusinessRepository businessRepository;

    @Override
    public List<Business> getAllBusinesses() {
        return businessRepository.findAll();
    }

    @Override
    public Optional<Business> getBusinessById(Long id) {
        return businessRepository.findById(id);
    }

    @Override
    public void createBusiness(Business business) {
        businessRepository.save(business);
    }

    @Override
    public void updateBusiness(Business business) {
        businessRepository.save(business);
    }

    @Override
    public void deleteBusinessById(Long id) {
        businessRepository.deleteById(id);
    }
}
