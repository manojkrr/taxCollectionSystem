package com.tax.system.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tax_collections")
@Data
@NoArgsConstructor
public class TaxCollection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_id", nullable = false)
    private Business business;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private String taxType;

    @Column(nullable = false)
    private String taxPeriod;

    @Column(nullable = false)
    private LocalDate paymentDate;

}
