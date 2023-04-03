package com.tax.system.services.impl;

import jakarta.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tax.system.entities.TaxRecord;
import com.tax.system.services.TaxCollectionService;

@Service
public class TaxCollectionServiceImpl implements TaxCollectionService {

    private final EntityManager entityManager;

    @Autowired
    public TaxCollectionServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveTaxRecord(TaxRecord taxRecord) {
        entityManager.persist(taxRecord);
    }
}
