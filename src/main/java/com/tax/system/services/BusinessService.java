package com.tax.system.services;

import com.tax.system.entities.Business;

import java.util.List;
import java.util.Optional;

public interface BusinessService {
    List<Business> getAllBusinesses();
    Optional<Business> getBusinessById(Long id);
    void createBusiness(Business business);
    void updateBusiness(Business business);
    void deleteBusinessById(Long id);
}
