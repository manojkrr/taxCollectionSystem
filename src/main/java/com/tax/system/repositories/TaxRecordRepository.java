package com.tax.system.repositories;

import com.tax.system.entities.TaxCollection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxRecordRepository extends JpaRepository<TaxCollection, Long> {
}
