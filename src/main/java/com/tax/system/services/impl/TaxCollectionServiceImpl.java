package com.tax.system.services.impl;

import com.tax.system.entities.TaxRecord;
import com.tax.system.repositories.TaxRecordRepository;
import com.tax.system.services.TaxCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxCollectionServiceImpl implements TaxCollectionService {

    private final TaxRecordRepository taxRecordRepository;

    @Autowired
    public TaxCollectionServiceImpl(TaxRecordRepository taxRecordRepository) {
        this.taxRecordRepository = taxRecordRepository;
    }

    @Override
    public void saveTaxRecord(TaxRecord taxRecord) {
        taxRecordRepository.save(taxRecord);
    }
}
