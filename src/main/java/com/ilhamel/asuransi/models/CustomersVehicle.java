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
public class CustomersVehicle {
    @Id
    @Column(name = "VehiclePlate", nullable = false, length = 10)
    private String id;

    @Column(name = "VehicleType", nullable = false, length = 20)
    private String vehicleType;

    @Column(name = "VehicleRegistration", nullable = false, length = 10)
    private String vehicleRegistration;

    @Column(name = "VehicleBrand", nullable = false, length = 20)
    private String vehicleBrand;

    @Column(name = "VehicleModel", nullable = false, length = 20)
    private String vehicleModel;

    @Column(name = "VehicleColor", nullable = false, length = 20)
    private String vehicleColor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NasabahId", nullable = false)
    private Nasabah nasabah;

    @OneToMany(mappedBy = "vehiclePlate")
    private Set<PolicyVehicle> policyVehicles = new LinkedHashSet<>();

    public CustomersVehicle(String id, String vehicleType, String vehicleRegistration, String vehicleBrand, String vehicleModel, String vehicleColor, Nasabah nasabah) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.vehicleRegistration = vehicleRegistration;
        this.vehicleBrand = vehicleBrand;
        this.vehicleModel = vehicleModel;
        this.vehicleColor = vehicleColor;
        this.nasabah = nasabah;
    }
}