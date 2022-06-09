package com.ilhamel.asuransi.dtos.product;

import com.ilhamel.asuransi.models.Product;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class UpsertProductDto implements Serializable {
    private final String productName;
    private final String productType;
    private final String frekuensi;
    private final BigDecimal paymentFee;
    private final String productBenefits;
    private final String terms;

    public Product toModel() {
        return new Product(
                productName,
                productType,
                frekuensi,
                paymentFee,
                productBenefits,
                terms
        );
    }

    public Product setValue(Product product) {
        product.setProductName(productName);
        product.setProductType(productType);
        product.setFrekuensi(frekuensi);
        product.setPaymentFee(paymentFee);
        product.setProductBenefits(productBenefits);
        product.setTerms(terms);
        return product;
    }
}
