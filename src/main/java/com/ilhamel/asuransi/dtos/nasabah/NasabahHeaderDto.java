package com.ilhamel.asuransi.dtos.nasabah;

import com.ilhamel.asuransi.models.Nasabah;
import lombok.Data;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

@Data
public class NasabahHeaderDto implements Serializable {
    private final String id;
    private final String FullName;
    private final LocalDate BirthDate;
    private final String BirthPlace;
    private final String Gender;
    private final String Job;
    private final String familyStatus;
    private final String paymentMethod;
    private final String KTP;


    public static NasabahHeaderDto set(Nasabah nasabah) {
        return new NasabahHeaderDto(
                nasabah.getId(),
                nasabah.getProspect().getFullName(),
                nasabah.getProspect().getBirthDate(),
                nasabah.getProspect().getBirthPlace(),
                nasabah.getProspect().getGender(),
                nasabah.getProspect().getJob(),
                nasabah.getFamilyStatus(),
                nasabah.getPaymentMethod(),
                nasabah.getIdentityId()
        );
    }

    public static List<NasabahHeaderDto> toList(List<Nasabah> nasabahs) {
        if (nasabahs.isEmpty()) {
            throw new EntityNotFoundException("Data Tidak Ditemukan");
        }

        Stream<NasabahHeaderDto> result = nasabahs.stream().map(NasabahHeaderDto::set);

        return result.toList();
    }
}
