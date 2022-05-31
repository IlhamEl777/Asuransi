package com.ilhamel.asuransi.dtos.policLife;

import com.ilhamel.asuransi.models.PolicyLife;
import lombok.Data;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

@Data
public class PolicyLifeHeaderDto implements Serializable {
    private final Integer id;
    private final Integer productId;
    private final String nasabahId;
    private final String insuredNasabahId;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public static List<PolicyLifeHeaderDto> toList(List<PolicyLife> policyLives) {
        if (policyLives.isEmpty()) {
            throw new EntityNotFoundException("Tidak ada data");
        }

        Stream<PolicyLifeHeaderDto> stream = policyLives.stream().map(PolicyLifeHeaderDto::set);

        return stream.toList();

    }

    public static PolicyLifeHeaderDto set(PolicyLife policyLife) {
        return new PolicyLifeHeaderDto(
                policyLife.getId(),
                policyLife.getProduct().getId(),
                policyLife.getNasabah().getId(),
                policyLife.getInsuredNasabah().getId(),
                policyLife.getStartDate(),
                policyLife.getEndDate()
        );
    }

}
