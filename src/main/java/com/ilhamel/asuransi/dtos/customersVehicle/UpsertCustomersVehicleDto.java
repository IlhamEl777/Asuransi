package com.ilhamel.asuransi.dtos.customersVehicle;

import com.ilhamel.asuransi.models.CustomersVehicle;
import com.ilhamel.asuransi.models.Nasabah;
import lombok.Data;

import java.io.Serializable;

@Data
public class UpsertCustomersVehicleDto implements Serializable {
    private final String vehiclePlate;
    private final String vehicleType;
    private final String vehicleRegistration;
    private final String vehicleBrand;
    private final String vehicleModel;
    private final String vehicleColor;

    public CustomersVehicle toModel(Nasabah nasabah) {
        return new CustomersVehicle(
                vehiclePlate,
                vehicleType,
                vehicleRegistration,
                vehicleBrand,
                vehicleModel,
                vehicleColor,
                nasabah);
    }

    public CustomersVehicle setValue(CustomersVehicle data) {
        data.setVehicleType(vehicleType);
        data.setVehicleRegistration(vehicleRegistration);
        data.setVehicleBrand(vehicleBrand);
        data.setVehicleModel(vehicleModel);
        data.setVehicleColor(vehicleColor);
        return data;
    }
}
