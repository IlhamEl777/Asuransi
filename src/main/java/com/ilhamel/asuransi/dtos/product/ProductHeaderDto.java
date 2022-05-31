package com.ilhamel.asuransi.dtos.product;

import com.ilhamel.asuransi.models.Product;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

@Data
public class ProductHeaderDto implements Serializable {
    private final Integer id;
    private final String productName;
    private final String productType;
    private final String frekuensi;
    private final BigDecimal paymentFee;
    private final String productBenefits;
    private final String terms;


    public static List<ProductHeaderDto> toList(List<Product> products) {
        if (products.isEmpty()) {
            throw new EntityNotFoundException("Data Tidak Ditemukan");
        }

        Stream<ProductHeaderDto> result = products.stream().map(ProductHeaderDto::set);

        return result.toList();
    }

    public static ProductHeaderDto set(Product product) {
        return new ProductHeaderDto(
                product.getId(),
                product.getProductName(),
                product.getProductType(),
                product.getFrekuensi(),
                product.getPaymentFee(),
                product.getProductBenefits(),
                product.getTerms()
        );
    }

}
