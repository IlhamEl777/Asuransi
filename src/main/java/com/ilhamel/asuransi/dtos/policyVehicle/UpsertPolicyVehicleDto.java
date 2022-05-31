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

    public void setValue(CustomersVehicle data, PolicyVehicle policyVehicle, Product product) {
        if (this.productId != null) {
            policyVehicle.setProduct(product);
        }
        if (this.vehiclePlateId != null) {
            policyVehicle.setVehiclePlate(data);
        }
    }
}
