package com.ilhamel.asuransi.dtos.customersVehicle;

import com.ilhamel.asuransi.models.CustomersVehicle;
import lombok.Data;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Stream;

@Data
public class CustomersVehicleHeaderDto implements Serializable {
    private final String id;
    private final String vehicleType;
    private final String vehicleRegistration;
    private final String vehicleBrand;
    private final String vehicleModel;
    private final String vehicleColor;
    private final String nasabahId;

    public static List<CustomersVehicleHeaderDto> toList(List<CustomersVehicle> customersVehicles) {
        if (customersVehicles.isEmpty()){
            throw new EntityNotFoundException("Data Tidak Ditemukan");
        }

        Stream<CustomersVehicleHeaderDto> result = customersVehicles.stream().map(CustomersVehicleHeaderDto::set);

        return result.toList();
    }

    public static CustomersVehicleHeaderDto set(CustomersVehicle customersVehicle) {
        return new CustomersVehicleHeaderDto(
                customersVehicle.getId(),
                customersVehicle.getVehicleType(),
                customersVehicle.getVehicleRegistration(),
                customersVehicle.getVehicleBrand(),
                customersVehicle.getVehicleModel(),
                customersVehicle.getVehicleColor(),
                customersVehicle.getNasabah().getId()
        );
    }
}
