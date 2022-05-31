package com.ilhamel.asuransi.repositories;

import com.ilhamel.asuransi.models.CustomersVehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersVehicleRepository extends JpaRepository<CustomersVehicle, String> {
}