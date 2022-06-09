package com.ilhamel.asuransi.dtos.nasabah;

import com.ilhamel.asuransi.models.Nasabah;
import com.ilhamel.asuransi.models.Prospect;
import lombok.Data;

import java.io.Serializable;

@Data
public class UpsertNasabahDto implements Serializable {
    private final String identityId;
    private final String familyStatus;
    private final String paymentMethod;

    public Nasabah toModel(String nasabahId,Prospect prospect) {
        return new Nasabah(
                nasabahId,
                identityId,
                familyStatus,
                paymentMethod,
                prospect
        );
    }

    public Nasabah setValue(Nasabah data) {
        data.setIdentityId(identityId);
        data.setFamilyStatus(familyStatus);
        data.setPaymentMethod(paymentMethod);
        return data;
    }
}
