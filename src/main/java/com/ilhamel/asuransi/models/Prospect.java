package com.ilhamel.asuransi.models;

import lombok.*;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Prospect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProspectId", nullable = false)
    private Integer id;

    @Column(name = "FirstName", nullable = false, length = 50)
    private String firstName;

    @Column(name = "LastName", length = 50)
    private String lastName;

    @Column(name = "BirthDate", nullable = false)
    private LocalDate birthDate;

    @Column(name = "BirthPlace", nullable = false, length = 50)
    private String birthPlace;

    @Column(name = "Gender", nullable = false, length = 10)
    private String gender;

    @Column(name = "Job", length = 50)
    private String job;

    @OneToMany(mappedBy = "prospect")
    private Set<Nasabah> nasabahs = new LinkedHashSet<>();


    @Formula("CONCAT(FirstName, ' ', LastName)")
    private String fullName;

    public Prospect(String firstName, String lastName, LocalDate birthDate, String birthPlace, String gender, String job) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.gender = gender;
        this.job = job;
    }
}