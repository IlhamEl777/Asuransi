package com.ilhamel.asuransi.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class PolicyLife {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TransactionId", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ProductId", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NasabahId", nullable = false)
    private Nasabah nasabah;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "InsuredNasabah", nullable = false)
    private Nasabah insuredNasabah;

    @Column(name = "StartDate", nullable = false)
    private LocalDate startDate;

    @Column(name = "EndDate")
    private LocalDate endDate;

    public PolicyLife(Product product, Nasabah nasabah, Nasabah insuredNasabah, LocalDate startDate) {
        this.product = product;
        this.nasabah = nasabah;
        this.insuredNasabah = insuredNasabah;
        this.startDate = startDate;
    }
}