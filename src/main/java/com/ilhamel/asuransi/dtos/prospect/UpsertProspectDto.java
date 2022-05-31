package com.ilhamel.asuransi.dtos.prospect;

import com.ilhamel.asuransi.models.Prospect;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpsertProspectDto implements Serializable {
    private String firstName;
    private String lastName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private String birthPlace;
    private String gender;
    private String job;


    public Prospect toModel() {
        return new Prospect(
                firstName,
                lastName,
                birthDate,
                birthPlace,
                gender,
                job
        );
    }
}
