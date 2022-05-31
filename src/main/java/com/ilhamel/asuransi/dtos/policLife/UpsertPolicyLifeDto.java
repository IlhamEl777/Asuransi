package com.ilhamel.asuransi.dtos.policLife;

import com.ilhamel.asuransi.models.Nasabah;
import com.ilhamel.asuransi.models.PolicyLife;
import com.ilhamel.asuransi.models.Product;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class UpsertPolicyLifeDto implements Serializable {
    private final Integer productId;
    private final String nasabahId;
    private final String insuredNasabahId;

    public PolicyLife toModel(Nasabah nasabah, Nasabah insuerdNasabah,Product product) {
        return new PolicyLife(
                product,
                nasabah,
                insuerdNasabah,
                LocalDate.now());
    }

    public void setValue(PolicyLife data, Product product, Nasabah nasabah, Nasabah insuredNasabah) {
        data.setProduct(product);
        data.setNasabah(nasabah);
        data.setInsuredNasabah(insuredNasabah);
    }
}
