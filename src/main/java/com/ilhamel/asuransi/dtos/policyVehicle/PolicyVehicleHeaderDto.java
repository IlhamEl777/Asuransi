package com.ilhamel.asuransi.dtos.policyVehicle;

import com.ilhamel.asuransi.models.PolicyVehicle;
import lombok.Data;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

@Data
public class PolicyVehicleHeaderDto implements Serializable {
    private final Integer id;
    private final Integer productId;
    private final String vehiclePlateId;
    private final String FullName;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public static List<PolicyVehicleHeaderDto> toList(List<PolicyVehicle> policyVehicles) {
        if(policyVehicles.isEmpty()){
            throw new EntityNotFoundException("Data Tidak Ditemukan");
        }

        Stream<PolicyVehicleHeaderDto> result = policyVehicles.stream().map(PolicyVehicleHeaderDto::set);

        return result.toList();

    }

    public static PolicyVehicleHeaderDto set(PolicyVehicle policyVehicle) {
        return new PolicyVehicleHeaderDto(
                policyVehicle.getId(),
                policyVehicle.getProduct().getId(),
                policyVehicle.getVehiclePlate().getId(),
                policyVehicle.getVehiclePlate().getNasabah().getProspect().getFullName(),
                policyVehicle.getStartDate(),
                policyVehicle.getEndDate()
        );
    }
}
