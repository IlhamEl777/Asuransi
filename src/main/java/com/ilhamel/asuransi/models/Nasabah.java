package com.ilhamel.asuransi.models;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Nasabah {
    @Id
    @Column(name = "NasabahId", nullable = false, length = 12)
    private String id;

    @Column(name = "IdentityId", nullable = false, length = 16)
    private String identityId;

    @Column(name = "FamilyStatus", nullable = false, length = 10)
    private String familyStatus;

    @Column(name = "PaymentMethod", nullable = false, length = 2)
    private String paymentMethod;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ProspectId", nullable = false)
    private Prospect prospect;

    @OneToMany(mappedBy = "nasabah")
    private Set<PolicyLife> policyLifeNasabahs = new LinkedHashSet<>();

    @OneToMany(mappedBy = "insuredNasabah")
    private Set<PolicyLife> policyLifeInsuredNasabahs = new LinkedHashSet<>();

    @OneToMany(mappedBy = "nasabah")
    private Set<CustomersVehicle> customersVehicles = new LinkedHashSet<>();

    public Nasabah(String id, String identityId, String familyStatus, String paymentMethod, Prospect prospect) {
        this.id = id;
        this.identityId = identityId;
        this.familyStatus = familyStatus;
        this.paymentMethod = paymentMethod;
        this.prospect = prospect;
    }

    public void setField(String field) {
        this.identityId = field;
        this.familyStatus = field;
        this.paymentMethod = field;
    }
}