package com.ilhamel.asuransi.repositories;

import com.ilhamel.asuransi.models.PolicyVehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyVehicleRepository extends JpaRepository<PolicyVehicle, Integer> {
}