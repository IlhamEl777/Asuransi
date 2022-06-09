package com.ilhamel.asuransi.dtos.policyVehicle;

import com.ilhamel.asuransi.models.CustomersVehicle;
import com.ilhamel.asuransi.models.PolicyVehicle;
import com.ilhamel.asuransi.models.Product;
import lombok.Data;

import java.io.Serializable;

@Data
public class UpsertPolicyVehicleDto implements Serializable {
    private final Integer productId;
    private final String vehiclePlateId;

    public PolicyVehicle toModel(Product product, CustomersVehicle customersVehicle) {
        return new PolicyVehicle(
                product,
                customersVehicle
        );
    }

    public PolicyVehicle setValue(CustomersVehicle data, PolicyVehicle policyVehicle, Product product) {
        policyVehicle.setProduct(product);
        policyVehicle.setVehiclePlate(data);
        return policyVehicle;
    }
}
