package com.ilhamel.asuransi.models;

import com.ilhamel.asuransi.dtos.product.UpsertProductDto;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductId", nullable = false)
    private Integer id;

    @Column(name = "ProductName", nullable = false, length = 50)
    private String productName;

    @Column(name = "ProductType", nullable = false, length = 10)
    private String productType;

    @Column(name = "Frekuensi", nullable = false, length = 7)
    private String frekuensi;

    @Column(name = "PaymentFee", nullable = false, precision = 19, scale = 4)
    private BigDecimal paymentFee;

    @Column(name = "ProductBenefits", length = 300)
    private String productBenefits;

    @Column(name = "Terms", length = 300)
    private String terms;

    @OneToMany(mappedBy = "product")
    private Set<PolicyLife> policyLifes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "product")
    private Set<PolicyVehicle> policyVehicles = new LinkedHashSet<>();

    public Product(String productName, String productType, String frekuensi, BigDecimal paymentFee, String productBenefits, String terms) {
        this.productName = productName;
        this.productType = productType;
        this.frekuensi = frekuensi;
        this.paymentFee = paymentFee;
        this.productBenefits = productBenefits;
        this.terms = terms;
    }

}