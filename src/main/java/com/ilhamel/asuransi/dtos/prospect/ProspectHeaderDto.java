package com.ilhamel.asuransi.dtos.prospect;

import com.ilhamel.asuransi.models.Prospect;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

@Data
public class ProspectHeaderDto implements Serializable {
    private final Integer id;
    private final String fullName;
    private final LocalDate birthDate;
    private final String birthPlace;
    private final String gender;
    private final String job;

    public static List<ProspectHeaderDto> toList(List<Prospect> prospects) {
        if (prospects.isEmpty()){
            throw new EntityNotFoundException("Data Tidak Ditemukan");
        }

        Stream<ProspectHeaderDto> result = prospects.stream().map(ProspectHeaderDto::set);
        return result.toList();

    }

    public static ProspectHeaderDto set(Prospect prospect) {
        return new ProspectHeaderDto(
                prospect.getId(),
                prospect.getFirstName() + " " + prospect.getLastName(),
                prospect.getBirthDate(),
                prospect.getBirthPlace(),
                prospect.getGender(),
                prospect.getJob()
        );
    }
}
