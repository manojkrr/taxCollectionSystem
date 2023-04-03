package com.tax.system.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@Table(name = "TAX_RECORD")
public class TaxRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TAX_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name = "TAX_YEAR")
    private int taxYear;

    @Column(name = "TAXABLE_INCOME")
    private BigDecimal taxableIncome;

    @Column(name = "TAX_AMOUNT")
    private BigDecimal taxAmount;
}
